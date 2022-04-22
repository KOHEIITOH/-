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
	<a href="HotelTop.jsp">←</a>
	<br>
	<p>宿情報変更画面</p>
<c:forEach items="${items}" var="item">
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
			</tr>

		<tr>
						<td >${item.hotel_id}</td>
					<td >${item.hotel_name}</td>
					<td >${item.hotel_price}</td>
					<td >${item.hotel_img}</td>
					<td >${item.hotel_info}</td>
					<td >${item.hotel_address}</td>
					<td >${item.hotel_tel}</td>
					<td >${item.hotel_email}</td>

		</tr>

	</table>

	<form action="/Reserve/HotelServlet" method="post">
		宿のID<input type="hidden" name="hotel_id" value="${item.hotel_id}" size="5"><br>
		宿名<input type="text" name="hotel_name" value="${item.hotel_name}" size="10"><br>
	宿の金額<input type="text" name="hotel_price" value="${item.hotel_price}" size="10"><br>
	宿の写真<input type="text" name="hotel_img" value="${item.hotel_img}" size="10"><br>
	宿の情報<input type="text" name="hotel_info" value="${item.hotel_info}" size="10"><br>
	宿の住所<input type="text" name="hotel_address" value="${item.hotel_address}" size="10"><br>
宿の電話番号<input type="text" name="hotel_tel" value="${item.hotel_tel}" size="10"><br>
  宿のメアド<input type="text" name="hotel_email" value="${item.hotel_email}" size="10"><br>

 			<input type="submit" value="変更">
 			<input type="hidden" name="action" value="update"><br>
	</form>
	</c:forEach>
</body>
</html>