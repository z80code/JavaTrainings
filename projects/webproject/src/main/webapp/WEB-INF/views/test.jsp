<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" >
	<input type="text" name="info">
	<input type="text" name="info">
	<input type="submit">
</form>

<h1>Test page ${name}</h1>

<c:forEach var="item" items="${obj}">
	<p> ${item.id}</p>
	<p> ${item.name}</p>
	<p> ${item.justNumber}</p>
	<hr>
</c:forEach>


</body>
</html>