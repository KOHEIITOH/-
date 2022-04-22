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
	<a href="MemberLogin.jsp">戻る</a>
	<br>

	<h1>ユーザー情報登録画面</h1>
	<form action="/Reserve/MemberLoginServlet" method="post">

		 ID : <input type="text" name="user_id" size="15" placeholder="IDを入力してください"><br>
		    パスワード : <input type="password" name="user_password" size="25" placeholder="パスワードを入力してください"><br>
		  名 : <input type="text" name="user_name" size="20" placeholder="名前を入力してください"><br>
住所 : <input type="text" name="user_address" size="15" placeholder="東京都中央区"><br>
電話 : <input type="text" name="user_tel" size="20" placeholder="000-0000-0000"><br>
メール : <input type="text" name="user_email" size="20" placeholder="aaaa@aaaaa.com"><br>
誕生日 : <input type="text" name="birthday" size="25" placeholder="0000-00-00"><br>
			予約日 : <input type="text" name="membership_date" size="25" placeholder="0000-00-00"><br>
			時間 : <input type="text" name="withdrawal_date" size="25" placeholder="0000-00-00"><br>

	<br>

		<input type="submit" value="登録">
			 			<input type="hidden" name="action" value="insert">
		</form>

	<br><br>



	<hr color = "red" size="3">
	<br><br>
	<table border="1">
			<tr>
				<td>ユーザID</td>
				<td>ユーザパスワード</td>
				<td>ユーザの名前</td>
				<td>宿の住所</td>
				<td>ユーザの電話番号</td>
				<td>ユーザのメールアドレス</td>
				<td>誕生日</td>
				<td>予約日</td>
				<td>時間</td>

			</tr>
	<c:forEach items="${items}" var="item">
		<tr>
						<td >${item.user_id}</td>
					<td >${item.user_name}</td>
					<td >${item.user_address}</td>
					<td >${item.user_tel}</td>
					<td >${item.user_email}</td>
					<td >${item.birtday}</td>
					<td >${item.membership_date}</td>
					<td >${item.withdrawal_date}</td>
					<td >${item.user_password}</td>


		</tr>
	</c:forEach>
	</table>
</body>
</html>