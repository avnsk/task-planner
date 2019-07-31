package com.flipkart.task.scheduler.task.model;


import java.util.HashSet;
import java.util.Set;

import com.flipkart.task.scheduler.db.service.SprintRepository;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sprint {
	private String id;
	private String sprintName;
	Set<String> taskList;
	public static class SprintBuilder {
		Set<String> taskList = new HashSet<String>();
	}
	public void saveOrUpdate() {
		SprintRepository.saveOrUpdate(this);
	}
}
