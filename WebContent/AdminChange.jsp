<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更ページ</title>
</head>
<body>

	<a href="AdminTop.jsp">戻る</a>

	<h2>会員情報変更ページ</h2>

	<c:forEach items="${users}" var="user">
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
			</tr>

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
			</tr>

		</table>
		<br>

	<form action="/Reserve/AdminServlet" method="post">
		会員ID：<br><input type="hidden" name="user_id" value="${user.user_id}" size="5">${user.user_id}<br>
		名前：<br><input type="text" name="user_name" value="${user.user_name}"><br>
		住所：<br><input type="text" name="user_address" value="${user.user_address}"><br>
		電話番号：<br><input type="text" name="user_tel" value="${user.user_tel}"><br>
		メールアドレス：<br><input type="text" name="user_email" value="${user.user_email}"><br>
		生年月日：<br><input type="text" name="birthday" value="${user.birthday}"><br>
		入会日：<br><input type="text" name="membership_date" value="${user.membership_date}"><br>
		退会日：<br><input type="text" name="withdrawal_date" value="${user.withdrawal_date}"><br>
		パスワード：<br><input type="text" name="user_password" value="${user.user_password}"><br>
		<br>
		<input type="submit" value="更新"><br>
		<input type="hidden" name="action" value="update">
	</form>

	</c:forEach>

</body>
</html>