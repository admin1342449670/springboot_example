package com.springcloud.example.demo.service;

import com.springcloud.example.demo.model.MoGrade;

import java.util.List;

public interface GradeService {

    MoGrade getGradeById(int id);

    int addGrade(MoGrade moGrade);

    List<MoGrade> getAllGrades(MoGrade moGrade);
}
