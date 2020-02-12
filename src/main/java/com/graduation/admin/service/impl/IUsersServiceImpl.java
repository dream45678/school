package com.graduation.admin.service.impl;

import com.graduation.admin.mapper.UsersMapper;
import com.graduation.admin.service.IUsersService;
import com.graduation.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUsersServiceImpl implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectUsersList(Users users,Integer currentPage,Integer PageSize) {
        return usersMapper.selectUsersList(users,currentPage,PageSize);
    }

    @Override
    public Integer updateUsers(Users users) {
        return usersMapper.updateUsers(users);
    }

    @Override
    public Integer deleteUsers(Users users) {
        return usersMapper.deleteUsers(users);
    }

    @Override
    public Integer insertUsers(Users users) {
        return usersMapper.insertUsers(users);
    }
}
