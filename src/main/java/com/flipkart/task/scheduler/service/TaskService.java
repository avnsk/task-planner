package com.flipkart.task.scheduler.service;

import com.flipkart.task.scheduler.task.model.Status;

public interface TaskService {
	String changeStatusOfTask(String id, Status status);
	String changeAssigneeOfTask(String id, String assignee);
	void printTaskAssignedToUser(String userId);
	void addTaskToSprint(String taskId, String sprintId);
}
