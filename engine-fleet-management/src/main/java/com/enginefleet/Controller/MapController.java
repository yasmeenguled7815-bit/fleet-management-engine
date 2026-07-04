package com.enginefleet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enginefleet.Service.MapService;

@RestController
@RequestMapping("/api/maps")
public class MapController {

	@Autowired
	private MapService mapService;
	
	@GetMapping("/distance")
	public String getDistance(@RequestParam String coordinates) {
		return mapService.getDistanceMatrix(coordinates);
	}
}
