package com.enginefleet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.enginefleet.Entity.Driver;
import com.enginefleet.Repository.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	
	public Driver sveDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public List<Driver> getAllDrivers(){
		return driverRepository.findAll();
	}
	
	
	public Driver getDriverById(Long id) {
		return driverRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Diver not found"));
	}
	
	public void deleteDriver(Long id) {
		driverRepository.deleteById(id);
	}

}
