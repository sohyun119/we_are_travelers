package com.travelers.post.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.like.bo.LikeBO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("likePost")
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	@GetMapping("/add")
	public Map<String, String> addLikePost(int postCd, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userCd = (Integer)session.getAttribute("userCd");
		String userName = (String) session.getAttribute("userName");
		
		Map<String, String> map = new HashMap<>();
		
		int count = likeBO.addLikePost(postCd, userCd, userName);
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("/delete")
	public Map<String, String> deleteLikePost(int likeCd){
		
		Map<String, String> map = new HashMap<>();
		
		int count = likeBO.deleteLikePost(likeCd);
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	

}
