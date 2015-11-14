package task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/task01")
public class TaskCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		Cookie savedCookie = null;
		if(cookies!=null) {
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("savedtext")) {
					savedCookie = cookie;
					break;
				}
			}
		}
		
		String page = (savedCookie==null)
						?getIndexPage()
						:getInfoPage(savedCookie.getValue());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		response.getWriter().append(page);
	}

	// метод для формирования страницы с полем ввода
	private String getIndexPage() {
		StringBuilder sb = new StringBuilder();
		sb.append("<form action='task01' method='post' >");
		sb.append("<p>Введите текст</p>");
		sb.append("<input type='text' name='text' >");
		sb.append("<input type='submit' value='Сохранить'>");
		sb.append("</form>");
		
		return sb.toString();
	}
	
	// метод для формирования страницы с результатом 
	private String getInfoPage(String value) {
		StringBuilder sb = new StringBuilder();
		sb.append("<p>Сохраненный текст</p>");
		sb.append(String.format("<p>%s</p>", value));
		
		sb.append("<form action='task01?deleteCookie' method='post' >");
		sb.append("<input type='submit' value='Удалить'>");
		sb.append("</form>");
		
		return sb.toString();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isDeleteCookie = request.getParameter("deleteCookie");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		if(isDeleteCookie!=null) {
			Cookie cookie = new Cookie("savedtext", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			response.getWriter().append(getIndexPage());
			
		} else {
			String text = request.getParameter("text");
			Cookie cookie = new Cookie("savedtext", text);
			response.addCookie(cookie);
			response.getWriter().append(getInfoPage(text));
		}
	}

}
