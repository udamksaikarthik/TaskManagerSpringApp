package com.karthik.taskmanager.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // Add error message to session
        request.getSession().setAttribute("loginError", "Invalid username or password. Please try again.");
        
        // Redirect to login page with error
        response.sendRedirect(request.getContextPath() + "/login?error");
    }
}
