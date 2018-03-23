package com.springcloud.example.demo.service.impl;

import com.springcloud.example.demo.mapper.MoGradeMapper;
import com.springcloud.example.demo.model.MoGrade;
import com.springcloud.example.demo.service.GradeService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private MoGradeMapper moGradeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public MoGrade getGradeById(int id) {

        //return moGradeMapper.selectByPrimaryKey(id);
        return moGradeMapper.getGradeById(id);
    }

    @Override
    public int addGrade(MoGrade moGrade) {
        return moGradeMapper.insert(moGrade);
    }

    @Override
    public List<MoGrade> getAllGrades(MoGrade moGrade) {

        List<MoGrade> moGradeList = new ArrayList<>();

        ValueOperations<String, List<MoGrade>> valueOperations = redisTemplate.opsForValue();

        moGradeList = valueOperations.get(moGrade.getGradename());
        if (moGradeList.size() <= 0) {
            System.out.println("进入缓存条件：" + moGrade.getGradename());
            moGradeList = moGradeMapper.getAllGrades(moGrade);
            valueOperations.set(moGrade.getGradename(), moGradeList);
        }

        System.out.println("模糊查询：" + moGrade.getGradename());
        return moGradeList;
    }
}
