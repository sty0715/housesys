package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.Users;
import com.kgc.service.UsersService;
import com.kgc.utils.PageUtil;
import com.kgc.utils.UserConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UserController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("getUsersList")
    @ResponseBody
    public Map<String,Object> getUsersList(UserConditions userConditions){
        PageInfo<Users> page = usersService.getUsersListByPage(userConditions);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",page.getTotal());
        map.put("rows",page.getList());
        return map;
    }

}
