package com.security.sec.controller;

import com.security.sec.model.User;
import com.security.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        // Get the current logged in user
        String uname = authentication.getName();
        User user = userService.findByUsername(uname);
        modelAndView.addObject(user);
        // System.out.println(user.getFirstname());
        return modelAndView;
    }
}
