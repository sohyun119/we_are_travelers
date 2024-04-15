package com.travelers.post.like.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.post.like.dto.LikeDTO;

@Repository
public interface LikeDAO {
	
	public List<LikeDTO> selectLikeList(@Param("postCd") int postCd);
	
	public int insertLikePost(@Param("postCd") int postCd
							, @Param("userCd") int userCd
							, @Param("userName") String userName);

}
