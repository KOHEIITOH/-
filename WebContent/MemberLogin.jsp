<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>宿情報</h1>
<form action="/Reserve/MemberRegisterServlet" method="post">
		ID：<input type="text" name="id">
		Password :<input type="password" name="password">
		<input type = "hidden" name="action" value="login">
		<input type="submit" value="ログイン">
<br><br><br>
</form>
	<a href="MemberRegister.jsp">ログイン登録</a>
	<br>


<br><br><hr color = "red" size="3"><br><br>


	<a href="MemberRegister.jsp">管理者ログインページへ</a>
	<br>
</body>
</html>