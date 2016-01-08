package com.itclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home/text")
	@ResponseBody
	public String getText() {
		return "some text";
	}
	
//	@RequestMapping(value="/home/object",method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody Post getObject() {
//		return new Post(123,"fsdf");
//	}
	
//	@RequestMapping("/home")
//	public String getIndex( Model model ) {
//		
//		model.addAttribute("message", "hi, from controller");
//		
//		return "index";
//	}
	
	@RequestMapping("/home")
	public ModelAndView getIndex(  ) {
		System.out.println("get");
		String message = "hi, from controller";
		return new ModelAndView("index", "message", message);
	}
	
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public ModelAndView postIndex(Post post  ) {
		
		System.out.println("post: "+post);
		String message = "title: "+ post;
		return new ModelAndView("index", "message", message);
	}
	
	
	@RequestMapping(value="/home2", method = RequestMethod.POST )
	public ModelAndView postIndex( 
			String title  ) {
		
		System.out.println("post: "+title);
		String message = "title: "+title;
		return new ModelAndView("index", "message", message);
	}
	
}