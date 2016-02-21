<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>New article</h1>

<p style="color: red;"> ${error} </p>

<form method="post">

<label >title</label>
<br>
<input type="text" name="title" value="${article.title}">
<br>
<label>author</label>
<br>
<input type="text" name="author" value="${article.author}">
<br>
<textarea rows="10" cols="20" name="text" >${article.text}</textarea>
<br>
<input type="submit" value="save article" > 
<a href="home">don't save it</a>

</form>

</body>
</html>