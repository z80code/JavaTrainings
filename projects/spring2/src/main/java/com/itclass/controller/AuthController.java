package com.itclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@Autowired
	HttpServletRequest req;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLogin() {	
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView postHome(String username, String password) {	
		if("user".equals(username) && "123".equals(password)) {
			req.getSession().setAttribute("user", username);
		}
		return new ModelAndView("redirect:secured");
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public ModelAndView logout(String username) {	
		req.getSession().removeAttribute("user");
		return new ModelAndView("redirect:secured");
	}
	
	@RequestMapping(value="/secured", method=RequestMethod.GET)
	public ModelAndView getHome() {	
		
		String username = 
				(String) req.getSession().getAttribute("user");
		if(username!=null) {
			return new ModelAndView("secured","user", username );
		} else {
			return new ModelAndView("login");
		}
	}
}