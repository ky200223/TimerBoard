<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이건 사진 올리는 페이지</title>
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
		height: 400px;
		margin: 0 auto; 
		font-size: 3.0em; 
		text-align: center;
	}
	
	#blank2 {
		width: 600px; 
		height: 10px; 
		margin: 0 auto;
	}
	
	#content {
		font-size: 16px;
	}
	
	#blank3 {
		width : 600px;
		height : 10px;
		margin: 0 auto;
	}
</style>
<body>
	<div id = "blank1"></div>
	<div id = "main">
		사진을 올려보장 <br>
		<hr style="width: 400px">
		<div id="blank2"></div>
		<form action="/board/upload" method="post" enctype="multipart/form-data">
			<div id = "content">
				이 사진은 제목이 뭘까? &nbsp;: &nbsp;
				<input type="text" name="title" style="width: 100px"/>
				<br/> <br/>
				<input type = "text" name="contents" style = "width : 280px; height : 70px">
			</div>
			<div id="blank3"></div>
			<!-- accept = "image/*" 으로 이미지 파일만 업로드 할 수 있게 한다. -->
			<input type="file" name="file" size="50" accept="image/*" />
			<input type="submit" value="업로드" /> <input type="reset" value="삭제하기" />
		</form>
	</div>
</body>
</html>