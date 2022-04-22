<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- ログアウト -->
	ユーザートップページ
	<a href="/jmaster/AnswerServlet3?answer=1">ログアウト</a>

	<br>
	<!-- 画面遷移 -->
	<p style="color: #F0FFFF">
		<a href="HotelRegister.jsp">登録</a> <a href="">会員管理</a>
	</p>
<h1>会員ID${user_id}</h1>


<form action="/Reserve/UserServlet" method="post">
	<input type="hidden" name="action" value="show">
	<input type="submit" value="表示">
</form>
	<p style="color: #F0FFFF">予約いちらん</p>
	<br>



<c:forEach items="${items}" var="item">
	<table border="1">
		<tr>
			<td>宿予約ID</td>
			<td>宿ID</td>
			<td>チェックイン時間</td>
			<td>チェックアウト時間</td>
			<td>会員ID</td>
		</tr>
		<tr>
			<td >${item.hotel_reserve_id}</td>
			<td >${item.hotel_id}</td>
			<td >${item.checkin_date}</td>
			<td >${item.checkout_date}</td>
			<td >${item.user_id}</td>

		</tr>
	</table>
	</c:forEach>

					<form action="/Reserve/UserServlet?action=change" method="post">
					<input type="hidden" name="user_id" value="${user_id}">
					<input type="submit" value="変更">
					</form>

					<form action="/Reserve/UserServlet?action=changeReserve" method="post">
					<input type="hidden" name="user_id" value="${user_id}">
					<input type="submit" value="予約">
					</form>


<form action="/Reserve/UserServlet?action=delete" method="post">
							<input type="hidden" name="hotel_id" value="${user_id}">
							<input type="submit" value="会員情報削除">

	</form>


	</body>
</html>