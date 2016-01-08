package com.itclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	
	// Можно получить доступ к объектам сервлетов
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		String name = (String)request.getSession().getAttribute("user");
		if (name !=null) {
			return new ModelAndView("welcome", "message", name);
		} else {
			return new ModelAndView("redirect:login");
		}
	}
	
}

// example http://javahash.com/spring-4-mvc-hello-world-tutorial-full-example/
