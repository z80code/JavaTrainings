package com.itclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String message = "hi from controller";
		return new ModelAndView("welcome", "message", message);
	}
	
}

// example http://javahash.com/spring-4-mvc-hello-world-tutorial-full-example/
