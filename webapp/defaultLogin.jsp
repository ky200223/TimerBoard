<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto_login.css" type = "text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300' rel='stylesheet' type='text/css'>
</head>
<body>
	<nav>
		<div id = "gotoHome" onclick="location.href='/';">
			홈화면으로
		</div>
	</nav>
	<div id = "loginMessage">
		Login, Please
	</div>
	<div id = "loginSection">
		<div id = "loginForm">
			<form action = "/login/signIn" method = "post">
				<input class = "input" type = "text" name = "userEmail" placeholder=" ID"/><br/><br/>
				<input class = "input" type = "password" name = "password" placeholder=" password"/><br/></br>
				<button type = "submit" id = "loginButton">
					로그인
				</button>
			</form>
	</div>
		<div id = "registerButton" onclick="location.href='/login/register';">
			가입하기
		</div>
</body>
</html>