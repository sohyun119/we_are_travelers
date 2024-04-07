package com.travelers.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.post.dto.PostDTO;

@Repository
public interface PostDAO {
	
	public int insertPost(@Param("userCd") int userCd
						 ,@Param("userName") String userName
						 ,@Param("imgPath") String filePath
						 ,@Param("content") String content
						 ,@Param("locationName") String locationName
						 ,@Param("lat") String lat
						 ,@Param("lng") String lng);
	
	public List<PostDTO> selectLocationPostList(@Param("locationName") String locationName
							 ,@Param("lat") String lat
							 ,@Param("lng") String lng);
	
	public int deletePost(@Param("postCd") int postCd);
	

}
