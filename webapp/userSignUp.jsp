<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입페이지</h1>
<form action = "/login/signUp" method = "post" enctype="multipart/form-data">
	아이디 : <input type = "text" name = "userEmail"/><br/><br/>
	비밀번호 : <input type = "password" name = "password"/><br/><br/>
	별명 : <input type = "text" name = "nickName"/><br/><br/>
	프로필 사진 : <input type="file" name="file" size="50" accept="image/*" />
	<input type = "submit" value = "회원가입"/>
	<input type = "reset" value = "되돌리기"/>
	</form>
</body>
</html>