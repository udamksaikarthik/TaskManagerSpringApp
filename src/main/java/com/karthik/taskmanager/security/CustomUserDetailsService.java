package com.karthik.taskmanager.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karthik.taskmanager.dao.UserRepository;
import com.karthik.taskmanager.entity.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user= userRepository.findByUsername(username);
		if(user != null) {
			var springUser = User.withUsername(user.getUsername())
					.password(user.getPassword())
					.build();
			return springUser;
		}
		
		return null;
	}
}

