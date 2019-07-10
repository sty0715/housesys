package com.kgc.protal.controller;

import com.kgc.entity.Street;
import com.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("streetController1")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street> getStreetByDid(Integer id){
        List<Street> streets=streetService.getAllStreet(id);
        return streets;
    }
}
