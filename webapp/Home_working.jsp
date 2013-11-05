<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PotoPotoPhoto+</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto_main.css" type = "text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,500' rel='stylesheet' type='text/css'>
<script type="text/javascript" language="javascript">
	var loginFeature = {
		loginStatus : "${sessionScope.login_Status}",
		userNickName : "${sessionScope.nickName}",
		loginErrorMessage : "${requestScope.errorMsg}",
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
				document.getElementById("logInLogOut").innerHTML = 
				'<a href = "/login/form"> 로그인하기 </a> &nbsp <a href = "/login/register"> 회원가입하기 </a>';
			else 
				document.getElementById("logInLogOut").innerHTML = 
				'<a href = "/login/logout"> 로그아웃하기 </a> &nbsp <a href = "/board/form"> 글올리러가기 </a>';
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
			style = "background-image: url('/images/${user.profilePicName}');">
				<!-- div style attribute contains img src -->
			</div>
			<div id = "blank1"></div>
			<div id = "userNickNameSection">
				${sessionScope.user.nickName}
			</div>
			<div id = "userInfo"></div>
		</div>
		<div class = "userBoard">
			<div id = "boardRegisterSection"></div>
			<div class = "boardScollSection">
				<c:forEach items="${userBoards}" var="board">
					<div class="textContents">
						${board.title}<br/><br/>
					</div>
					<c:if test = "${not empty board.fileName}">
						<img src="/images/${board.fileName}" style="width: 100%" />
					</c:if>
					<c:forEach items = "${board.comments}" var = "comment">
						${comment.reply}
						<hr/>	
					</c:forEach>
				<form action = "/board/${board.id}/comment" method = "post">
					<input type = "text" name = "reply">
					<input type = "submit" value = "댓글남기기">
					</form>
				<hr />
				</c:forEach>
			</div>
		</div>
		<aside class = "boardRegisterForm"></aside>
	</div>
<!-- 	<script src = "/javascripts/potopotophoto.js"></script> -->
</body>
</html>