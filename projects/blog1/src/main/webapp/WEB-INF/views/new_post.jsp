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
<h1>Добавление поста:</h1>

<form action="" method="post">

	<p>Название статьи:</p>
	<input type="text" name="title" />
	
	<p>Содержание статьи:</p>
	<textarea rows="10" cols="80" name="content"></textarea>
	
	<p>Теги:</p>
	<input type="text" name="tags"/>
	
	<input type="submit" value="Сохранить статью" />
</form>

</body>
</html>