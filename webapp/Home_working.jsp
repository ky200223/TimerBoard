<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PotoPotoPhoto+</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto.css" type = "text/css" />
<script type="text/javascript" language="javascript">
	var loginFeature = {
		loginStatus : "${sessionScope.login_Status}",
		userNickName : "${sessionScope.nickName}",
		loginErrorMessage : "${sessionScope.errorMsg}",
		login_Status_On : "1",
		login_Status_Off : "0",
		
		loginStatusDisplay : function() {
			if (this.loginStatus === this.login_Status_On)
				document.getElementById("loginStatus").innerHTML = this.userNickName + " 님, 반갑습니다!";
			else
				document.getElementById("loginStatus").innerHTML = "로그인 되지 않았습니다.";
		},
		
		loginSectionDisplay : function() {
			if (this.loginStatus === this.login_Status_Off)
				document.getElementById("logInLogOut").innerHTML = '<a href = "/login/form"> 로그인하기 <br/></a>';
			else 
				document.getElementById("logInLogOut").innerHTML = '<a href = "/login/logout"> 로그아웃하기 <br/></a>';
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
</head>
<body>
	<nav>
		<div id = "loginStatus"></div>
		<div id = "logInLogOut"></div>
	</nav>
	<div class = "ContentsView">
		<div class = "userProfileSection">
			<div id = "userProfilePicSection" 
			style = "background-image: url('/images/${user.profileName}');">
				<!-- div style contains img src -->
			</div>
			<div id = "userNickNameSection">
				${user.nickName}
			</div>
			<div id = "userInfo"></div>
		</div>
	</div>
	<section class = "userBoard">
		<div id = "boardRegisterSection"></div>
		<div class = "boardScollSection"></div>
	</section>
	<aside class = "otherUsers"></aside>
	<script src = "/javascripts/potopotophoto.js"></script>
</body>
</html>