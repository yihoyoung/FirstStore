package org.store.controller;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.store.domain.User;
import org.store.service.UserService;
import org.webjars.RequireJS;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
@Controller
public class LoginController {
    final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/webjarsjs", produces = "application/javascript")
    public String webjarjs() {
        return RequireJS.getSetupJavaScript("/webjars/");
    }

    @RequestMapping("loginForm")
    public String loginForm(){
        return "loginForm";
    }



    @RequestMapping("menu")
    public String menuForm(){
        return "menu";
    }


    @RequestMapping("registForm")
    public String registForm(){
        return "registForm";
    }


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(Model model, HttpServletRequest request){
        logger.info("start regist!!!1");
        ModelAndView view = new ModelAndView();
        String userName = StringUtils.isEmpty(request.getParameter("username")) ? "" : request.getParameter("username");
        String password = StringUtils.isEmpty(request.getParameter("password")) ? "" : request.getParameter("password");
        String email = StringUtils.isEmpty(request.getParameter("email")) ? "" : request.getParameter("email");
        logger.info("regist username : "  + userName + ", Password : " + password);
        User user = userService.save(email, password, userName);
        if(StringUtils.isEmpty(user.getUsername())){
            view.setViewName("registForm");
            view.addObject("isRegisted", false);
        }else{
            view.setViewName("registed");
            view.addObject("username", user.getUsername());
        }
        return view;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Model model, HttpServletRequest request){
        logger.info("start regist!!!1");
        ModelAndView view = new ModelAndView();
        String password = StringUtils.isEmpty(request.getParameter("password")) ? "" : request.getParameter("password");
        String email = StringUtils.isEmpty(request.getParameter("email")) ? "" : request.getParameter("email");
        logger.info("login email : "  + email + ", Password : " + password);
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
        	view.setViewName("loginForm");
            view.addObject("error", "Email or Password not can be empty.");
        }
        User user = userService.find(email);
        if(ObjectUtils.isEmpty(user)){
        	view.setViewName("loginForm");
            view.addObject("error", "Email or Password is incorrect.");
        }
        else if(StringUtils.equals(password, user.getPassword())){
        	view.setViewName("menu");
            view.addObject("username", user.getUsername());
        }else{
        	view.setViewName("loginForm");
            view.addObject("error", "Email or Password is incorrect.");
        }
        return view;
    }
    
}
