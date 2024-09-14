package com.karthik.taskmanager.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.taskmanager.entity.Task;

@Repository
public class TaskManagerDao {
	
	@Autowired
	private TaskManagerRepository taskManagerRepository;
	
	private ArrayList<Task> taskList = new ArrayList<>();

	public ArrayList<Task> getTaskList(String username) {
		// TODO Auto-generated method stub
		System.out.println("Inside getTaskList Method");
		System.out.println("------------------------------------");
		taskList = (ArrayList<Task>) taskManagerRepository.findByUsername(username.trim());
		Date todayDate = new Date();
		for (Task task : taskList) {
			System.out.println("task: "+ task.toString());
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(task.getTaskDate());
			cal2.setTime(todayDate);
			System.out.println("cal1: "+cal1);
			System.out.println("cal2: "+cal2);
			if(task.getTaskDate()==null) {
				System.out.println("Inside If Condition");
				task.setTaskDate(todayDate);
				task.setChecked(false);
				taskManagerRepository.updateById(task.getTaskId(), task.getTaskDate(), task.getChecked());
			}else if(cal1.get(Calendar.YEAR) <= cal2.get(Calendar.YEAR)){
				if(cal1.get(Calendar.MONTH) <= cal2.get(Calendar.MONTH)){
					if(cal1.get(Calendar.DATE) < cal2.get(Calendar.DATE)){
						task.setTaskDate(todayDate);
						task.setChecked(false);
						taskManagerRepository.updateById(task.getTaskId(), task.getTaskDate(), task.getChecked());
					}
				}
			}
		}
		taskList = (ArrayList<Task>) taskManagerRepository.findByUsername(username.trim());
		System.out.println("------------------------------------");
		return taskList;
	}

	public void updateCheckedTask(String taskName, Boolean taskCheckedStatus) {
		// TODO Auto-generated method stub
		taskManagerRepository.updateCheckedTask(taskName.trim(), taskCheckedStatus);
	}

	public void addTaskUpdate(String taskNameToBeAdded, String username) {
		// TODO Auto-generated method stub
		Date todayDate = new Date();
		Task task = new Task();
		task.setTaskDate(todayDate);
		task.setTaskName(taskNameToBeAdded);
		task.setUsername(username.trim());
		taskManagerRepository.save(task);
		
	}

	public void removeTaskUpdate(List<String> selectedTasksToDelete, String username) {
		// TODO Auto-generated method stub
		for (String selectedTaskName : selectedTasksToDelete) {
			selectedTaskName = selectedTaskName.trim();
			taskManagerRepository.deleteTaskByTaskName(selectedTaskName, username.trim());
		}
	}
	
}
