package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.utils.PageUtil;
import com.kgc.utils.UserConditions;

import java.util.List;

public interface UsersService {
    PageInfo<Users> getUsersListByPage(UserConditions userConditions);

    int addUsers(Users users);

    Users getSingleUsers(Integer id);

    int updateUsers(Users users);

    int delUsers(Integer id);

    int delUserss(List<Integer> ids);

    int checkUname(String name);

    Users login(String name,String password);

}
