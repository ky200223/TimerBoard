<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이건 사진 올리는 페이지</title>
</head>
<body style="background-color: #ecf0f1">
	<div id="blank" style="width: 600ox; height: 40px; margin: 0 auto;">
	</div>
	<div
		style="width: 600px; height: 400px; margin: 0 auto; font-size: 3.0em; text-align: center;">
		사진을 올려보장 <br>
		<hr style="width: 400px">
		<div id="blank" style="width: 600ox; height: 20px; margin: 0 auto;">
		</div>
		<form action = "/board" method = "post">
			<div style="font-size: 17px">
				이 사진은 제목이 뭘까? : 
				<input type="text" name="title" style="width: 120px" />
			</div>
			<div id="blank" style="width: 600ox; height: 10px; margin: 0 auto;">
			</div>
			<!-- accept = "image/*" 으로 이미지 파일만 업로드 할 수 있게 한다. -->
			<input type="file" name="imageContent" style="width: 300px"	accept="image/*" /> 
			<input type="submit" value = "업로드"/>
		</form>
	</div>
</body>
</html>