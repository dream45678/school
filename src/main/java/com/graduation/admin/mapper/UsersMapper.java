package com.graduation.admin.mapper;

import com.graduation.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    //按照条件查询用户 登录
    List<Users> selectUsersList(Users users,Integer currentPage,Integer PageSize);

    //修改用户
    Integer updateUsers(Users users);

    //删除用户
    Integer deleteUsers(Users users);

    //增加用户
    Integer insertUsers(Users users);
}
