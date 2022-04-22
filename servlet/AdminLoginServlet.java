package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final String ADMIN = "admin";
	private static final String PASS = "himitu";


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");

		//actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if(action.contentEquals("login")) {
			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");
			if(name.equals(ADMIN) && passWord.equals(PASS)) {
				//ユーザ名とパスワードが一致したらログイン処理を行う
				//セッション管理を行う
				HttpSession session = request.getSession();
				//ログイン済み属性を設定する
				session.setAttribute("isLogin", "true");

				RequestDispatcher rd = request.getRequestDispatcher("AdminTop.jsp");
		        rd.forward(request, response);
		        return;
			}
			else {
				request.setAttribute("message", "IDもしくはパスワードが違います。");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
		        rd.forward(request, response);
			}
		}
		else if(action.equals("logout")) { //ログアウト時
			//すでに作成されているセッション領域を取得する。新しく作成しない
			HttpSession session = request.getSession(false);
			if(session != null) {
				//セッション領域を無効にする
				session.invalidate();

//				request.setAttribute("logoutMsg", "ログアウトしました。");
//	            request.setAttribute("logoutFlg", true);

				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
		        rd.forward(request, response);
			}
		}
	}

}
