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
				<td>会員ID</td>
				<td>会員の名前</td>
				<td>会員の住所</td>
				<td>会員の電話番号</td>
				<td>会員のメールアドレス</td>
				<td>会員の生年月日</td>
				<td>会員の入会年月</td>
				<td>会員の退会年月</td>
				<td>会員のパスワード</td>
			</tr>
		<tr>
					<td>${item.user_id}</td>
					<td>${item.user_name}</td>
					<td>${item.user_address}</td>
					<td>${item.user_tel}</td>
					<td>${item.user_email}</td>
					<td>${item.birtday}</td>
					<td>${item.membership_date}</td>
					<td>${item.withdrawal_date}</td>
					<td>${item.user_password}</td>
		</tr>
	</table>
	<form action="/Reserve/UserServlet" method="post">
		会員ID：${item.user_id}<input type="hidden" name="user_id" value="${item.user_id}" size="5"><br>
		会員の名前<input type="date" name="user_name" size="5"><br>
		会員の住所<input type="date" name="user_address" size="5"><br>
	会員の電話番号<input type="text" name="user_tel" size="5"><br>
	会員のメールアドレス<input type="text" name="user_email" size="5"><br>
	会員の生年月日<input type="text" name="birtday" size="5"><br>
	会員の入会年月<input type="text" name="membership_date" size="5"><br>
会員の退会年月<input type="text" name="withdrawal_date" size="5"><br>
 会員のパスワード<input type="text" name="user_password" size="5"><br>
 			<input type="submit" value="変更">
 			<input type="hidden" name="action" value="update"><br>


	</form>
	</c:forEach>
</body>
</html>