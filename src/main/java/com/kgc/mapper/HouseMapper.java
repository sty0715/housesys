package com.kgc.mapper;

import com.kgc.entity.House;
import com.kgc.entity.HouseExample;
import com.kgc.utils.SearchHouse;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> getHouseListByUid(Integer id);

    House getHouse(String id);

    List<House> getHouseByIsPass(Integer ispass);
    //获取所有出租房
    List<House> getBroswerHouse(SearchHouse searchHouse);
}