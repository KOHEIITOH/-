package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HotelBean;
import dao.DAOException;
import dao.HotelDAO;


@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
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
			RequestDispatcher rd = request.getRequestDispatcher("/HotelTop.jsp");
			rd.forward(request, response);
			}

			//検索------------------------------------------------
		else if(action.equals("search")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			//daoのクラスSearchHotelを呼び出す
			List<HotelBean>list = dao.SearchHotel(hotel_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/HotelTop.jsp");
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
		else if(action.equals("change")) {
			int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
			List<HotelBean>list = dao.SearchHotel(hotel_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/HotelChange.jsp");
			// Listをリクエストスコープに入れてJSPへフォーワードする

		}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
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