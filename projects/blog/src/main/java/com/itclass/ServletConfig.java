package com.itclass;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.itclass.modules.BlogModule;

@WebListener
public class ServletConfig extends GuiceServletContextListener  {

//	@Override
//	protected Injector getInjector() {
//		System.out.println("get injection");
//		
//		return Guice.createInjector(new ServletModule(), new BlogModule());
//	}

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
		new ServletModule() {
            @Override protected void configureServlets() {
            	super.configureServlets();
            	
            	filter("/*").through(UrlFilter.class);
                //serve("/*").with(DispatcherServlet.class);
            }
        },
        new BlogModule());
	}
}
