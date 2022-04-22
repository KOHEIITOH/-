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
	<p>宿情報登録画面</p>
	<form action="/Reserve/HotelServlet" method="post">
	  宿のID<input type="text" name="hotel_id" size="5"><br>
		宿名<input type="text" name="hotel_name" size="10"><br>
	宿の金額<input type="text" name="hotel_price" size="10"><br>
	宿の写真<input type="text" name="hotel_img" size="10"><br>
	宿の情報<input type="text" name="hotel_info" size="10"><br>
	宿の住所<input type="text" name="hotel_address" size="10"><br>
宿の電話番号<input type="text" name="hotel_tel" size="10"><br>
  宿のメアド<input type="text" name="hotel_email" size="10"><br>
 			<input type="submit" value="登録">
 			<input type="hidden" name="action" value="insert"><br>
	</form>
</body>
</html>