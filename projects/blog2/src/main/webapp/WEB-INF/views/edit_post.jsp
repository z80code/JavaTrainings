<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:layout>
	<jsp:body>
<div>
	<form method="post">
		<p>Название статьи:</p>
		<input type="text" name="post.title" />		
		<p>Текст статьи:</p>
		<textarea rows="10" cols="40" name="post.content"></textarea>
		<p>Теги:</p>
		<input type="text" name="post.tags" />
		<input type="submit" value="Сохранить" />
		<a href="${pageContext.request.contextPath}">Удалить</a>
	</form>
</div>

</jsp:body>
</t:layout>