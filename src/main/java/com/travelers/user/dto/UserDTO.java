package com.travelers.user.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

public class UserDTO {
	
	private int userCd;
	private String loginId;
	private String password;
	private String userName;
	private String email;
	private String profileImgPath;
	private Date createdAt;
	private Date updatedAt;
	
	// 생성자를 쓰지 않아서 null값이 반환 되는 이슈가 있었다. -> 블로그 정리 
	public UserDTO(int userCd, String loginId, String password, String userName, String email, String profileImgPath,Date createdAt,Date updatedAt) {
        this.userCd = userCd;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.profileImgPath = profileImgPath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
	
	public int getUserCd() {
		return userCd;
	}
	public void setUserCd(int userCd) {
		this.userCd = userCd;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImgPath() {
		return profileImgPath;
	}
	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
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
		return "UserDTO [userCd=" + userCd + ", loginId=" + loginId + ", password=" + password + ", userName="
				+ userName + ", email=" + email + ", profileImgPath=" + profileImgPath + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	

}
