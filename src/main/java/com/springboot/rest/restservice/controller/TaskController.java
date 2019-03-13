package com.springboot.rest.restservice.controller;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.restservice.entity.Task;
import com.springboot.rest.restservice.service.ITaskService;

@CrossOrigin(maxAge = 3600)
@RestController
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@GetMapping("/tasks/byproject/{projectId}")
	public List<Task> retrieveAllTasks(@PathVariable int projectId) {
		return taskService.retrieveAllTasks(projectId);
	}

	@GetMapping("/tasks/{id}")
	public Task retrieveTaskById(@PathVariable int id) {
		return taskService.retrieveTaskById(id);
	}

	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task savedTask = taskService.createTask(task);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTask.getTask_id()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/tasks/{id}")
	public  ResponseEntity<Task>  editTask(@RequestBody Task task, @PathVariable int id) {
		Task savedTask =  taskService.editTask(task);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTask.getTask_id()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("tasks/{id}")
	public void deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
	}
}
