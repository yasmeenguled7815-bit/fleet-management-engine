package com.enginefleet.DTO;

import lombok.Data;

@Data
public class Coordinate {
	
	private Double latitude;
	private Double Longitude;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	
	
	

}
