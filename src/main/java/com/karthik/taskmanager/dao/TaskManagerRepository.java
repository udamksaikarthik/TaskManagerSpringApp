package com.karthik.taskmanager.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.karthik.taskmanager.entity.Task;

import jakarta.transaction.Transactional;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task, Integer>{
	
	@Modifying
    @Transactional
    @Query("UPDATE Task t SET t.checked = :taskCheckedStatus WHERE TRIM(t.taskName) = :taskName")
    void updateCheckedTask(String taskName, Boolean taskCheckedStatus);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM Task t WHERE TRIM(t.taskName) = :selectedTaskName")
    void deleteTaskByTaskName(String selectedTaskName);

	@Modifying
    @Transactional
    @Query("UPDATE Task t SET t.taskDate = :taskDate, t.checked = :taskChecked WHERE t.taskId = :taskId")
	void updateById(Integer taskId, Date taskDate, Boolean taskChecked);
	
}
