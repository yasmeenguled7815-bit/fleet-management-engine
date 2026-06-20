package com.enginefleet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginefleet.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
