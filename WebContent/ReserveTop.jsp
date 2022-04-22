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


	<form action="/Reserve/ReserveTopServlet" method="post">
		宿の情報を検索：<input type="text" name="hotel_id" size="5" placeholder="検索名を入力してください"> <input
			type="submit" value="検索"> <input type="hidden" name="action"
			value="search">
	</form>
	<br>

<form action="/Reserve/ReserveTopServlet" method="post">
	<input type="hidden" name="action" value="show">
	<input type="submit" value="表示">
</form>

	<p style="color: #F0FFFF">宿情報一覧</p><br>

<h1>ユーザーID：${itemsa}</h1>
<table border="1">
			<tr>
				<td>宿ID</td><td>宿の名前</td><td>宿の写真</td><td>宿の金額</td><td>宿の住所</td><td>予約</td>
			</tr>

<c:forEach items="${items}" var="item">
	  <tr>
						<td >${item.hotel_id}</td>
					<td >${item.hotel_name}</td>
					<td ><img src="${item.hotel_img}" width="100" height="100"></td>
					<td >${item.hotel_price}</td>
					<td >${item.hotel_address}</td>

					<td>
					<form action="/Reserve/ReserveTopServlet?action=changeReserve" method="post">
					<input type="hidden" name="hotel_id" value="${item.hotel_id}">
					<input type="hidden" name="hotel_name" value="${item.hotel_name}">
					<input type="hidden" name="user_id" value="${itemsa}">
					<input type="hidden" name="hotel_img" value="${item.hotel_img}">
					<input type="hidden" name="hotel_address" value="${item.hotel_address}">
					<input type="hidden" name="hotel_price" value="${item.hotel_price}">
					<input type="hidden" name="hotel_tel" value="${item.hotel_tel}">
					<input type="hidden" name="hotel_email" value="${item.hotel_email}">
					<input type="hidden" name="hotel_info" value="${item.hotel_info}">

					<input type="submit" value="予約">
					</form>
					</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>