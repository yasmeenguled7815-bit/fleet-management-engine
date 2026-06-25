package com.enginefleet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginefleet.Entity.Driver;
import com.enginefleet.Entity.Vehicle;
import com.enginefleet.Repository.DriverRepository;
import com.enginefleet.Repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	
	//save
	public Vehicle saveVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	//get all
	public List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
	}
	
	//get by id
	public Vehicle getByVehicleId(Long id) {
		return vehicleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));
	}
	
	
    //fetch by id
    public Vehicle assignDriver(Long vehicleId, Long driverId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        vehicle.setDriver(driver);

        return vehicleRepository.save(vehicle);
    }
	
	//delete
	public void deleteVehicle(Long id) {
		vehicleRepository.deleteById(id);
	}

}
