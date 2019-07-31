package com.flipkart.task.scheduler.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.flipkart.task.scheduler.db.service.TaskRepository;
import com.flipkart.task.scheduler.db.service.UserTaskRepository;
import com.flipkart.task.scheduler.task.model.Status;
import com.flipkart.task.scheduler.task.model.Task;

public class FetureTaskServiceImpl implements TaskService {
	
	List<Status> allowedState = new ArrayList<Status>( Arrays.asList(Status.OPEN, Status.INPROGRESS, Status.TESTING, Status.DEPLOYED) );
	
	public String changeStatusOfTask(String id, Status status) {
		if(!allowedState.contains(status)) {
			return "Status Transition is not valid";
		}
		Task task = TaskRepository.getTaskFromId(id);
		if(task != null) {
			task.setStatus(status);
			TaskRepository.addOrUpdateTask(task);
			return "Success";
		}
		return "Task does not exist";
	}

	public String changeAssigneeOfTask(String id, String assignee) {
		Task task = TaskRepository.getTaskFromId(id);
		if(task != null) {
			String oldAssignee = task.getAssignee();
			if(oldAssignee != null && oldAssignee != "") {
				UserTaskRepository.removeTaskAssignedToUser(oldAssignee, id);
			}
			task.setAssignee(assignee);
			TaskRepository.addOrUpdateTask(task);
			UserTaskRepository.assignTaskToUser(assignee, id);
			return "Success";
		}
		
		return "Task does not exist";
		
	}
	
	public void printTaskAssignedToUser(String userId) {
		Set<String> taskIds = UserTaskRepository.getTaskAssignedToUser(userId);
		if(taskIds != null) {
			for(Task task : TaskRepository.getTaskList(taskIds)) {
				System.out.println(task);
			}
		}
	}

	public void addTaskToSprint(String taskId, String sprintId) {
		
		
	}
	
}
