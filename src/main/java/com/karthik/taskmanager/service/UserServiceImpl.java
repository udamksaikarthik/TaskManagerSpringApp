package com.karthik.taskmanager.service;

import com.karthik.taskmanager.entity.Users;

public interface UserServiceImpl{

	Boolean checkIfUserNameExits(String userName);

	void saveUser(Users user);

}
