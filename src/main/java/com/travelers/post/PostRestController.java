package com.travelers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.bo.PostBO;

//@RestController
//@RequestMapping("post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/get-coordinates")
	public String getCoordinates(@RequestParam String address) {
		
		System.out.println(postBO.getCoordinates(address));
		
		return postBO.getCoordinates(address);
		
	}
	
	
}
