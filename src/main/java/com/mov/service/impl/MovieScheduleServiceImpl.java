package com.mov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mov.entity.MovieSchedule;
import com.mov.service.MovieScheduleService;
import com.mov.mapper.MovieScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieScheduleServiceImpl extends ServiceImpl<MovieScheduleMapper, MovieSchedule>
    implements MovieScheduleService{

    @Autowired
    private MovieScheduleMapper movieScheduleMapper;

    @Override
    public List<MovieSchedule> getMSByMovId(Integer movieId) {
        LambdaQueryWrapper<MovieSchedule> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MovieSchedule::getId, movieId);
        return this.list(wrapper);
    }
}




