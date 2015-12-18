<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:layout>
	<jsp:body>

<a href="${pageContext.request.contextPath}/home">Home</a>


<div>
	<h1>${post.title}</h1>
	<p> Post created: ${post.created} / 
	Mode ${post.lastChenged} </p>
	<hr>
	<p> 
		${post.content}
	</p>
	<p>
		${post.tags} 
	</p>
</div>

</jsp:body>
</t:layout>