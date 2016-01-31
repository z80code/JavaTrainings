<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>News</h1>

<c:forEach var="item" items="${articles}">
	<p> ${item.id}</p>
	<p> <a href="#"> ${item.title}</a></p>
	<p>  ${item.author}  / ${item.date}  </p>
	<hr>
</c:forEach>

</body>
</html>