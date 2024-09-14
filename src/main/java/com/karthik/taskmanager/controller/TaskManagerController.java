package com.karthik.taskmanager.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karthik.taskmanager.entity.Task;
import com.karthik.taskmanager.entity.Users;
import com.karthik.taskmanager.service.TaskManagerServiceImpl;

@Controller
public class TaskManagerController {
	
	@Autowired
	private TaskManagerServiceImpl taskManagerServiceImpl;
	
	private ArrayList<Task> taskList = new ArrayList<>();

	@GetMapping("/")
	public ModelAndView handleFirstCall(Principal principal) {
		System.out.println("Inside handleFirstCall");
		System.out.println("----------------------------------");
		ModelAndView mv = new ModelAndView();
		taskList = taskManagerServiceImpl.getTaskList(principal.getName());
		mv.addObject("taskList", taskList);
		mv.addObject("username", principal.getName());
		mv.setViewName("index.html");
		System.out.println("----------------------------------");
		return mv;
	}
	
	@GetMapping("/checkedTask")
	public ModelAndView updateCheckedTask(
			@RequestParam(value = "param1", defaultValue = "task") String taskName,
			@RequestParam(value = "param2", defaultValue = "false") Boolean taskCheckedStatus) {
		System.out.println("Inside updateCheckedTask");
		System.out.println("----------------------------------");
		System.out.println("taskName: "+taskName);
		System.out.println("taskCheckedStatus: "+taskCheckedStatus);
		taskManagerServiceImpl.updateCheckedTask(taskName, taskCheckedStatus);
		ModelAndView mv = new ModelAndView("redirect:/");
		System.out.println("----------------------------------");
		return mv;
	}
	

	@GetMapping("/addTask")
	public ModelAndView showAddTask() {
		System.out.println("Inside showAddTask");
		System.out.println("----------------------------------");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddTask.html");
		System.out.println("----------------------------------");
		return mv;
	}
	
	@PostMapping("/addTaskEvent")
	public ModelAndView addTaskUpdate(
			@RequestParam("taskNameToBeAdded") String taskNameToBeAdded,
			Principal principal
			) {
		System.out.println("Inside addTaskUpdate");
		System.out.println("----------------------------------");
		System.out.println("taskNameToBeAdded: "+taskNameToBeAdded);
		taskManagerServiceImpl.addTaskUpdate(taskNameToBeAdded, principal.getName());
		ModelAndView mv = new ModelAndView("redirect:/");
		System.out.println("----------------------------------");
		return mv;
	}
	
	@GetMapping("/removeTask")
	public ModelAndView showRemoveTask(Principal principal) {
		System.out.println("Inside showRemoveTask");
		System.out.println("----------------------------------");
		ModelAndView mv = new ModelAndView();
		taskList = taskManagerServiceImpl.getTaskList(principal.getName());
		mv.addObject("taskList", taskList);
		mv.setViewName("RemoveTask.html");
		System.out.println("----------------------------------");
		return mv;
	}
	
	@PostMapping("/removeTaskEvent")
	public ModelAndView removeTaskUpdate(
			@RequestParam(name = "taskname", required = false) List<String> selectedTasksToDelete,
			Principal principal) {
		System.out.println("Inside removeTaskUpdate");
		System.out.println("----------------------------------");
        ModelAndView mv = new ModelAndView("redirect:/");

        // If no checkboxes are checked, the "selectedTasksToDelete" list will be null
        if (selectedTasksToDelete != null && !selectedTasksToDelete.isEmpty()) {
            System.out.println("selectedTasksToDelete : " + selectedTasksToDelete);
            taskManagerServiceImpl.removeTaskUpdate(selectedTasksToDelete, principal.getName());
        } else {
            System.out.println("No tasks were selected.");
        }
		System.out.println("----------------------------------");
        return mv;
	}
	
}
