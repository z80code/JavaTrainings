package com.itclass.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SessionExample() {
        super();
        // TODO Auto-generated constructor stub
    }

    // session.invalidate(); - очистка сессии 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		List<String> rows = (List<String>)session.getAttribute("rows");
		
		if(rows==null) {
			rows = new ArrayList<String>();
		}
		
		StringBuilder page = new StringBuilder();
		page.append("<html>");
		page.append("<body>");
		
		for(String row : rows) {
			page.append("<p>");
			page.append(row);
			page.append("</p>");
		}
		
		page.append("<hr>");
		
		page.append("<form method='post' action='session' >");
		page.append("Введите строку:");
		page.append("<input type='text' name='row'> ");
		page.append("<input type='submit' value='Добавить строку'>");
		page.append("</form>");
		
		page.append("</body>");
		page.append("</html>");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().append(page);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		List<String> rows = (List<String>)session.getAttribute("rows");
		
		if(rows==null) {
			rows = new ArrayList<>();
		}
		
		rows.add( request.getParameter("row") );
		session.setAttribute("rows", rows);
		
		doGet(request, response);
	}
}
/*
request.setAttribute("message", message);
request.getRequestDispatcher("/login.jsp").forward(request, response);

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

...

<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>

<%--jsp:useBean id="Student" class=/>--%>
<jsp:getProperty name="Student" property="LastName" />
<jsp:setProperty name="Student" property="LastName" value="Smith"/>

*
*
*/



//http://stackoverflow.com/tags/servlets/info
