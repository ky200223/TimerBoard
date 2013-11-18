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
	<nav>
		<div id = "loginStatus"></div>
		<div id = "logInLogOut" onclick="location.href='/login/logout';">
			로그아웃하기 
		</div>
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
					<form action="/board/delete/${board.id}" method="post">
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
					<div class = "activeCommentSection">
						<div class = "commentCount">
							<!-- 댓글 갯수가 표시된다. -->
						</div>
						<div class = "commentToggle">								
						</div>
					</div>
					<div class = "commentSection">
						<c:forEach items = "${board.comments}" var = "comment">
							<div class="commentField">
								<div class = "commentContents">
									${comment.reply}
								</div>
								<div class = "commentDeleteForm">
									<form action = "/board/${comment.id}/commentDelete" method="post">
										<button class = "commentDeleteButton" type = "submit">
											삭제
										</button>
									</form>
								</div>
							</div>	
							<div class = "horizonLine">
							</div>
						</c:forEach>
					</div>
					<div class  = "commentForm">
						<form action = "/board/${board.id}/comment" method = "post">
							<input type="hidden" name="id" value="${board.id}"/>
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
					<input class = "input_1" type= "text" name= "title" placeholder=" Title"/></br></br>
					<textarea id = "defaultBoardContents" type = "text" name= "contents"/> Contents...</textarea></br>
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
</body>
<script src = "/javascripts/potopotophoto_main.js"></script>
</html>