package com.travelers.post.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.travelers.post.comment.dto.CommentDTO;
import com.travelers.post.like.dto.LikeDTO;

@Component
public class PostDetailDTO {
	
	private PostDTO postDTO;
	private List<CommentDTO> commentDTOList;
	private List<LikeDTO> likeDTOList;
	
	public PostDTO getPostDTO() {
		return postDTO;
	}
	
	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}

	public List<CommentDTO> getCommentDTOList() {
		return commentDTOList;
	}


	public void setCommentDTOList(List<CommentDTO> commentDTOList) {
		this.commentDTOList = commentDTOList;
	}


	public List<LikeDTO> getLikeDTOList() {
		return likeDTOList;
	}


	public void setLikeDTOList(List<LikeDTO> likeDTOList) {
		this.likeDTOList = likeDTOList;
	}

	@Override
	public String toString() {
		return "PostDetailDTO [postDTO=" + postDTO + ", commentDTOList=" + commentDTOList + ", likeDTOList="
				+ likeDTOList + "]";
	}

	
	
}
