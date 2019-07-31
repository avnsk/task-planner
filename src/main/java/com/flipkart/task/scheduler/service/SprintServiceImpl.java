package com.flipkart.task.scheduler.service;

import org.apache.commons.lang.StringUtils;

import com.flipkart.task.scheduler.db.service.SprintRepository;
import com.flipkart.task.scheduler.db.service.TaskRepository;
import com.flipkart.task.scheduler.task.model.Sprint;
import com.flipkart.task.scheduler.task.model.Task;

public class SprintServiceImpl {
	
	public String addTaskToSprint(String taskId, String sprintId) {
		Task task = TaskRepository.getTaskFromId(taskId);
		if(task != null) {
			Sprint sprint  = SprintRepository.getSprintFromId(sprintId);
			if(sprint != null) {
				String oldSprintId = task.getSprintId();
				if(!StringUtils.isBlank(oldSprintId)) {
					removeTaskFromSprint(taskId, oldSprintId);
				}
				task.setSprintId(sprintId);
				sprint.getTaskList().add(taskId);
				SprintRepository.saveOrUpdate(sprint);
				TaskRepository.addOrUpdateTask(task);
				return "Task added to the sprint succesfully";
			}else {
				return "Sprint with Id does not exists";
			}
		}else{
			return "Task with Id does not exists";
		}
	}
	
	public String removeTaskFromSprint(String taskId, String sprintId) {
		Sprint sprint  = SprintRepository.getSprintFromId(sprintId);
		if(sprint != null) {
			sprint.getTaskList().remove(taskId);
			SprintRepository.saveOrUpdate(sprint);
			return "Task removed from sprint succesfully";
		}else {
			return "Sprint with Id does not exists";
		}
	}
}
