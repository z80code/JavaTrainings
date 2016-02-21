<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>News <a href="create">+</a></h1> 

<c:forEach var="item" items="${articles}">
	<p> ${item.id}</p>
	<p> <a href="article?id=${item.id}"> ${item.title}</a></p>
	<p> ${item.author}  / 
	
	<fmt:formatDate pattern="dd.MM.yyyy hh:mm:ss" value="${item.date}"/>
	
	</p>
	 <p> 
	 	{TODO} Remove 
	 	{TODO} с помощью java script добавить подтверждение 
	 	удаления
	 </p>
	<hr>
</c:forEach>

</body>
</html>