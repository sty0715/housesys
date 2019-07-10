package com.kgc.protal.controller;

import com.kgc.entity.Type;
import com.kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("typeController1")
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getTypes")
    @ResponseBody
    public List<Type> getTypes(){
        return typeService.getAllType();
    }
}
