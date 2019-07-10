package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.entity.Users;
import com.kgc.entity.UsersExample;
import com.kgc.mapper.UsersMapper;
import com.kgc.service.UsersService;
import com.kgc.utils.MD5Utils;
import com.kgc.utils.UserConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public PageInfo<Users> getUsersListByPage(UserConditions userConditions) {
        PageHelper.startPage(userConditions.getPage(), userConditions.getRows());
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(1);
        if (userConditions.getName()!=null){
            criteria.andNameLike("%"+userConditions.getName()+"%");
        }
        if (userConditions.getTelephone()!=null){
            criteria.andTelephoneLike("%"+userConditions.getTelephone()+"%");
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public int addUsers(Users users) {
        users.setIsadmin(0);
        String s = MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(s);
        return usersMapper.insertSelective(users);
    }


    @Override
    public Users getSingleUsers(Integer id) {
        return null;
    }

    @Override
    public int updateUsers(Users users) {
        return 0;
    }

    @Override
    public int delUsers(Integer id) {
        return 0;
    }

    @Override
    public int delUserss(List<Integer> ids) {
        return 0;
    }

    @Override
    public int checkUname(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users.size();
    }

    @Override
    public Users login(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users.size()==0){
            return null;
        }else {
            return users.get(0);
        }
    }
}
