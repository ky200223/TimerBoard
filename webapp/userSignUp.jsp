<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto_register.css" type = "text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300' rel='stylesheet' type='text/css'>
</head>
<body>
	<nav>
		<div id = "gotoHome" onclick="location.href='/';">
			홈화면으로
		</div>
	</nav>
	<div id = "registerSection">
		<div id = "registerMessage">
			Register
		</div>
		<div id = "registerForm">
			<form action = "/login/signUp" method="post" enctype="multipart/form-data">
				User ID &nbsp : &nbsp <input class = "input" type = "text" name = "userEmail" placeholder=" ID"/> </br>
				<div class = "blank"></div>
				User Nickname &nbsp : &nbsp <input class = "input" type = "text" name = "nickName" placeholder=" Nickname"/> </br>
				<div class = "blank"></div>
				Password &nbsp : &nbsp <input class = "input" type = "password" name = "password" placeholder="  password"/> </br> 
				<div class = "blank"></div>
				ProfilePic &nbsp : &nbsp <input id = "fileUploadButton" type = "file" name = "file" accept="image/*"/> </br>
				<button type = "submit" id = "registerButton">
					가입하기
				</button>
			</form>
		</div>
	</div>
</body>
</html>