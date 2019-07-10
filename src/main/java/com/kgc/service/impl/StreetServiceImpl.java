package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.StreetService;
import com.kgc.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<Street> getStreetListByPage(PageUtil pageUtil) {
        return null;
    }

    @Override
    public int addStreet(Street street) {
        return 0;
    }

    @Override
    public Street getSingleStreet(Integer id) {
        return null;
    }

    @Override
    public int updateStreet(Street street) {
        return 0;
    }

    @Override
    public int delStreet(Integer id) {
        return 0;
    }

    @Override
    public int delStreets(List<Integer> list) {
        return 0;
    }

    @Override
    public PageInfo<Street> getStreetByDid(Integer id, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> list=streetMapper.selectByExample(streetExample);
        return new PageInfo<Street>(list);
    }

    @Override
    public List<Street> getAllStreet(Integer id) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return streetMapper.selectByExample(streetExample);
    }
}
