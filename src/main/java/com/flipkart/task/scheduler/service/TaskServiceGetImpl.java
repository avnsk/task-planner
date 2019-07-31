package com.flipkart.task.scheduler.service;

import java.util.HashMap;
import java.util.Map;

import com.flipkart.task.scheduler.task.model.Task;
import com.flipkart.task.scheduler.task.model.TaskType;

public class TaskServiceGetImpl {
	static Map<TaskType, TaskService> mp = new HashMap();
	static {
		mp.put(TaskType.FEATURE, new FetureTaskServiceImpl());
	}
	public static TaskService getTaskServiceForTask(Task task) {
		return mp.get(task.getTaskType());
	}
}
