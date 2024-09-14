package com.karthik.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.karthik.taskmanager.dao.UserDao;
import com.karthik.taskmanager.entity.Users;

@Service
public class UserService implements UserServiceImpl{
	
	@Autowired
	private UserDao userDao;

	@Override
	public Boolean checkIfUserNameExits(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkIfUserNameExits(userName);
	}

	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        // Password to be hashed
        String rawPassword = user.getPassword();
//
//        // Hash the password
        String encodedPassword = encoder.encode(rawPassword);
//
//        // Print the hashed password
        System.out.println("Encoded password: " + encodedPassword);
//        
        user.setPassword(encodedPassword);
        
		userDao.saveUser(user);
	}

}
