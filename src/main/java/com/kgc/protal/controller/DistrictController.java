package com.kgc.protal.controller;

import com.kgc.entity.District;
import com.kgc.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("districtController1")
@RequestMapping("/page/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistricts")
    @ResponseBody
    private List<District> getDistricts(){
        return districtService.getAllDistrict();
    }
}
