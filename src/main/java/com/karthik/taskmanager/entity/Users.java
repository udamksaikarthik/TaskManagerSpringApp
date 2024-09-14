package com.karthik.taskmanager.entity;



import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	private String username;
	private String email;
	private String password;
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	public Users() {
		
	}
	
	public Users(Integer user_id, String username, String email, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public Users( String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
