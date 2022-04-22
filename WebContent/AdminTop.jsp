<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会員情報管理</title>
</head>
<body>
	<a href="HotelTop.jsp">宿情報管理</a> / <a href="AdminTop.jsp">会員情報管理</a>
	<br><br>
	<form action="/Reserve/AdminLoginServlet" method="post">
		<input type="hidden" name="action" value="logout">
		<input type="submit" name="logout" value="ログアウト">
	</form>

	<h2>会員管理</h2>

	ソート：<a href="/Reserve/AdminServlet" >全会員一覧</a>

	<form action="/Reserve/AdminServlet" method="post">
		検索（会員ID）：<input type="text" name="user_id" size="5" placeholder="IDを入力" required>
		 <input	type="submit" value="検索">
		 <input type="hidden" name="action" value="search">
	</form>

	<hr>

	<table border="1">
	<tr>
		<td>ID</td>
		<td>名前</td>
		<td>住所</td>
		<td>電話番号</td>
		<td>E-mail</td>
		<td>生年月日</td>
		<td>入会日</td>
		<td>退会日</td>
		<td>パスワード</td>
		<td>ホテル予約状況</td>
		<td>変更</td>
		<td>削除</td>
	</tr>

	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.user_id}</td>
			<td>${user.user_name}</td>
			<td>${user.user_address}</td>
			<td>${user.user_tel}</td>
			<td>${user.user_email}</td>
			<td>${user.birthday}</td>
			<td>${user.membership_date}</td>
			<td>${user.withdrawal_date}</td>
			<td>${user.user_password}</td>
			<td>${hotel_id}</td>
			<td>
				<form action="/Reserve/AdminServlet?action=change" method="post">
					<input type="submit" value="変更">
					<input type="hidden" name="user_id" value="${user.user_id}">
				</form>
			</td>
			<td>
				<form action="/Reserve/AdminServlet?action=delete" method="post">
					<input type="submit" value="削除">
					<input type="hidden" name="user_id" value="${user.user_id}">
				</form>
			</td>
		</tr>
	</c:forEach>

	</table>


</body>
</html>