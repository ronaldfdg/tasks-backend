package com.comsatel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comsatel.model.Task;
import com.comsatel.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestController {
	
	@Autowired
	private TaskService serviceTask;
	
	@GetMapping("/tasks")
	public List<Task> index(){
		return serviceTask.findAll();
	}
	
	@PostMapping("/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public Task create(@RequestBody Task task) {
		Task newTask = null;
		newTask = serviceTask.save(task);
		return newTask;
	}
	
	@PutMapping("/tasks/{id}")
	public Task update(@RequestBody Task task, @PathVariable("id") int id) {
		Task currentTask = serviceTask.findById(id);
		
		currentTask.setDescription(task.getDescription());
		currentTask.setPending(task.isPending());
		
		return serviceTask.save(currentTask);
	}
	
	@DeleteMapping("/tasks/{id}")
	@ResponseBody
	public String deleteTask(@PathVariable("id") int id) {
		serviceTask.deleteById(id);
		return "Successfully deleted single record";
	}
	
	@DeleteMapping("/tasks")
	public void deleteTasks(@RequestBody List<Task> tasks) {
		serviceTask.deleteTasks(tasks);
	}
	
}
