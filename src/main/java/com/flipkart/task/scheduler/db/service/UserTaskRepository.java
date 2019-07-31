package com.flipkart.task.scheduler.db.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class UserTaskRepository {
	static Map<String, Set<String>> userTaskRepo = new ConcurrentHashMap<String, Set<String>>();
	
	public static void assignTaskToUser(String userId, String taskId) {
		if(userTaskRepo.containsKey(userId)) {
			userTaskRepo.get(userId).add(taskId);
		}else {
			Set<String> hashSet = new HashSet<String>();
			hashSet.add(taskId);
			userTaskRepo.put(userId, hashSet);
		}
	}
	
	public static Set<String> getTaskAssignedToUser(String userId) {
		return userTaskRepo.get(userId);
	}
	
	public static void removeTaskAssignedToUser(String userId, String taskId) {
		userTaskRepo.get(userId).remove(taskId);
	}
}
