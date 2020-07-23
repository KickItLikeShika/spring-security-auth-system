package com.security.sec.controller;

import com.security.sec.model.User;
import com.security.sec.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegister() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.setViewName("register");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView submitRegister(User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User username = this.userService.findByUsername(user.getUsername());
        if (username != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            this.userService.saveUser(user);
            modelAndView.addObject("successMessage", "This user has been registerd successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }
}
