package com.mov.service;

import com.mov.entity.MovieSchedule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface MovieScheduleService extends IService<MovieSchedule> {

    List<MovieSchedule> getMSByMovId(Integer movieId);
}
