package com.mov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mov.entity.MovieInfo;
import com.mov.service.MovieInfoService;
import com.mov.mapper.MovieInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl extends ServiceImpl<MovieInfoMapper, MovieInfo>
    implements MovieInfoService{

}




