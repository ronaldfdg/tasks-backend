package com.comsatel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comsatel.model.Task;
import com.comsatel.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestController {
	
	@Autowired
	private TaskService serviceTask;
	
	@PostMapping("/tasks")
	public Task create(@RequestBody Task task) {
		Task newTask = null;
		newTask = serviceTask.save(task);
		return newTask;
	}
	
}
