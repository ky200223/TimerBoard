<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type = "text/css">
	body {
		background-color: #ecf0f1;
	}
	
	#main {
		width: 600px; 
		height: 200px; 
		margin: 0 auto; 
		font-size : 23px; 
		text-align: center;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "main">
		우리가 궁금한 사진이름이 뭐에요?
		<br/>
		<br/>
		<form action = "/board/search" method="post">
			<input type = "text" name = "title" style="width: 100px" >
		</form>
	</div>
</body>
</html>