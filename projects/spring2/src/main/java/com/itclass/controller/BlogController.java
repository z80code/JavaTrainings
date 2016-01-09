package com.itclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

	@Autowired
	private BlogService service;
	
	//HttpServletRequest
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public ModelAndView postHome(Post val) {	
		System.out.println("post: "+val);
		
		if(val !=null) {
			service.createPost(val);
		}
		
		return new ModelAndView("home","val", val );
	}
}
