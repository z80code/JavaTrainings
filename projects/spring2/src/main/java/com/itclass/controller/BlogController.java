package com.itclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService service;

	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/all")
	public String showPosts() {
		
		return "/blog/index";
	}
	
	@RequestMapping("/new")
	public String newPosts() {
		return "/blog/new";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String savePost(Post post) {
		
		System.out.println(post);
		service.save(post);
		
		//
		// if error, return 
		//
		
		return "redirect:all";
	}
}




/*	@Autowired
private BlogService service;

//HttpServletRequest

@RequestMapping(value="/post", method=RequestMethod.POST)
public ModelAndView postHome(Post val) {	
	System.out.println("post: "+val);
	
	if(val !=null) {
		service.createPost(val);
	}
	
	return new ModelAndView("home","val", val );
}*/