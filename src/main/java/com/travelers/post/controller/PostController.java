package com.travelers.post.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("post")
public class PostController {
	
	@Value("${google.maps.key}")
	private String googlemapkey;
	
	@GetMapping("/home")
	public String test() {
		return "post/home";
	}
	
	@GetMapping("/timeline")
	public String test2() {
		return "post/timelineView";
	}
	
	@GetMapping("/create")
	public String test3(Model model) {
		
		model.addAttribute("googlemapkey", googlemapkey);
		
		return "post/createView";
	}

}
