package com.travelers.user.dto;

public class LikeLocationDTO {
	
	private int locationCd;
	private int userCd;
	private String locationName;
	private String latitude;
	private String longitude;
	
	
	public int getLocationCd() {
		return locationCd;
	}
	public void setLocationCd(int locationCd) {
		this.locationCd = locationCd;
	}
	public int getUserCd() {
		return userCd;
	}
	public void setUserCd(int userCd) {
		this.userCd = userCd;
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
	
	
	@Override
	public String toString() {
		return "LikeLocationDTO [locationCd=" + locationCd + ", userCd=" + userCd + ", locationName=" + locationName
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	

}
