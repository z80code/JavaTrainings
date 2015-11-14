 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="blog" >Назад</a>

<form action="create" method="post">
	
	<p>Заголовок статьи:</p>
	<input type="text" name="title">
	
	<p>Текст статьи</p>
	<textarea name="content" cols="40" rows="20" ></textarea>
	
	<p>Теги:</p>
	<input type="text" name="tags">
	
	<input type="submit" name="Добавить">
	
	
</form>

</body>
</html>