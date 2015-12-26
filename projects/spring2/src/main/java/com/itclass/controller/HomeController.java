package com.itclass.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//@RequestMapping("/home")
	//@ResponseBody
	//public String home() {
	//	return "Home controller";
	//}
	
//	@RequestMapping("/home")
//	public String home( Model model ) {
//		model.addAttribute("val", 2344);
//		return "home";
//	}
	
//	@RequestMapping("/home")
//	public ModelAndView home( ) {
//		return new ModelAndView("home","val", 2344 );
//	}
	
	
//	@RequestMapping("/home")
//	public ModelAndView home(
//			@RequestParam(required=false, defaultValue="12") 
//			Integer val) {
//		
//		return new ModelAndView("home","val", val );
//	}
	
//	@RequestMapping("/home")
//	public ModelAndView home(
//			Post val ) {	
//		return new ModelAndView("home","val", val );
//	}
	
//	
//	@RequestMapping("/home")
//	public ModelAndView getHome() {	
//		return new ModelAndView("home");
//	}
//	
//	@RequestMapping(value="/home", method=RequestMethod.POST)
//	public ModelAndView postHome( Post val ) {	
//		return new ModelAndView("home","val", val );
//	}
	
	@RequestMapping("/home")
	public ModelAndView getHome() {	
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public ModelAndView postHome(@RequestBody Post val ) {	
		
		System.out.println(val);
		return new ModelAndView("home","val", val );
	}
	
}
