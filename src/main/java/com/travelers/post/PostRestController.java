package com.travelers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.bo.PostBO;
import com.travelers.post.dto.GeocoderResultDTO;

@RestController
@RequestMapping("post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/getCoordinates")
	public GeocoderResultDTO getCoordinatess(@RequestParam("locationName") String locationName, Model model) {
		
		// 외부 API 가져오는 방법으로 (반환 타입 확인) 다시 (weather API 참고) 
		GeocoderResultDTO result = postBO.getCoordinatesApi(locationName);
		System.out.println(result);
		model.addAttribute("ajaxData", result);
		
		return result;
		
	}
	
	
	
}
