package com.travelers.post.like.dto;

import org.springframework.stereotype.Component;

@Component
public class LikeDTO {
	
	private int likeCd;
	private int postCd;
	private int userCd;
	private String userName;
	
	public int getLikeCd() {
		return likeCd;
	}
	public void setLikeCd(int likeCd) {
		this.likeCd = likeCd;
	}
	public int getPostCd() {
		return postCd;
	}
	public void setPostCd(int postCd) {
		this.postCd = postCd;
	}
	public int getUserCd() {
		return userCd;
	}
	public void setUserCd(int userCd) {
		this.userCd = userCd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "LikeDTO [likeCd=" + likeCd + ", postCd=" + postCd + ", userCd=" + userCd + ", userName=" + userName
				+ "]";
	}
	
	
	

}
