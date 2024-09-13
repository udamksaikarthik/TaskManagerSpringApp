package com.karthik.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.karthik.taskmanager.entity.Task;

public interface TaskManagerServiceImpl {

	ArrayList<Task> getTaskList();

	void updateCheckedTask(String taskName, Boolean taskCheckedStatus);

	void addTaskUpdate(String taskNameToBeAdded);

	void removeTaskUpdate(List<String> selectedTasksToDelete);

}
