package com.itclass.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecuredController extends AbstractController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "secured";
	}

}
