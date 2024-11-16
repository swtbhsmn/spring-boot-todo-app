package com.mywebapp.todo.web_app_todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService{
    public boolean authenticate(String email, String password){
        boolean isEmailValid = email.equalsIgnoreCase(email);
        boolean isPasswordValid = password.equals("admin");
        return isEmailValid && isPasswordValid;
    }
}