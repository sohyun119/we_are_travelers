package com.travelers.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travelers.post.bo.PostBO;
import com.travelers.post.dto.GeocoderResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	
	@GetMapping("/getCoordinates")
	public GeocoderResultDTO getCoordinatess(@RequestParam("locationName") String locationName, Model model) {
		
		GeocoderResultDTO result = postBO.getCoordinatesApi(locationName);
		System.out.println(result);
		model.addAttribute("ajaxData", result);
		
		return result;
		
	}
	
	
	@PostMapping("/create")
	public Map<String, String> createPost(@RequestParam("lat") String lat
							,@RequestParam("lng") String lng
							,@RequestParam("location") String location
							,@RequestParam("content") String content
							,@RequestParam("files") MultipartFile[] files
							,HttpServletRequest request) throws IllegalStateException, IOException {
		
		HttpSession session = request.getSession();
		
		int userCd = (int)session.getAttribute("userCd");
		String userName = (String)session.getAttribute("userName");
		
		System.out.println("userCd:"+userCd+", userName:"+userName);
		
		// add post
		int resultCount = postBO.addPost(userCd, userName, files, content, 
				location, lat, lng);
		
		Map<String, String> map = new HashMap<>();
		if(resultCount == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
	
}
