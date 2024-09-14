package com.karthik.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.karthik.taskmanager.entity.Task;

public interface TaskManagerServiceImpl {

	ArrayList<Task> getTaskList(String string);

	void updateCheckedTask(String taskName, Boolean taskCheckedStatus);

	void addTaskUpdate(String taskNameToBeAdded, String string);

	void removeTaskUpdate(List<String> selectedTasksToDelete, String string);

}
