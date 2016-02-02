<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p> <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="short" />  </p>
<p> <fmt:formatDate value="${date}" type="date" dateStyle="full" timeStyle="short" />  </p>
<p> <fmt:formatDate pattern="dd.MM.yyyy" value="${date}" /> </p>
</body>
</html>