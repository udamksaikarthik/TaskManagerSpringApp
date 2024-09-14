package com.karthik.taskmanager.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	private String username;
	private String taskName;
	private Boolean checked;
	private Date taskDate;

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", checked=" + checked + ", taskDate=" + taskDate
				+ "]";
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
