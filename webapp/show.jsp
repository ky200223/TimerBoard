<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<br /> <img src="/images/${board.fileName}" style="width:100%" /> <br />
		<br />
		<form action="/board/modifyThrow/${board.id}" method="post">
			<input type = "submit" value="수정"/>
		</form>
		<form action="/board/delete/${board.id}" method="post">
			<input type="submit" value="삭제" />
		</form>
		<a href = "/"> 처음 페이지로 가기 </a>
	</div>
</body>
</html>