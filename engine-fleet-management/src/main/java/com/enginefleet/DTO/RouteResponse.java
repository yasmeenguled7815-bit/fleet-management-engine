package com.enginefleet.DTO;

import java.util.List; 

public class RouteResponse {
	
	 private List<Coordinate> coordinates;
	 
	 private Double totalDistance;

	 public Double getTotalDistance() {
		 return totalDistance;
	 }

	 public void setTotalDistance(Double totalDistance) {
		 this.totalDistance = totalDistance;
	 }

	 public List<Coordinate> getCoordinates() {
		 return coordinates;
	 }
	 
	 public void setOptimizedRoute(List<Coordinate> optimize) {
		 this.coordinates = coordinates;
		
	 }
	 
	 

}
