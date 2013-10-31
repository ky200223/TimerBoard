<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background-color: #ecf0f1
}

#main {
	width: 600px;
	height: 800px;
	margin: 0 auto;
	font-size: 3.0em;
	text-align: center;
}

#textContents {
	font-size: 17px;
}
</style>
<title>PictureList</title>
</head>
<body>
	<div id="main">
		<c:forEach items="${boards}" var="board">
			<div id="textContents">
				${board.title}<br /><br/>
			</div>
			<c:if test = "${not empty board.fileName}">
			<img src="/images/${board.fileName}" style="width: 100%" />
			</c:if>
			<hr />
		</c:forEach>
	</div>
</body>
</html>