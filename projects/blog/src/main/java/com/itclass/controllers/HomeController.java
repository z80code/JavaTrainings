package com.itclass.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.itclass.model.Post;
import com.itclass.services.BlogService;

public class HomeController extends AbstractController {

	@Inject
	private BlogService service;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("in home");
		List<Post> posts = service.getAll();
		System.out.println(posts);
		//System.out.println(service);
		return "home";
	}

}
