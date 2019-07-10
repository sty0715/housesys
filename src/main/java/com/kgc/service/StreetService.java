package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.utils.PageUtil;

import java.util.List;

public interface StreetService {
    PageInfo<Street> getStreetListByPage(PageUtil pageUtil);

    int addStreet(Street street);

    Street getSingleStreet(Integer id);

    int updateStreet(Street street);

    int delStreet(Integer id);

    int delStreets(List<Integer> list);

    PageInfo<Street> getStreetByDid(Integer id, PageUtil pageUtil);

    List<Street> getAllStreet(Integer id);
}
