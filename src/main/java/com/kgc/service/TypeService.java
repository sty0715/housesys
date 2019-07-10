package com.kgc.service;

import com.github.pagehelper.PageInfo;

import com.kgc.entity.Type;
import com.kgc.utils.PageUtil;

import java.util.List;

public interface TypeService {
    PageInfo<Type> getTypeListByPage(PageUtil pageUtil);

    int addType(Type type);

    Type getSingleType(Integer id);

    int updateType(Type type);

    int delType(Integer id);

    int delTypes(List<Integer> list);

    List<Type> getAllType();
}
