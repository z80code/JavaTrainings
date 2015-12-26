package com.itclass.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OtherController {

	
	@RequestMapping(value="/other", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView postHome(@RequestBody Post val ) {	
		
		System.out.println(val);
		return new ModelAndView("home","val", val );
	}
	
}
