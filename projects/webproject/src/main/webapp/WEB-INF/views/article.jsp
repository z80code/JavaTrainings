<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
</head>
<body>
	
	<p> <a href="home"> На главную </a>  </p>
	
    <h1> ${article.title}</h1>
    <p> ${article.author} / publication date: ${article.date}</p>
    <p> 
    	${article.text}
    </p>

</body>
</html>