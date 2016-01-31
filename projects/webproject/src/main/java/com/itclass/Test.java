package com.itclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Cookie k = new Cookie("myvalue", "Save It 2");
		k.setMaxAge(0);
		response.addCookie( k );
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		MyClass m1 = new MyClass(1, "qwer", 234.4f);
		MyClass m2 = new MyClass(2, "asdf", 98.4f);
		MyClass m3 = new MyClass(3, "zxcv", 5.4f);
		
		List<MyClass> mList = new ArrayList<>();
		mList.add(m1);
		mList.add(m2);
		mList.add(m3);

		request.setAttribute("obj", mList );
		
		request
			.getRequestDispatcher("WEB-INF/views/test.jsp")
			.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
