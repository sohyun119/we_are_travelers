package com.travelers.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelers.post.bo.PostBO;
import com.travelers.post.dto.PostDetailDTO;

@Controller
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@Value("${google.maps.key}")
	private String googlemapkey;
	
	@GetMapping("/homeView")
	public String test() {
		return "post/home";
	}
	
	@GetMapping("/timelineView")
	public String test2() {
		return "post/timelineView";
	}
	
	@GetMapping("/createView")
	public String test3(Model model) {
		
		model.addAttribute("googlemapkey", googlemapkey);
		
		return "post/createView";
	}
	
	// 지역별 게시물 검색
	@GetMapping("/locationTimelineView")
	public String locationTimelineView(Model model,@RequestParam("locationName") String locationName) {
		
		List<PostDetailDTO> postDetailList = postBO.locationPostDetailList(locationName);
		
		model.addAttribute("postDetailList", postDetailList);
		
		
		return "post/timelineView";
	}
	
	

}
