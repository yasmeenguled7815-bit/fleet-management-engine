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

import com.enginefleet.Entity.Driver;
import com.enginefleet.Repository.DriverRepository;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@PostMapping
	public Driver addDriver(@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@GetMapping
	public List<Driver> getAllDrivers(){
		return driverRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Driver getById(@PathVariable Long id) {
		return driverRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Driver not found"));
	}
	
	@DeleteMapping("/{id}")
	public String deleteDriver(@PathVariable Long id) {
		driverRepository.deleteById(id);
		return "successfully deleted";
	}

}
