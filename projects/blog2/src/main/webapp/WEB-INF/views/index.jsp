<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:layout>
	<jsp:body>
	
    <a href="add">[+]</a>
	    <c:forEach var="post" items="${posts}">
			<p>
			<a href="post?id=${post.id}"> ${post.title}</a>
			<br>
			${post.created} <br>
			${post.content} <br>
			${post.tags} 
			</p>
		</c:forEach>
   
   </jsp:body>
</t:layout>

