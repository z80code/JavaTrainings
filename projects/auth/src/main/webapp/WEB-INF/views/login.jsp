<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
login page

<form method="post">
	
	<div>
		<label for="name">enter login</label><br>
		<input id="name" type="text" name="email">
	</div>
	 <div>
		<label for="password">enter password</label><br>
		<input id="password" type="password" name="password">
	</div>
		
	<div>
		${error}
	</div>
	
	<input type="submit" value="Войти">
	
</form>



</body>
</html>