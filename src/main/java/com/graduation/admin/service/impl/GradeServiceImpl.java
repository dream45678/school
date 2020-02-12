package com.graduation.admin.service.impl;

import com.graduation.admin.mapper.GradeMapper;
import com.graduation.admin.service.GradeService;
import com.graduation.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> selectGrade() {
        return gradeMapper.selectGrade();
    }
}
