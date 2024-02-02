package com.travelers.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("post")
public class PostController {
	
	@GetMapping("/home")
	public String test() {
		return "post/home";
	}
	
	@GetMapping("/timeline")
	public String test2() {
		return "post/timelineView";
	}

}
