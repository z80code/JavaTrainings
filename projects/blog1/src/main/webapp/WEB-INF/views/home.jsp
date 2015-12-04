<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog</title>
</head>
<body>
<h1>Посты:</h1>

<div>
	
<c:forEach var="post" items="${posts}">
	<p>
	<a href="post?id=${post.id}"> ${post.title}</a>
	${post.created} <br>
	${post.content} <br>
	${post.tags} 
	</p>
</c:forEach>
	
</div>

</body>
</html>