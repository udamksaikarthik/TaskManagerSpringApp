package com.karthik.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthik.taskmanager.dao.TaskManagerDao;
import com.karthik.taskmanager.entity.Task;

@Service
public class TaskManagerService implements TaskManagerServiceImpl{
	
	@Autowired
	private TaskManagerDao taskManagerDao;

	@Override
	public ArrayList<Task> getTaskList(String username) {
		return taskManagerDao.getTaskList(username);
	}

	@Override
	public void updateCheckedTask(String taskName, Boolean taskCheckedStatus) {
		taskManagerDao.updateCheckedTask(taskName, taskCheckedStatus);
		
	}

	@Override
	public void addTaskUpdate(String taskNameToBeAdded, String username) {
		taskManagerDao.addTaskUpdate(taskNameToBeAdded, username);
		
	}

	@Override
	public void removeTaskUpdate(List<String> selectedTasksToDelete, String username) {
		taskManagerDao.removeTaskUpdate(selectedTasksToDelete, username);
	}
	
}
