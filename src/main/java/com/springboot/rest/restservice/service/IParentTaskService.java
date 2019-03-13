package com.springboot.rest.restservice.service;


import com.springboot.rest.restservice.entity.ParentTask;

public interface IParentTaskService {
	ParentTask createParentTask(ParentTask parentTask);

	Iterable<ParentTask> retrieveParentTasks();
	
	ParentTask updateParentTask(ParentTask parentTask);
}
