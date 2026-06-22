package com.enginefleet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enginefleet.Entity.Driver;

public interface DriverRepository extends JpaRepository<Driver,Long> {

}
