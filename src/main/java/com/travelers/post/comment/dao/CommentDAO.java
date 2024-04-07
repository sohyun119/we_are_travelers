package com.travelers.post.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.post.comment.dto.CommentDTO;

@Repository
public interface CommentDAO {
	
	public List<CommentDTO> selectCommentList(@Param("postCd") int postCd);

}
