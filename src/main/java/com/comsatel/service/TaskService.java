package com.comsatel.service;

import java.util.List;

import com.comsatel.model.Task;

public interface TaskService {

	List<Task> findAll();
	Task save(Task task);
	Task findById(int id);
	void deleteById(int id);
	void deleteTasks(List<Task> tasks);
	
}
