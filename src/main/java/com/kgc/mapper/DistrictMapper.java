package com.kgc.mapper;

import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    int delDistricts(List<Integer> ids);
}