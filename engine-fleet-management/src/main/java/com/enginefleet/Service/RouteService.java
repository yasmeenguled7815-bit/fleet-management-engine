package com.enginefleet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enginefleet.Entity.Route;
import com.enginefleet.Repository.RouteRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	
	public Route saveRoute(Route route) {
		return routeRepository.save(route);
	}
	
	public List<Route> getAllRoutes() {
		return routeRepository.findAll();
	}
	
	public Route getByRouteId(Long id) {
		return routeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Route not found"));
	}
	
	public void deleteRoute(Long id) {
		routeRepository.deleteById(id);
	}

}
