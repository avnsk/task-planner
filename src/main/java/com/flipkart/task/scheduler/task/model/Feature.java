package com.flipkart.task.scheduler.task.model;

import java.util.Date;

import lombok.Builder;

 public class Feature extends Task{
	@Builder
	public Feature(String id, String title, String creator, String assignee, Date dueDate, Status status, TaskType taskType, String featureSummary, Impact impact, String sprintId) {
		super(id, title, creator, assignee, dueDate, taskType, status, sprintId);
		//this.featureSummary = featureSummary;
		//this.impact = impact;
		//this.status =  status;
	}
	private String featureSummary = "";
	private Impact impact = Impact.LOW;
	//private FeatureStatus status = FeatureStatus.OPEN;
	
	@Override
	public String toString() {
		return super.toString();
	}
}
