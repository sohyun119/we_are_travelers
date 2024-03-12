package com.travelers.post;

import java.io.IOException;
import java.util.List;

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
	public String createPost(@RequestParam("map") String locationName
							,@RequestParam("contentText") String content
							,@RequestParam("files") List<MultipartFile> files
							,HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		// 지역 이름, 위도, 경도 가져오기
		GeocoderResultDTO geocoderResultDTO = postBO.getCoordinatesApi(locationName);
		if(geocoderResultDTO == null) {
			return null;
		}
		
		// 이미지 저장 및 경로 리스트 가져오기
		List<String> imgPathList = postBO.uploadFiles(files);
		
		HttpSession session = request.getSession();
		
		int resultCount = postBO.addPost(session.getAttribute("userCd"), session.getAttribute("userName"), imgPathList, content, 
				geocoderResultDTO.getLocationName(), geocoderResultDTO.getLat(), geocoderResultDTO.getLng());
		
		return "";
	}
	
	
	
}
