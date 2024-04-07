package com.travelers.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelers.post.comment.dao.CommentDAO;
import com.travelers.post.comment.dto.CommentDTO;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public List<CommentDTO> selectCommentList(int postCd){
		return commentDAO.selectCommentList(postCd);
	}

}
