package com.travelers.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelers.post.dto.PostDetailDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
	// 지역별 게시물 검색
	@GetMapping("/timelineView")
	public String locationTimelineView(Model model,@RequestParam("locationName") String locationName) {
		
		List<PostDetailDTO> postDetailList = postBO.LocationPostDetailList(locationName);
		
		model.addAttribute("postDetailList", postDetailList);
		
		
		return "";
	}
	
	

}
