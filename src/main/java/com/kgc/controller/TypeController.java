package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.Type;
import com.kgc.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getTypeList")
    @ResponseBody
    public Map<String,Object> getTypeList(PageUtil pageUtil){
        PageInfo<Type> pageInfo = typeService.getTypeListByPage(pageUtil);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("addType")
    @ResponseBody
    public Map<String,Object> addType(Type type){
        int i=typeService.addType(type);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i);
        return map;
    }

    @RequestMapping("getSingleType")
    @ResponseBody
    public Type getSingleType(Integer id){
        Type type= typeService.getSingleType(id);
        return type;
    }

    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type type){
        int i=typeService.updateType(type);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("delType")
    @ResponseBody
    public String delType(Integer id){
        int i = typeService.delType(id);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("delTypes")
    @ResponseBody
    public String delTypes(String id){
        String[] split = id.split(",");
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }
        int i = typeService.delTypes(list);
        return "{\"result\":"+i+"}";
    }
}
