package com.enginefleet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginefleet.Entity.DeliveryTask;
import com.enginefleet.Repository.DeliveryTaskRepository;

@Service
public class DeliveryTaskService {
	
	@Autowired
	private DeliveryTaskRepository deliveryTaskRepository;
	
	public DeliveryTask saveTask(DeliveryTask task) {
		return deliveryTaskRepository.save(task);
	}
	
	public List<DeliveryTask> getAllTasks(){
		return deliveryTaskRepository.findAll();
	}
	
	public DeliveryTask getTaskById(Long id) {
		return deliveryTaskRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Task not found"));
	}
	
	public void deleteTask(Long id) {
		deliveryTaskRepository.deleteById(id);
	}

}
