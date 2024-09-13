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
	public ArrayList<Task> getTaskList() {
		return taskManagerDao.getTaskList();
	}

	@Override
	public void updateCheckedTask(String taskName, Boolean taskCheckedStatus) {
		taskManagerDao.updateCheckedTask(taskName, taskCheckedStatus);
		
	}

	@Override
	public void addTaskUpdate(String taskNameToBeAdded) {
		taskManagerDao.addTaskUpdate(taskNameToBeAdded);
		
	}

	@Override
	public void removeTaskUpdate(List<String> selectedTasksToDelete) {
		taskManagerDao.removeTaskUpdate(selectedTasksToDelete);
	}
	
}
