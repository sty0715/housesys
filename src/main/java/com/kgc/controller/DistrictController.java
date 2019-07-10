package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.service.DistrictService;
import com.kgc.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @RequestMapping("getDistrictList")
    @ResponseBody
    public Map<String,Object> getDistrictList(PageUtil pageUtil){
        PageInfo<District> pageInfo = districtService.getDistrictListByPage(pageUtil);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public Map<String,Object> addDistrict(District district){
        int i=districtService.addDistrict(district);
         Map<String,Object> map=new HashMap<>();
         map.put("result",i);
         return map;
    }

    @RequestMapping("getSingleDistrict")
    @ResponseBody
    public District getSingleDistrict(Integer id){
        District district = districtService.getSingleDistrict(id);
        return district;
    }

    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        int i=districtService.updateDistrict(district);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("delDistrict")
    @ResponseBody
    public String delDistrict(Integer id){
        int i = districtService.delDistrict(id);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("delDistricts")
    @ResponseBody
    public String delDistricts(String id){
        String[] split = id.split(",");
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }
        int i = districtService.delDistricts(list);
        return "{\"result\":"+i+"}";
    }

}
