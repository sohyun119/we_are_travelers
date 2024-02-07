package com.travelers.post.comment.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CommentDTO {
	
	private int commentCd;
	private int postCd;
	private int userCd;
	private String userName;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getCommentCd() {
		return commentCd;
	}
	public void setCommentCd(int commentCd) {
		this.commentCd = commentCd;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	@Override
	public String toString() {
		return "CommentDTO [commentCd=" + commentCd + ", postCd=" + postCd + ", userCd=" + userCd + ", userName="
				+ userName + ", comment=" + comment + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	

}
