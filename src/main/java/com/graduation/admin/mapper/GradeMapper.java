package com.graduation.admin.mapper;

import com.graduation.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {

    //查询所有班级
    List<Grade> selectGrade();

}
