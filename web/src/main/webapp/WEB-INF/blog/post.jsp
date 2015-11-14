 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="blog" >Назад</a>
<br>
<br>
<br>
<h1> ${post.title} </h1>
<p> Статья написана: ${post.created} / Изменена: ${post.lastChange}  </p>

<p> 
 Теги: <c:forEach var="tag" items="${post.tags}">
		<br>
		<a href="#"> ${tag} </a> 
	</c:forEach>
</p>

<hr>
<div>
 ${post.content}
</div>
<hr>

</body>
</html>