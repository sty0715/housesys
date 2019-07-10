package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.mapper.DistrictMapper;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.DistrictService;
import com.kgc.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getDistrictListByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);
        PageInfo<District> pageInfo = new PageInfo<District>(districts);

        return pageInfo;
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District getSingleDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    @Transactional
    public int delDistrict(Integer id) {
        streetMapper.delStreetByDid(id);
        districtMapper.deleteByPrimaryKey(id);
       return 1;
    }

    @Override
    public int delDistricts(List<Integer> ids) {
        streetMapper.delStreets(ids);
        districtMapper.delDistricts(ids);
        return 1;
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
