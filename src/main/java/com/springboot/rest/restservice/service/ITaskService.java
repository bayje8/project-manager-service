package com.springboot.rest.restservice.service;

import java.util.List;

import com.springboot.rest.restservice.entity.Task;

public interface ITaskService {
	List<Task> retrieveAllTasks(int projectId);

	Task retrieveTaskById(int id);

	Task createTask(Task task);

	Task editTask(Task task);

	void deleteTask(int id);
}
