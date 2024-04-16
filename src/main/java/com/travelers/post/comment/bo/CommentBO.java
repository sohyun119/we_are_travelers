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
	
	public int createComment(int postCd, int userCd, String userName, String comment) {
		return commentDAO.insertComment(postCd, userCd, userName, comment);
	}
	
	public int updateComment(int commentCd, String comment) {
		return commentDAO.updateComment(commentCd, comment);
	}
	
	public int deleteComment(int commentCd) {
		return commentDAO.deleteComment(commentCd);
	}
	
	public int deleteCommentList(int postCd) {
		return commentDAO.deleteCommentList(postCd);
	}
	


}
