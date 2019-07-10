package com.kgc.protal.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.House;
import com.kgc.entity.Type;
import com.kgc.entity.Users;
import com.kgc.service.DistrictService;
import com.kgc.service.HouseService;
import com.kgc.service.TypeService;
import com.kgc.utils.PageUtil;
import com.kgc.utils.PassCondition;
import com.kgc.utils.SearchHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private TypeService typeService;
    @RequestMapping("goFabu")
    public String goFabu(Model model){
        List<Type> types=typeService.getAllType();
        List<District> districts=districtService.getAllDistrict();
        model.addAttribute("types",types);
        model.addAttribute("districts",districts);
        return "fabu";
    }

    @RequestMapping("addHouse")
    public String addHouse(House house, @RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws IOException {
        //图片上传
        String originalFilename = pfile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName=System.currentTimeMillis()+substring;
        String path="f:/images/"+fileName;
        File file=new File(path);
        pfile.transferTo(file);
        //添加house
        house.setId(System.currentTimeMillis()+"");
        house.setPath(fileName);
        Users user = (Users)session.getAttribute("loginInfo");
        house.setUserId(user.getId());
        house.setIsdel(0);
        house.setIspass(0);
        int i=houseService.addHouse(house);
        if (i>0){
            return "guanli";
        }else{
            file.delete();
        }
        return "redirect:goFabu";
    }

    @RequestMapping("getHouses")
    public String getHouses(PassCondition passCondition, HttpSession session, Model model){
        Users users=(Users)session.getAttribute("loginInfo");
        Integer id = users.getId();
        PageInfo<House> pageInfo = houseService.getHouseListByPage(id, passCondition);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }

    @RequestMapping("goUpdate")
    public String goUpdate(Model model,String id){
        House house = houseService.getHouse(id);
        model.addAttribute("house",house);
        return "upfabu";
    }
    //更新出租房
    @RequestMapping("updateHouse")
    public String updateHouse(House house,@RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile,String oldPath) throws IOException {
        String originalFilename = pfile.getOriginalFilename();
        if (originalFilename.equals("")){

        }else {
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName=System.currentTimeMillis()+substring;
            String path="f:/images/"+fileName;
            File file=new File(path);
            pfile.transferTo(file);
            new File("f://images/"+oldPath).delete();
            house.setPath(fileName);
        }
        houseService.updateHouse(house);
        return "redirect:getHouses";
    }
   //逻辑删除出租房
    @RequestMapping("delHouse")
    public String delHouse(String id){
        houseService.delHouse(id,1);
        return "redirect:getHouses";
    }

    //根据条件查询所有出租房
    @RequestMapping("getBroswerHouse")
    public String getBroswerHouse(SearchHouse searchHouse,Model model){
        PageInfo<House> pageInfo = houseService.getBroswerHouse(searchHouse);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("searchHouse",searchHouse);
        return "list";
    }

}
