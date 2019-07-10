package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.service.HouseService;
import com.kgc.utils.PageUtil;
import com.kgc.utils.PassCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("houseController1")
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("getNoPassHouse")
    public Map<String,Object> getNoPassHouse(PassCondition passCondition){
        PageInfo<House> page = houseService.getHouseByIsPass(0, passCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("total",page.getTotal());
        map.put("rows",page.getList());
        return map;
    }

    @RequestMapping("getPassedHouse")
    public Map<String,Object> getPassedHouse(PassCondition passCondition) {
        PageInfo<House> page = houseService.getHouseByIsPass(1, passCondition);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("rows", page.getList());
        return map;
    }

    @RequestMapping("HouseYes")
    public String HouseYes(String id){
        int i = houseService.houseIsPass(id, 1);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("HouseNo")
    public String HouseNo(String id){
        int i = houseService.houseIsPass(id, 0);
        return "{\"result\":"+i+"}";
    }

}
