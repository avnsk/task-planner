package com.flipkart.task.scheduler.task.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.flipkart.task.scheduler.db.service.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract public class Task {
	private String id;
	private String title;
	private String creator;
	private String assignee;
	private Date dueDate;
	private TaskType taskType;
	private Status status = Status.OPEN;
	private String sprintId = StringUtils.EMPTY;
	
	@Override
    public String toString() {
		return "TaskType " + taskType + " Title " + title;
	}
	
	public void saveOrUpdate() {
		TaskRepository.addOrUpdateTask(this);
	}
}
