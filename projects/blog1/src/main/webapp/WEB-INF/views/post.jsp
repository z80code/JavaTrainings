<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

 <t:_layout>
  <jsp:body>

	<a href="home"> На главную </a>
	<h1>${post.title}</h1>
	<p>Дата создания: ${post.created} / Изменен: ${post.lastChanged}</p>
	<div>${post.content}</div>
	<div>Теги: ${post.tags}</div>

  </jsp:body>
</t:_layout>