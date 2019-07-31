package com.flipkart.task_scheduler;

import java.util.Date;

import com.flipkart.task.scheduler.service.SprintServiceImpl;
import com.flipkart.task.scheduler.service.TaskService;
import com.flipkart.task.scheduler.service.TaskServiceGetImpl;
import com.flipkart.task.scheduler.task.model.Feature;
import com.flipkart.task.scheduler.task.model.Impact;
import com.flipkart.task.scheduler.task.model.Sprint;
import com.flipkart.task.scheduler.task.model.Task;
import com.flipkart.task.scheduler.task.model.TaskType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Task newFeatureTask = Feature.builder().featureSummary("Create Console for Debugging").dueDate(new Date()).taskType(TaskType.FEATURE).id("1").
        		title("SetUp Console").impact(Impact.HIGH).build();
        newFeatureTask.saveOrUpdate();
        TaskService taskService = TaskServiceGetImpl.getTaskServiceForTask(newFeatureTask);
        taskService.changeAssigneeOfTask(newFeatureTask.getId(), "A6214A");
        taskService.printTaskAssignedToUser("A6214A");
        
        Sprint sprint = Sprint.builder().id("1").sprintName("Sprint 1").build();
        sprint.saveOrUpdate();
        SprintServiceImpl sprintService = new SprintServiceImpl();
        sprintService.addTaskToSprint(newFeatureTask.getId(), sprint.getId());
    }
}
