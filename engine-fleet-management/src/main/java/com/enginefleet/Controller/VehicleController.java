package com.enginefleet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enginefleet.Entity.Driver;
import com.enginefleet.Entity.Vehicle;
import com.enginefleet.Repository.DriverRepository;
import com.enginefleet.Repository.VehicleRepository;

@Controller
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@PostMapping
	public Vehicle registerVehicle(@RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	@GetMapping
	public List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {
		return vehicleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));
	}
	
	 @PutMapping("/{vehicleId}/assign/{driverId}")
	public Vehicle asssignDriver(@PathVariable Long vehicleId,@PathVariable Long driverId) {
		
		Vehicle vehicle=vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));
		
		Driver driver=driverRepository.findById(driverId)
				.orElseThrow(() -> new RuntimeException("Driver not found"));
		
		vehicle.setDriver(driver);
		
		return vehicleRepository.save(vehicle);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
	}

}
