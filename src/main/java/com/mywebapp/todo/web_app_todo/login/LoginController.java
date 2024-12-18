package com.mywebapp.todo.web_app_todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLoginJsp(ModelMap model) {
        model.put("error", null);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String getWelcomeJsp(@RequestParam String email, @RequestParam String password, ModelMap model) {
        if (authenticationService.authenticate(email, password)) {
            model.put("username", email);
            return "welcome";
        }
        model.put("error", "Invalid credentials! Please try again.");
        return "login";
    }
}
