<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 03.12.2015
  Time: 11:36
  To change this template use File | Settings | File Templates.
  <fmt:setLocale value="es_ES" />
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="ru_RU" />

<%--
<fmt:setLocale value="es_ES" />
<fmt:setLocale value="en_US" />
<fmt:bundle basename="pagecontent"> 
	<fmt:message key="footer.copyright"/>
</fmt:bundle> --%>

<fmt:setBundle basename="pagecontent" var="rb" />
<html><head>
  <title><fmt:message key="label.title" bundle="${ rb }" /></title>
</head>
<body>
<fmt:message key="label.welcome" bundle="${ rb }" />
<hr/>
<fmt:message key="footer.copyright" bundle="${ rb }" />
</body></html>
