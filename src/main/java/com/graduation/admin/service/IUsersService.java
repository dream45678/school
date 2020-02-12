package com.graduation.admin.service;

import com.graduation.entity.Users;

import java.util.List;

public interface IUsersService {

    //按照条件查询用户 登录
    List<Users> selectUsersList(Users users,Integer currentPage,Integer PageSize);

    //修改用户
    Integer updateUsers(Users users);

    //删除用户
    Integer deleteUsers(Users users);

    //增加用户
    Integer insertUsers(Users users);
}
