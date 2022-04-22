<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理者ログイン</title>
	<style type="text/css">
		h1 {
			font-size:45px;
			text-align:center;
		}
		h3{
			text-align:center;
		}
		div .content{
			margin : 0 auto;
		}
		a{
			text-decoration: none;
		}
	</style>
</head>
<body>

	<a href="MemberLogin.jsp">トップ</a>
	<h1>管理者ログイン</h1>
	<br><br>
	<div class="content" align="center">

		<form action="/Reserve/AdminLoginServlet" method="post">
			<div>
				ログインID：<input type="text" name="name" />
			</div>
			<br>
			<div>
				パスワード：<input type="password" name="pw" />
			</div>
			<br>
			<input type="hidden" name="action" value="login">
			<br>
			<div>
				<input type="submit" value="ログイン">
			</div>
		</form>

	</div>




</body>
</html>