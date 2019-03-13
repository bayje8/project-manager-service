package com.springboot.rest.restservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> retrieveAllTasks(int projectId) {
		List<Task> list = new ArrayList<Task>();
		Iterable<Task> iterable = taskRepository.findAll();
		for (Task task : iterable) {
			if(task.getProject_id() == projectId) {
				list.add(task);
			}
		}
		return list;
	}

	@Override
	public Task retrieveTaskById(int id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task editTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}

}
