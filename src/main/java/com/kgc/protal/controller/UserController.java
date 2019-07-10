package com.kgc.protal.controller;

import com.kgc.entity.Users;
import com.kgc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("userController1")
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("checkUname")
    @ResponseBody
    public String checkUname(String name) {
        int i = usersService.checkUname(name);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("reg")
    public String reg(Users users){
        int i = usersService.addUsers(users);
        if(i>0){
            return "login";
        }else {
            return "regs";
        }
    }

    /*@RequestMapping("{page}")
    public String page(@PathVariable("page") String page){
        return page;
    }*/

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String name, String password, Model model, HttpSession session){

        Users user = usersService.login(name, password);
        if (user==null){
            model.addAttribute("info","用户名或者密码错误");
            return "login";
        }else {
            session.setAttribute("loginInfo",user);
            session.setMaxInactiveInterval(120);
            return "redirect:getHouses";
        }
    }
}