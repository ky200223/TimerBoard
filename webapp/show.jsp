<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${board.title}</title>
</head>
<style type="text/css">
body {
	background-color: #ecf0f1
}

#blank1 {
	width: 600px;
	height: 40px;
	margin: 0 auto;
}

#main {
	width: 600px;
	height: 800px;
	margin: 0 auto;
	font-size: 3.0em;
	text-align: center;
}

#title {
	font-size: 30px;
}

#blank2 {
	width: 600px;
	height: 40px;
	margin: 0 auto;
}

#alertText {
	font-size: 17px;
}

#textContents {
	font-size: 17px;
}
</style>
<body>
	<div id="blank1"></div>
	<div id="main">
		<div id="title">
			제목 : ${board.title}<br />
		</div>
		<div id="blank2"></div>
		<div id="textContents">내용 : ${board.contents}</div>
		<br />
		<c:choose>
			<c:when test="${empty board.fileName}">
				<div id="alertText">사진을 업로드 하지 않으셨습니다!</div>
			</c:when>
			<c:when test="${not empty board.fileName}">
				<img src="/images/${board.fileName}" style="width: 100%" />
				<br />
			</c:when>
		</c:choose>
		<c:forEach items = "${board.comments}" var = "comment">
			${comment.reply}
			<hr/>		
		</c:forEach>
		<form action = "/board/${board.id}/comment" method = "post">
			<input type = "text" name = "reply">
			<input type = "submit" value = "댓글남기기">
		</form>
		<br />
		<form action="/board/modifyThrow/${board.id}" method="post">
			<input type="submit" value="수정" />
		</form>
		<form action="/board/delete/${board.id}" method="post">
			<input type="submit" value="삭제" />
		</form>
		<br /> <a href="/${sessionScope.user.userEmail}" style="font-size: 20px"> 처음 페이지로 가기 </a>
	</div>
</body>
</html>