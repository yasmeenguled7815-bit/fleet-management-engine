package com.enginefleet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enginefleet.DTO.Manifest;
import com.enginefleet.Entity.DeliveryTask;
import com.enginefleet.Service.DispatchService;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
	
	@Autowired
	private DispatchService dispatchService;
	
	@PostMapping("/{taskId}")
	public DeliveryTask dispatchTask(@PathVariable Long taskId, @RequestParam Long driverId,
			@RequestParam Long vehicleId, @RequestParam Long routeId) {
		
		return dispatchService.dispatch(taskId, driverId, vehicleId, routeId);
	}
	
	@PutMapping("{taskId}/status")
	public DeliveryTask updateStatus(@PathVariable Long taskId) {
		return dispatchService.updateStatus(taskId);
}
	@GetMapping("/manifest/{taskId}")
	public Manifest getManifest(@PathVariable Long taskId) {
		return dispatchService.generateManifest(taskId);
	}
}
