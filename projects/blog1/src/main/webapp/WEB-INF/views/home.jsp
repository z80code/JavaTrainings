<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:_layout>
	<jsp:body>


      <div class="page-header">
        <h1>Блог</h1>
      </div>
      
      <c:forEach var="post" items="${posts}">
		<p>
		<a href="post?id=${post.id}"> ${post.title}</a>
		${post.created} <br>
		${post.content} <br>
		${post.tags} 
		</p>
	 </c:forEach>
    
     </jsp:body>
</t:_layout>











