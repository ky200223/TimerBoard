<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PotoPotoPhoto+</title>
<link rel = "stylesheet" href = "/stylesheets/potopotophoto_main.css" type = "text/css" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300' rel='stylesheet' type='text/css'>
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
			<div id = "userNickNameSection">
				${sessionScope.user.nickName}
			</div>
			<div id = "userInfo"></div>
		</div>
		<div class = "userBoard">
			<c:forEach items="${userBoards}" var="board">
				<div class = "eachBoardSection">
					<div class="boardTitle">
						${board.title}<br/><br/>
					</div>
					<form acction = "/board/delete/${board.id}" method="post">
						<button class = "deleteButton" type = "submit">
							삭제하기
						</button>
					</form>
					<form action="/board/modifyThrow/${board.id}" method="post">
						<button class = "modifyButton" type = "submit">
							수정하기
						</button>
					</form>
					<div class = "boardContents">
						${board.contents}
					</div>
					<c:if test = "${not empty board.fileName}">
						<div class = "boardImage">
							<img src="/images/${board.fileName}" style="width: 100%" />
						</div>
					</c:if>
					<c:forEach items = "${board.comments}" var = "comment">
						<div class="commentSection">
							<div class = "commentContents">
								${comment.reply}
							</div>
							<form action = "/board/${comment.id}/deleteComment" method="post">
							</form>
						</div>	
						<div class = "horizonLine">
						</div>
					</c:forEach>
					<div class  = "commentForm">
						<form action = "/board/${board.id}/comment" method = "post">
							<input class = "commentInputForm" type = "text" name = "reply" placeholder=" New comment..."/>
							<button class = "commentButton" type = "submit">
								댓글남기기
							</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class = "boardUploadSection">
			<div id = "uploadMessage">
				Upload
			</div>
			<div id = "uploadForm">
				<form action="/board/upload" method="post" enctype="multipart/form-data">
					<input class = "input_1" type= "text" name= "title" placeholder=" Title"/> </br></br>
					<textarea class = "input_2" type = "text" name= "contents"/>asdfasdf
					</textarea></br>
					<input id = "fileUploadButton" type = "file" name = "file" accept="image/*"/>
					<button type = "submit" id = "uploadButton">
						저장하기
					</button>
				</form> 
			</div>
		</div>
	</div>
	<footer id = "footer"> 
		2013 &nbsp; YoungKim &nbsp; @nhnnext.org <br>
	</footer> 
<!-- 	<script src = "/javascripts/potopotophoto.js"></script> -->
</body>
</html>