package com.comsatel.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comsatel.model.Task;
import com.comsatel.repository.TaskRepository;
import com.comsatel.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository repositoryTask;
	
	@Override
	public Task save(Task task) {
		return repositoryTask.save(task);
	}
	
	@Override
	public List<Task> findAll() {
		return repositoryTask.findAll(Sort.by("description"));
	}
	
	@Override
	public void deleteById(int id) {
		repositoryTask.deleteById(id);
	}
	
	@Override
	public void deleteTasks(List<Task> tasks) {
		repositoryTask.deleteAll(tasks);
	}
	
}
