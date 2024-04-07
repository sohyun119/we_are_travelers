package com.travelers.post.like.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Like;
import org.springframework.stereotype.Service;

import com.travelers.post.like.dao.LikeDAO;
import com.travelers.post.like.dto.LikeDTO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	
	public List<LikeDTO> selectLikeList(int postCd){
		
		List<LikeDTO> likeList = likeDAO.selectLikeList(postCd);
		
		return likeList;
	}

}
