<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Enter login and password</h3>
<form method="post">
	<div>
		<label for="userName"></label>User Name<br>
		<input type="text" id="userName" name="userName" >
	</div>

	<div>
		<label for="password">Password</label><br>
		<input type="password" id="password" name="password" >
	</div>
	
	<div>
		${error}
	</div>
	
	<div>
		<input type="submit" value="login">
		<a href="${pageContext.request.contextPath}"> на главную</a>
	</div>
</form>

</body>
</html>