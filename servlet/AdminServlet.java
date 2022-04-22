package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminBean;
import dao.AdminDAO;
import dao.DAOException;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータの解析は特になし

		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			AdminDAO dao = new AdminDAO();

			//表示
			if(action == null || action.length() == 0) {
				List<AdminBean> list = dao.findAll();
				request.setAttribute("users", list);
				gotoPage(request, response, "/AdminTop.jsp");
			}

			//検索
			else if(action.equals("search")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				List<AdminBean> list = dao.findById(user_id);
				request.setAttribute("users", list);
				gotoPage(request, response, "/AdminTop.jsp");
			}

			//変更ボタンのクリック
			else if(action.equals("change")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				List<AdminBean> list = dao.findById(user_id);
				request.setAttribute("users", list);
				gotoPage(request, response, "/AdminChange.jsp");
			}

			//更新
			else if(action.equals("update")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String user_name = request.getParameter("user_name");
				String user_address = request.getParameter("user_address");
				String user_tel = request.getParameter("user_tel");
				String user_email = request.getParameter("user_email");
				String birthday = request.getParameter("birthday");
				String membership_date = request.getParameter("membership_date");
				String withdrawal_date = request.getParameter("withdrawal_date");
				int user_password = Integer.parseInt(request.getParameter("user_password"));

				dao.UpdateUser(user_id, user_name, user_address, user_tel, user_email,
						birthday, membership_date, withdrawal_date, user_password);

				List<AdminBean>list = dao.findById(user_id);
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("users", list);
				gotoPage(request, response, "/AdminTop.jsp");
			}

			//削除
			else if(action.equals("delete")) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				dao.deleteById(user_id);
				//削除後は全表示
				List<AdminBean> list = dao.findAll();
				request.setAttribute("users", list);
				gotoPage(request, response, "/AdminTop.jsp");
			}

			//以外
			else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/Error.jsp");
			}
		}

		catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}


	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
