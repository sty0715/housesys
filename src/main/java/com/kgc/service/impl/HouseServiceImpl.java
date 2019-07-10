package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.entity.HouseExample;
import com.kgc.mapper.HouseMapper;
import com.kgc.service.HouseService;
import com.kgc.utils.PageUtil;
import com.kgc.utils.PassCondition;
import com.kgc.utils.SearchHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseListByPage(Integer id,PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> list = houseMapper.getHouseListByUid(id);

        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public House getHouse(String id) {
        return houseMapper.getHouse(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id, Integer isdel) {
        House house=new House();
        house.setId(id);
        house.setIsdel(isdel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByIsPass(Integer ispass, PassCondition passCondition) {
       PageHelper.startPage(passCondition.getPage(),passCondition.getRows());
        List<House> list = houseMapper.getHouseByIsPass(ispass);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int houseIsPass(String id, Integer ispass) {
        House house=new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBroswerHouse(SearchHouse searchHouse) {
        PageHelper.startPage(searchHouse.getPage(),searchHouse.getRows());
        List<House> list = houseMapper.getBroswerHouse(searchHouse);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
