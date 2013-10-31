<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body {
		background-color: #ecf0f1;
	}
	
	#main {
		width: 600px; 
		height: 60px; 
		margin: 0 auto; 
		font-size : 25px; 
		text-align: center;
	}
	
	#blank {
		height: 60px;
	}
	
	#button {
		font-size : 20px;
	}
</style>
<script type="text/javascript" language="javascript">
	var loginFeature = {
		loginStatus : "${sessionScope.login_Status}",
		loginMessage : "${sessionScope.nickName}",
		loginErrorMessage : "${sessionScope.errorMsg}",
		login_Status_On : "1",
		login_Status_Off : "0",
		
		loginStatusDisplay : function() {
			if (this.loginStatus === this.login_Status_On)
				document.getElementById("loginStatus").innerHTML = this.loginMessage + "님, 반갑습니다!";
			else
				document.getElementById("loginStatus").innerHTML = "로그인 되지 않았습니다.";
		},
		
		loginSectionDisplay : function() {
			if (this.loginStatus === this.login_Status_Off)
				document.getElementById("loginSection").innerHTML = '<a href = "/login/form"> 로그인하기 <br/></a>';
			else 
				document.getElementById("loginSection").innerHTML = '<a href = "/login/logout"> 로그아웃하기 <br/></a>';
		},
		
		loginErrorMessageAlert : function() {
			if (this.loginErrorMessage)
				alert(this.loginErrorMessage);
		},
	};
	
	var onloadEvent = {
		onloadExecute : function() {
			loginFeature.loginStatusDisplay();
			loginFeature.loginSectionDisplay();
			loginFeature.loginErrorMessageAlert();
		}
	}
	
	window.onload = onloadEvent.onloadExecute;
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP_Tomcat_Java Project</title>
</head>
<body>
	<div id = "loginStatus" style="float : left"></div>
	<div id = "register" style = "float : right">
		<a href = "/login/register"> 회원가입하기 </a>
	</div>
	<div id = "loginSection" style = "float : right"></div>
	<div id = "main">
		<div id = "blank"></div>
		사진 및 글 올리기
		<br/>
		<br/>
		<a href = "/board/form">Go!</a>
		<br/>
		<br/>
		<a href = "/board/picList">Show List!</a>
	</div>		
</body>
</html>