<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here!</title>
</head>
<body>
Submitted data --> ${name}
<form action="/login.do" method="post">
	Enter your name: <input type="text" name="name"/> <input type="submit"/>
</form>
</body>
</html>