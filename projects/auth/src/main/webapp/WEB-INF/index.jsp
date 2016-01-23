<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>


	<c:if test="${not empty user}">
		<h3>${user.email} ${user.role}</h3>
		<form action="logout" method="post">
			<input type="submit" value="logout">
		</form>
	</c:if>

	<c:if test="${empty user}">
		<h3>Guest</h3>
		<a href="login">login</a>
	</c:if>


	<h2>Hello World!</h2>
</body>
</html>
