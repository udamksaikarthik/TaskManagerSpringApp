package com.karthik.taskmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.taskmanager.entity.Users;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;

	public Boolean checkIfUserNameExits(String userName) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		userName = userName.trim();
		Users user = userRepository.findByUsername(userName);
		if(user!=null) {
			System.out.println("Username already exists");
			flag = true;
		}else {
			System.out.println("New Username");
			flag = false;
		}
		return flag;
	}

	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	
}
