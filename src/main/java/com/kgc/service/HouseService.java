package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.utils.PageUtil;
import com.kgc.utils.PassCondition;
import com.kgc.utils.SearchHouse;

public interface HouseService {
    //添加出租房
    int addHouse(House house);
    PageInfo<House> getHouseListByPage(Integer id, PageUtil pageUtil);
    //根据id查出租房
    House getHouse(String id);

    int updateHouse(House house);
    int delHouse(String id,Integer isdel);
    PageInfo<House> getHouseByIsPass(Integer ispass,PassCondition passCondition);
    int houseIsPass(String id,Integer ispass);
    //根据条件查询所有出租房
    PageInfo<House> getBroswerHouse(SearchHouse searchHouse);
}


