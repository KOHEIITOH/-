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
import la.bean.ReserveBean;
import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.HotelDAO;
import la.dao.UserDAO;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			//HTMLから送信されたパラメータを取得
			String action = request.getParameter("action");
			//DAO生成
			UserDAO dao =new UserDAO();


			//表示------------------------------------------------
			if(action.equals("show")) {
			List<ReserveBean> list = dao.findAllReserve();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/MemberTop.jsp");
			}


			//変更------------------------------------------------
		else if(action.equals("update")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String user_name = request.getParameter("user_name");
			String user_address = request.getParameter("user_address");
			String user_tel = request.getParameter("user_tel");
			String user_email = request.getParameter("user_email");
			String birtday = request.getParameter("birtday");
			String membership_date = request.getParameter("membership_date");
			String withdrawal_date = request.getParameter("withdrawal_date");
			int user_password = Integer.parseInt(request.getParameter("user_password"));

			dao.UpdateUser(user_id, user_name, user_address, user_tel, user_email, birtday, membership_date, withdrawal_date,user_password);
			//daoのクラスSearchHotelを呼び出す
			List<UserBean>list = dao.SearchUser(user_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/MemberChange.jsp");
		}

			//削除------------------------------------------------
		else if(action.equals("delete")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));

			dao.DeleteUser(user_id);
					//削除後全表示
			// Listをリクエストスコープに入れてJSPへフォーワードする
			gotoPage(request, response, "/LoginTop.jsp");
		}

			//変更画面に情報を再取得し、遷移------------------------------------------------
		else if(action.equals("change")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			List<UserBean>list = dao.SearchUser(user_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/MemberChange.jsp");
			// Listをリクエストスコープに入れてJSPへフォーワードする
		}

			//変更画面に情報を再取得し、リザーブに遷移------------------------------------------------
		else if(action.equals("changeReserve")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			HttpSession session = request.getSession(false);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			session.setAttribute("itemsa", user_id);
			HotelDAO hotel =new HotelDAO();
			List<HotelBean> list = hotel.findAll();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/ReserveTop.jsp");
			// Listをリクエストスコープに入れてJSPへフォーワードする
		}
//
		else if(action.equals("changeMemberTop")) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			HttpSession session = request.getSession(false);

			// Listをリクエストスコープに入れてJSPへフォーワードする
			session.setAttribute("user_id", user_id);
			UserDAO userdao = new UserDAO();
			List<ReserveBean>list = userdao.SerchReserve(user_id);

			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/MemberTop.jsp");
			// Listをリクエストスコープに入れてJSPへフォーワードする
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