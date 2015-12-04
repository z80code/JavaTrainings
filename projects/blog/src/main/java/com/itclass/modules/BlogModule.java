package com.itclass.modules;

import com.google.inject.AbstractModule;
import com.itclass.controllers.Controller;
import com.itclass.controllers.HomeController;
import com.itclass.services.BlogService;
import com.itclass.services.BlogServiceImpl;

public class BlogModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BlogService.class).to(BlogServiceImpl.class);
		bind(Controller.class).to(HomeController.class);
	}

}
