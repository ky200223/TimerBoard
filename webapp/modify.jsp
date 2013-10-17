<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background-color: #ecf0f1;
}

#main {
	width: 600px;
	height: 60px;
	margin: 0 auto;
	font-size: 25px;
	text-align: center;
}

#contents {
	font-size: 17px;
}

#blank1 {
	width: 600px;
	height: 40px;
	margin: 0 auto;
}

#blank2 {
	width: 600px;
	height: 40px;
	margin: 0 auto;
}

#blank3 {
	width: 600px;
	height: 10px;
	margin: 0 auto;
}
</style>
<title>파일을 수정해 보자꾸나</title>
</head>
<body>
	<div id="blank1"></div>
	<div id="main">
		사진을 수정해보장 <br>
		<hr style="width: 400px">
		<div id="blank2"></div>
		<div id = "contents">
		<form action="/board/modifySubmit/${board.id}" method="post"
			enctype="multipart/form-data">
			<div id="content">
				이 사진 제목이랑 내용을 뭘로 바꿀까? &nbsp;: &nbsp; <input type="text" name="title"
					style="width: 100px" /> <br /> <br /> <input type="text"
					name="contents" style="width: 280px; height: 70px">
			</div>
			<div id="blank3"></div>
			<!-- accept = "image/*" 으로 이미지 파일만 업로드 할 수 있게 한다. -->
			이미지 파일도 변경을 원하신다면 여기에서 다시 선택해주세요. <br/><br/><input type="file" name="file"
				size="50" accept="image/*" /> <input type="submit" value="수정완료" />
			<input type="reset" value="리셋하기" />
		</form>
		<br/><br/>
		<a href="/"> 그냥 수정 안할래요 </a>
		</div>
	</div>
</body>
</html>