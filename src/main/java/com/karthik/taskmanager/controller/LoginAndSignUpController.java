package com.karthik.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karthik.taskmanager.entity.Users;
import com.karthik.taskmanager.service.UserServiceImpl;


@Controller
public class LoginAndSignUpController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/login")
	public String showLoginPage() {
		System.out.println("Inside showLoginPage");
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		return "login";
	}
	
	@GetMapping("/signup")
	public ModelAndView showSignUpPage() {
		System.out.println("Inside showSignUpPage");
		System.out.println("----------------------------------");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp.html");
		System.out.println("----------------------------------");
		return mv;
	}
	
	@PostMapping("/signup")
    public ModelAndView signUpUser(
    		@RequestParam(value = "username") String userName,
    		@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "confirmPassword") String confirmPassword
    		) {
		System.out.println("Inside signUpUser Method Post method of signup");
		System.out.println("----------------------------------");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp.html");
		
        
        
        if (userName==null || userName.isBlank() ||userName.isEmpty()) {
    		System.out.println("userName is Empty");
            mv.addObject("userNameError", "UserName is Mandatory!");
    		System.out.println("----------------------------------");
            return mv;
        }
        

        Boolean flag = userServiceImpl.checkIfUserNameExits(userName);
        
        if(flag) {
        	System.out.println("userName Exists");
            mv.addObject("userNameError", "Username already exists!");
    		System.out.println("----------------------------------");
            return mv;
        }
        
        if (email==null || email.isBlank() ||email.isEmpty()) {
    		System.out.println("Email is Empty");
            mv.addObject("emailError", "Email is Mandatory!");
    		System.out.println("----------------------------------");
            return mv;
        }
        
        if (confirmPassword==null || confirmPassword.isBlank() ||confirmPassword.isEmpty()) {
    		System.out.println("confirmPassword is Empty");
            mv.addObject("passwordError", "Confirm Password is Mandatory!");
    		System.out.println("----------------------------------");
            return mv;
        }
        
        if (password.length()<8) {
    		System.out.println("password is less than 8 characters");
            mv.addObject("passwordError", "password needs to be atleast 8 characters!");
    		System.out.println("----------------------------------");
            return mv;
        }
        
        if (!password.equals(confirmPassword)) {
    		System.out.println("Passwords do not match");
            mv.addObject("passwordError", "Passwords do not match");
    		System.out.println("----------------------------------");
            return mv;
        }

        Users user = new Users(userName, email, password);
        userServiceImpl.saveUser(user);
        mv.setViewName("redirect:/");
		System.out.println("----------------------------------");
        return mv;
    }
	
	@PostMapping("/login")
	public ModelAndView LoginUser() {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("LoginUser Method");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
