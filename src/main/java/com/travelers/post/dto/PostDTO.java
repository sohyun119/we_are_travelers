package com.travelers.post.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PostDTO {
	
	private int postCd;
	private int userCd;
	private String userName;
	private String imgPathList;
	private String content;
	private String locationName;
	private String latitude;
	private String longitude;
	private Date createdAt;
	private Date updatedAt;
	
	
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
	public String getImgPathList() {
		return imgPathList;
	}
	public void setImgPathList(String imgPathList) {
		this.imgPathList = imgPathList;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		return "PostDTO [postCd=" + postCd + ", userCd=" + userCd + ", userName=" + userName + ", imgPathList="
				+ imgPathList + ", content=" + content + ", locationName=" + locationName + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
