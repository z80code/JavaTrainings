package com.itclass.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.itclass.model.Post;
import com.itclass.services.BlogService;

public class NotFoundController extends AbstractController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//System.out.println(service);
		return "error";
	}

}
