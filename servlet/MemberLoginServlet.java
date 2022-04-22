package la.servle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.UserLoginDAO;


@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {

//		private static final String USER = "jack";
//		private static final String PASS = "abc";
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				try {

					request.setCharacterEncoding("UTF-8");
					//HTMLから送信されたパラメータを取得
					String action = request.getParameter("action");
					//DAO生成
					UserLoginDAO dao = new UserLoginDAO();



			//登録------------------------------------------------
		 if(action.equals("insert")) {


			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String user_name = request.getParameter("user_name");
			String user_address = request.getParameter("user_address");
			String user_tel = request.getParameter("user_tel");
			String user_email = request.getParameter("user_email");
			String birthday = request.getParameter("birthday");
			String membership_date = request.getParameter("membership_date");
			String withdrawal_date = request.getParameter("withdrawal_date");
			int user_password = Integer.parseInt(request.getParameter("user_password"));
			dao.InsertUser(user_id, user_name, user_address, user_tel, user_email, birthday, membership_date, withdrawal_date,user_password);


			List<UserBean>list = dao.SearchUser(user_id);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("items", list);
			gotoPage(request, response, "/MemberRegister.jsp");
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