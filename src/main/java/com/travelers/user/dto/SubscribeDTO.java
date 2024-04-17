package com.travelers.user.dto;

import java.util.Date;

public class SubscribeDTO {
	
	private int subscribeCd;
	private int thisUserCd;
	private int userCd;
	private String thisUserName;
	private String userName;
	private Date createdAt;
	
	
	public int getSubscribeCd() {
		return subscribeCd;
	}
	public void setSubscribeCd(int subscribeCd) {
		this.subscribeCd = subscribeCd;
	}
	public int getThisUserCd() {
		return thisUserCd;
	}
	public void setThisUserCd(int thisUserCd) {
		this.thisUserCd = thisUserCd;
	}
	public int getUserCd() {
		return userCd;
	}
	public void setUserCd(int userCd) {
		this.userCd = userCd;
	}
	public String getThisUserName() {
		return thisUserName;
	}
	public void setThisUserName(String thisUserName) {
		this.thisUserName = thisUserName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "SubscribeDTO [subscribeCd=" + subscribeCd + ", thisUserCd=" + thisUserCd + ", userCd=" + userCd
				+ ", thisUserName=" + thisUserName + ", userName=" + userName + ", createdAt=" + createdAt + "]";
	}
	
	
	

}
