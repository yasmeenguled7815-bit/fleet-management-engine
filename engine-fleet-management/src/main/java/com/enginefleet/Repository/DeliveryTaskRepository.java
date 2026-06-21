package com.enginefleet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginefleet.Entity.DeliveryTask;

public interface DeliveryTaskRepository extends JpaRepository<DeliveryTask,Long> {

}
