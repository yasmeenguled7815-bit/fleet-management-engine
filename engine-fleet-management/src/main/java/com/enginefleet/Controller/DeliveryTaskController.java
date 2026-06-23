package com.enginefleet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enginefleet.Entity.DeliveryTask;
import com.enginefleet.Repository.DeliveryTaskRepository;

@Controller
@RequestMapping("/api/tasks")
public class DeliveryTaskController {

	@Autowired 
	private DeliveryTaskRepository deliveryTaskRepository;
	
	@PostMapping
	public DeliveryTask createTask(@RequestBody DeliveryTask task) {
		return deliveryTaskRepository.save(task);
	}
	
	 @GetMapping
	    public List<DeliveryTask> getAllTasks() {
	        return deliveryTaskRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public DeliveryTask getTaskById(@PathVariable Long id) {
	        return deliveryTaskRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Task not found"));
	    }

	    @DeleteMapping("/{id}")
	    public String deleteTask(@PathVariable Long id) {
	        deliveryTaskRepository.deleteById(id);
	        return "Task deleted successfully";
	    }
}
