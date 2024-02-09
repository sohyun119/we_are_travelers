package com.travelers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.bo.PostBO;

@RestController
@RequestMapping("post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/getCoordinates")
	public String getCoordinates(@RequestParam("locationName") String locationName) {
		
		// 외부 API 가져오는 방법으로 (반환 타입 확인) 다시 
		String result = postBO.getCoordinates(locationName);
		
		System.out.println(result);
		
		return result;
		
	}
	
	
}
