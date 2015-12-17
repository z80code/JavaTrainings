package com.itclass.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class PostController {
	
	@RequestMapping(value="/add", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public Post  postIndex(@RequestBody Post post  ) {
		System.out.println("post: "+post);
		return post;
	}
	
}
