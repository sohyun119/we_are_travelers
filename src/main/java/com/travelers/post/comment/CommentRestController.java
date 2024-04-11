package com.travelers.post.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.post.comment.bo.CommentBO;

@RestController
@RequestMapping("comment")
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/create")
	public String createComment(@RequestParam("postCd") int postCd) {
		// 추가 코딩 
		return "";
	}

}
