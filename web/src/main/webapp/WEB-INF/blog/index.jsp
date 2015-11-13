 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Index page

<c:forEach var="post" items="${posts}">
	<br>
	<a href="post?id=${post.id}"> ${post.title} </a>
	<br>
</c:forEach>

</body>
</html>