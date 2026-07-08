package com.enginefleet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginefleet.DTO.Manifest;
import com.enginefleet.Entity.DeliveryTask;
import com.enginefleet.Entity.Driver;
import com.enginefleet.Entity.Route;
import com.enginefleet.Entity.Vehicle;
import com.enginefleet.Enum.DeliveryStatus;
import com.enginefleet.Repository.DeliveryTaskRepository;
import com.enginefleet.Repository.DriverRepository;
import com.enginefleet.Repository.RouteRepository;
import com.enginefleet.Repository.VehicleRepository;

@Service
public class DispatchService {

	@Autowired
	private DeliveryTaskRepository taskRepository;

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private RouteRepository routeRepository;
	
	public DeliveryTask updateStatus(Long taskId) {
		
		DeliveryTask task=taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException("task not found"));
			
		if(task.getStatus()==DeliveryStatus.UNASSIGNED) {
			task.setStatus(DeliveryStatus.DISPATCHED);
		}
		else if(task.getStatus()==DeliveryStatus.DISPATCHED) {
			task.setStatus(DeliveryStatus.IN_TRANSIT);
		}
		else if(task.getStatus()==DeliveryStatus.IN_TRANSIT) {
			task.setStatus(DeliveryStatus.DELIVERED);
		}
		   else {
		        throw new RuntimeException("Delivery already completed");
		    }

		return taskRepository.save(task);
	}
	
	public DeliveryTask dispatch(Long taskId, Long driverId, Long vehicleId, Long routeId) {

		DeliveryTask task = taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException("Task not found"));

		Driver driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new RuntimeException("driver not found"));

		Vehicle vehicle = vehicleRepository.findById(routeId)
				.orElseThrow(() -> new RuntimeException("vehicle not found"));

		Route route = routeRepository.findById(routeId)
				.orElseThrow(() -> new RuntimeException("route not found"));

		task.setDriver(driver);
		task.setVehicle(vehicle);
		task.setRoute(route);
		task.setStatus(DeliveryStatus.DISPATCHED);

		return taskRepository.save(task);
	}
	
	public Manifest generateManifest(Long taskId) {
		
		DeliveryTask task=taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException("task not found"));
		
		Manifest manifest= new Manifest();
		
		manifest.setTaskId(task.getId());
		manifest.setDriverName(task.getDriver().getName());
		manifest.setVehicleNumber(task.getVehicle().getVehicleNumber());
		manifest.setSource(task.getRoute().getSource());
		manifest.setDestination(task.getRoute().getDestination());
		manifest.setStatus(task.getStatus().name());
		
		return manifest;
	}

}
