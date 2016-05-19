package controller;


import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.LoginUserDetailsService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
@Controller
public class LoginController {
    final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginUserDetailsService userService;

    @RequestMapping("loginForm")
    String loginForm(){
        return "loginForm";
    }



    @RequestMapping("menu")
    String menuForm(){
        return "menu";
    }


    @RequestMapping("registForm")
    String registForm(){
        return "registForm";
    }


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    ModelAndView regist(Model model, HttpServletRequest request){
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
}
