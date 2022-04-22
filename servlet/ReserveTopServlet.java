package la.servle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.HotelBean;
import la.dao.DAOException;
import la.dao.HotelDAO;
import la.dao.UserDAO;


@WebServlet("/ReserveTopServlet")
public class ReserveTopServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			//HTMLから送信されたパラメータを取得
			String action = request.getParameter("action");
			//DAO生成
			HotelDAO dao =new HotelDAO();


			//表示------------------------------------------------
			if(action.equals("show")) {
			List<HotelBean> list = dao.findAll();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			RequestDispatcher rd = request.getRequestDispatcher("/ReserveTop.jsp");
			rd.forward(request, response);
			}

			//検索------------------------------------------------
		else if(action.equals("search")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			//daoのクラスSearchHotelを呼び出す
			List<HotelBean>list = dao.SearchHotel(hotel_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/ReserveTop.jsp");
		}


			//削除------------------------------------------------
		else if(action.equals("delete")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			//daoのクラスSearchHotelを呼び出す
			dao.DeleteHotel(hotel_id);
					//削除後全表示
			List<HotelBean> list = dao.findAll();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/HotelTop.jsp");
		}

			//登録------------------------------------------------
		else if(action.equals("insert")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			String hotel_name = request.getParameter("hotel_name");
			int hotel_price = Integer.parseInt(request.getParameter("hotel_price"));
			String hotel_img = request.getParameter("hotel_img");
			String hotel_info = request.getParameter("hotel_info");
			String hotel_address = request.getParameter("hotel_address");
			String hotel_tel = request.getParameter("hotel_tel");
			String hotel_email = request.getParameter("hotel_email");
			//daoのクラスSearchHotelを呼び出す
			dao.InsertHotel(hotel_id, hotel_name, hotel_price, hotel_img, hotel_info, hotel_address, hotel_tel, hotel_email);
					//削除後全表示
			List<HotelBean> list = dao.findAll();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/HotelTop.jsp");
		}


			//変更------------------------------------------------
		else if(action.equals("update")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			String hotel_name = request.getParameter("hotel_name");
			int hotel_price = Integer.parseInt(request.getParameter("hotel_price"));
			String hotel_img = request.getParameter("hotel_img");
			String hotel_info = request.getParameter("hotel_info");
			String hotel_address = request.getParameter("hotel_address");
			String hotel_tel = request.getParameter("hotel_tel");
			String hotel_email = request.getParameter("hotel_email");


			dao.UpdateHotel(hotel_id, hotel_name, hotel_price, hotel_img, hotel_info, hotel_address, hotel_tel, hotel_email);
			//daoのクラスSearchHotelを呼び出す
			List<HotelBean>list = dao.SearchHotel(hotel_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/HotelTop.jsp");
		}

			//変更画面に情報を再取得し、遷移------------------------------------------------
		else if(action.equals("changeReserve")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			String hotel_name = request.getParameter("hotel_name");
			String hotel_img = request.getParameter("hotel_img");
			String hotel_address = request.getParameter("hotel_address");
			int hotel_price = Integer.parseInt(request.getParameter("hotel_price"));
			String hotel_tel = request.getParameter("hotel_tel");
			String hotel_email = request.getParameter("hotel_email");
			String hotel_info = request.getParameter("hotel_info");

			HttpSession session = request.getSession(false);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			session.setAttribute("itemsa", user_id);
			session.setAttribute("items", hotel_id);
			session.setAttribute("itemsw", hotel_name);
			session.setAttribute("itemi", hotel_img);
			session.setAttribute("itema", hotel_address);
			session.setAttribute("itemp", hotel_price);
			session.setAttribute("itemt", hotel_tel);
			session.setAttribute("iteme", hotel_email);
			session.setAttribute("itemin", hotel_info);
			gotoPage(request, response, "/Reserve.jsp");
			// Listをリクエストスコープに入れてJSPへフォーワードする
		}

			//登録------------------------------------------------
		else if(action.equals("reserve_travel")) {

			int hotel_reserve_id = Integer.parseInt(request.getParameter("hotel_reserve_id"));
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			String checkin_date = request.getParameter("checkin_date");
			String checkout_date = request.getParameter("checkout_date");
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			UserDAO userdao = new UserDAO();

			userdao.reserve_travel(hotel_reserve_id, hotel_id, checkin_date, checkout_date, user_id);

			HttpSession session = request.getSession(false);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			session.setAttribute("user_id", user_id);

			//daoのクラスSearchHotelを呼び出す


			// Listをリクエストスコープに入れてJSPへフォーワードする
			gotoPage(request, response, "/ReserveFinish.jsp");
		}


		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/Erorr.jsp");
			rd.forward(request, response);
		}
	}

		private void gotoPage(HttpServletRequest request,
				HttpServletResponse response, String page) throws ServletException,
				IOException {
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}