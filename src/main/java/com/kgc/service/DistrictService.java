package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.utils.PageUtil;

import java.util.List;

public interface DistrictService {
    PageInfo<District> getDistrictListByPage(PageUtil pageUtil);

    int addDistrict(District district);

    District getSingleDistrict(Integer id);

    int updateDistrict(District district);

    int delDistrict(Integer id);

    int delDistricts(List<Integer> ids);

    List<District> getAllDistrict();
}
