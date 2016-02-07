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

<form method="post">

<label >title</label>
<br>
<input type="text" name="title">
<br>

<!-- ${article} ${errormessage} -->

<label>author</label>
<br>
<input type="text" name="author">
<br>
<textarea rows="10" cols="20" name="text"></textarea>
<br>
<input type="submit" value="save article"> 
<a href="home">don't save it</a>

</form>

</body>
</html>