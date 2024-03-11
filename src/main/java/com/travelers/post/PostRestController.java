package com.travelers.post;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travelers.post.bo.PostBO;
import com.travelers.post.dto.GeocoderResultDTO;

@RestController
@RequestMapping("post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
	
	@GetMapping("/getCoordinates")
	public GeocoderResultDTO getCoordinatess(@RequestParam("locationName") String locationName, Model model) {
		
		GeocoderResultDTO result = postBO.getCoordinatesApi(locationName);
		System.out.println(result);
		model.addAttribute("ajaxData", result);
		
		return result;
		
	}
	
	public String createFiles(List<MultipartFile> files) throws IllegalStateException, IOException {
		String responseMessage = "fail";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String uploadDate = sdf.format(new Date());
		
		for(MultipartFile file : files) {
			if(!file.getOriginalFilename().isEmpty()) {
				
				// 원본 파일 이름
				String originalFilename = file.getOriginalFilename();
				
				// 범용고유식별자 UUID생성
				UUID uuid = UUID.randomUUID();
				
				// 파일 이름 수정
				String uploadFileName = uploadDate + "_" + uuid + "_" + originalFilename;
				
				file.transferTo(new File(fileRepositoryPath + uploadFileName));
				
				responseMessage = "success";
			}
		}
		return responseMessage;
	}
	
	@PostMapping("/create")
	public String createPost(@RequestParam("map") String locationName
							,@RequestParam("contentText") String content
							,@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		
		GeocoderResultDTO result = postBO.getCoordinatesApi(locationName);
		System.out.println(result);
		
		
		
		return "";
	}
	
	
	
}
