<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
<body>

<c:if test="${not empty user}">
	<h2>Welcome ${user.userName}</h2>
	
	<form action="logout" method="post">
		<input type="submit" value="logout" />
	</form>
	
</c:if>

<c:if test="${empty user}">
	<h2>Welcome guest</h2>
	<a href="login" >Log in</a>
</c:if>

</body>
</html>