package com.karthik.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.karthik.taskmanager.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String userName);

}
