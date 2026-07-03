package com.enginefleet.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enginefleet.Entity.Route;
import com.enginefleet.Repository.RouteRepository;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
	
	@Autowired
	private RouteRepository routeRepository;
	
	@PostMapping
	public Route addRoute(@RequestBody Route route) {
		return routeRepository.save(route);
	}
	
	@GetMapping
	public List<Route> getAllRutes(){
		return routeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Route getById(@PathVariable Long id) {
		return routeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Route not found"));
	}
	
	@DeleteMapping("/{id}")
	public String deleteRoute(@PathVariable Long id) {
		routeRepository.deleteById(id);
		return "Route deleted successfully";
	}

}
