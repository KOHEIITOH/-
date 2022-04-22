<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿情報管理</title>
</head>
<body>

	<a href="HotelTop.jsp">宿情報管理</a> / <a href="AdminTop.jsp">会員情報管理</a>
	<br><br>
	<form action="/Reserve/AdminLoginServlet" method="post">
		<input type="hidden" name="action" value="logout">
		<input type="submit" name="logout" value="ログアウト">
	</form>

	<!-- 画面遷移 -->
	<p style="color: #F0FFFF">
		<a href="HotelRegister.jsp">登録</a>
	</p>
	<br>
	<!-- 検索ber -->
	<form action="/Reserve/HotelServlet" method="post">
		宿の情報を検索：<input type="text" name="hotel_id" size="5" placeholder="IDを入力" required>
		<input type="submit" value="検索">
		<input type="hidden" name="action" value="search">
	</form>
	<br>

<form action="/Reserve/HotelServlet" method="post">
	<input type="hidden" name="action" value="show">
	<input type="submit" value="表示">
</form>
<hr>

	<p style="color: #F0FFFF">宿管理一覧</p>


	<table border="1">
			<tr>
				<td>宿ID</td>
				<td>宿の名前</td>
				<td>宿の金額</td>
				<td>宿の写真</td>
				<td>宿の情報</td>
				<td>宿の住所</td>
				<td>宿の電話番号</td>
				<td>宿のメールアドレス</td>

				<td>変更</td>
				<td>削除</td>
			</tr>
	<c:forEach items="${items}" var="item">
		<tr>
						<td >${item.hotel_id}</td>
					<td >${item.hotel_name}</td>
					<td >${item.hotel_price}</td>
					<td ><img src="${item.hotel_img}" width="128" height="auto"></td>
					<td >${item.hotel_info}</td>
					<td >${item.hotel_address}</td>
					<td >${item.hotel_tel}</td>
					<td >${item.hotel_email}</td>

					<td>
					<form action="/Reserve/HotelServlet?action=change" method="post">
					<input type="hidden" name="hotel_id" value="${item.hotel_id}">
					<input type="submit" value="変更">
					</form>
					</td>

									<!--  削除-->
						<td><form action="/Reserve/HotelServlet?action=delete" method="post">
							<input type="hidden" name="hotel_id" value="${item.hotel_id}">
							<input type="submit" value="削除">
						</form>
					</td>
		</tr>
	</c:forEach>
	</table>

	</body>
</html>