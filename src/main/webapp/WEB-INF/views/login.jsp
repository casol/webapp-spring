<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<p>${errorMessage}</p>
	<form action="/login" method="POST">
		Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" />
	</form>
</body>
</html>