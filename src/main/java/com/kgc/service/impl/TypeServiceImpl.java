package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.kgc.entity.Type;
import com.kgc.entity.TypeExample;
import com.kgc.mapper.TypeMapper;
import com.kgc.service.TypeService;
import com.kgc.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getTypeListByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<Type> types = typeMapper.selectByExample(null);
        PageInfo<Type> pageInfo=new PageInfo<>(types);
        return pageInfo;
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type getSingleType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int delType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int delTypes(List<Integer> ids) {
        return typeMapper.delTypes(ids);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
