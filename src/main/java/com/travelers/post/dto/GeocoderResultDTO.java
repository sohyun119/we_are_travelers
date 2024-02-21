package com.travelers.post.dto;

public class GeocoderResultDTO {
	
	private String locationName;
	private String lat;
	private String lng;
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "GeocoderResultDTO [locationName=" + locationName + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	

}
