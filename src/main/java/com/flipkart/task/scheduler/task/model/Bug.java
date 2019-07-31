package com.flipkart.task.scheduler.task.model;

import java.util.Date;

import lombok.Builder;

public class Bug extends Task{
	@Builder
	public Bug(String id, String title, String creator, String assignee, Date dueDate, Status status, TaskType taskType, Severity severity, String sprintId) {
		super(id, title, creator, assignee, dueDate, taskType, status, sprintId);
		this.severity = severity;
		//this.status = status;
	}

	private Severity severity = Severity.P0;
	//private BugStatus status = BugStatus.OPEN;
}
