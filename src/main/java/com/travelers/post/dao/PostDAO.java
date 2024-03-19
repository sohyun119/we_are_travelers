package com.travelers.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {
	
	public int insertPost(@Param("userCd") int userCd
						 ,@Param("userName") String userName
						 ,@Param("imgPath") String filePath
						 ,@Param("content") String content
						 ,@Param("locationName") String locationName
						 ,@Param("lat") String lat
						 ,@Param("lng") String lng);
	
	

}
