package com.mywebapp.todo.web_app_todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class WelcomeController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("error", null);
        model.put("username", getLoggedInUsername());
        logger.info("Open to welcome page.");
        return "todoList";
    }
    
    private String getLoggedInUsername(){
       Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
       return authentication.getName();
    }
}
