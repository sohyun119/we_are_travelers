package com.travelers.post.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.comment.bo.CommentBO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("comment")
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, String> createComment(@RequestParam("postCd") int postCd
							 	,@RequestParam("comment") String comment
							 	,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userCd = (Integer)session.getAttribute("userCd");
		String userName = (String)session.getAttribute("userName");
		
		Map<String, String> map = new HashMap<>();
		int count = commentBO.createComment(postCd, userCd, userName, comment);
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@PostMapping("/update")
	public Map<String, String> updateComment(@RequestParam("commentCd") int commentCd
											,@RequestParam("comment") String comment){
		Map<String, String> map = new HashMap<>();
		int count = commentBO.updateComment(commentCd, comment);
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("/delete")
	public Map<String, String> deleteComment(@RequestParam("commentCd") int commentCd){
		
		Map<String, String> map = new HashMap<>();
		int count = commentBO.deleteComment(commentCd);
		
		if(count == 1) {
			map.put("result","success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	

}
