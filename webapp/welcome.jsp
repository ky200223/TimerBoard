<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PotoPotoPhoto+</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto_welcome.css" type = "text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,500' rel='stylesheet' type='text/css'>
<script>
	var global_vars = {
		loginStatus : "${sessionScope.login_Status}",
		userNickName : "${sessionScope.nickName}",
		loginMessage : "${sessionScope.errorMsg}",
		login_Status_On : "1",
		login_Status_Off : "0"
	}
</script>
</head>
<body>
	<div id = "welcome">
		<div id = "welcomeMessage">
			<span id = "line1">PotoPotoPhoto+ </span> </br>
			<span id = "line2">share some glees</span>		
		</div>
		<div id = "loginButton" onclick="location.href='/login/form';">
			로그인하기
		</div>
		<div id = "registerButton" onclick="location.href='/login/register';">
			가입하기
		</div>
	</div>
</body>
<script src = "/javascripts/potopotophoto_welcome.js"></script>
</html>