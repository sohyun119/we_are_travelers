package com.travelers.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	
	@GetMapping("/test")
	public String test() {
		return "post/home";
	}

}
