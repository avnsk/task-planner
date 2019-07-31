package com.flipkart.task.scheduler.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.flipkart.task.scheduler.task.model.Task;

public class TaskRepository {
	private static Map<String, Task> taskRepo = new ConcurrentHashMap<String, Task>();
	
	public static void addOrUpdateTask(Task task) {
		taskRepo.put(task.getId(), task);
	}
	
	public static Task getTaskFromId(String id) {
		return taskRepo.get(id);
	}
	
	public static List<Task> getTaskList(Set<String> ids) {
		List<Task> taskList = new ArrayList<Task>();
		for(String id : ids) {
			Task t = getTaskFromId(id);
			if(t != null) {
				taskList.add(t);
			}
		}
		
		return taskList;
	}
}
