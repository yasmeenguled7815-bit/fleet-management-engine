package com.enginefleet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.enginefleet.DTO.RouteRequest;
import com.enginefleet.DTO.RouteResponse;
import com.enginefleet.Service.MapService;
import com.enginefleet.Service.RouteOptimizationService;

@RestController
@RequestMapping("/api/routes")
public class RouteOptimizationController {

	@Autowired
	private MapService mapService;

	@Autowired
	private RouteOptimizationService optimizationService;

	@PostMapping("/optimize")
	public RouteResponse optimizeRoute(@RequestBody RouteRequest request) {

		RouteResponse response = new RouteResponse();

		response.setOptimizedRoute(optimizationService.optimize(request.getCoordinates()));

		return response;
	}

	@GetMapping("distance")
	public String getDistanceMatrix(@RequestParam String coordinates) {

		return mapService.getDistanceMatrix(coordinates);
	}
}
