package com.travelers.post.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.post.comment.dto.CommentDTO;

@Repository
public interface CommentDAO {
	
	public List<CommentDTO> selectCommentList(@Param("postCd") int postCd);
	
	public int insertComment(@Param("postCd") int postCd
							, @Param("userCd") int usreCd
							, @Param("userName") String userName
							, @Param("comment") String comment);
	
	public int updateComment(@Param("commentCd") int commentCd
							,@Param("comment") String comment);
	
	public int deleteComment(@Param("commentCd") int commentCd);
	
	public int deleteCommentList(@Param("postCd") int postCd);


}
