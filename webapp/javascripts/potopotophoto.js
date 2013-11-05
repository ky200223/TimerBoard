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
				document.getElementById("logInLogOut").innerHTML = '<a href = "/login/form"> 로그인하기 </a> &nbsp <a href = "/login/register"> 회원가입하기 </a>';
			else 
				document.getElementById("logInLogOut").innerHTML = '<a href = "/login/logout"> 로그아웃하기 </a>';
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