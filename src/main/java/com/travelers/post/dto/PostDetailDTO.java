package com.travelers.post.dto;

import org.springframework.stereotype.Component;

@Component
public class PostDetailDTO {
	
	private PostDTO postDTO;

	
	
	public PostDTO getPostDTO() {
		return postDTO;
	}

	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}
	
	

}
