package com.flipkart.task.scheduler.db.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flipkart.task.scheduler.task.model.Sprint;

public class SprintRepository {
	private static Map<String, Sprint> sprintRepo = new ConcurrentHashMap<String, Sprint>();
	
	public static void saveOrUpdate(Sprint sprint) {
		sprintRepo.put(sprint.getId(), sprint);
	}
	
	public static Sprint getSprintFromId(String id) {
		return sprintRepo.get(id);
	}
}
