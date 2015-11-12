<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Нажми кнопку
<jsp:useBean id="calendar" class="java.util.GregorianCalendar"></jsp:useBean>
<form action="timeaction" method="post">
 	<!-- Можно вызывать методы -->
    <!-- <input type="hidden" name="time" value="${calendar.timeInMillis()}"> -->
    <!-- Нельзя вызвать методы не возвращающие значения -->
    
	<input type="hidden" name="time" value="${calendar.timeInMillis}">
	<input type="submit" value="get diff">
</form>
</body>
</html>