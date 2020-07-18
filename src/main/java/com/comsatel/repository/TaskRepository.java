package com.comsatel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comsatel.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
