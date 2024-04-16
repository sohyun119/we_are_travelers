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
	
	public int existLikePost(int postCd, int userCd) {
		return likeDAO.existLikePost(postCd, userCd);
	}
	
	public int addLikePost(int postCd, int userCd, String userName) {
		
		// 이미 좋아요 처리 한 것은 중복처리 되지 않게
		int existLikePost = this.existLikePost(postCd, userCd);
		if(existLikePost >= 1) {
			return 0;
		}
		
		return likeDAO.insertLikePost(postCd, userCd, userName);
	}
	
	public int deleteLikePost(int likeCd) {
		return likeDAO.deleteLikePost(likeCd);
	}
	
	public int deleteLikePostList(int postCd) {
		return likeDAO.deleteLikePostList(postCd);
	}

}
