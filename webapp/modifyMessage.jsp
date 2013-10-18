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

	#blank {
		height: 60px;
	}
</style>
<title>사진수정완료메세지</title>
</head>
<body>
	<div id="main">
		<div id="blank"></div>
		<br/><br/>
		<a href="/board/${board.id}"> 수정확인하러가쟈! </a>
		<br/><br/>
		<a href="/"> 첫화면으로! </a>
	</div>
</body>
<script type="text/javascript">
	alert("수정완료!");
</script>
</html>