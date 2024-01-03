package com.mov;

import com.mov.mapper.UserMapper;
import com.mov.service.MovieScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieBookingSystemApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    MovieScheduleService movieScheduleService;

    @Test
    void contextLoads() {
//        userMapper.selectList(null).forEach(System.out::println);
        movieScheduleService.getMSByMovId(1).forEach(System.out::println);
    }

}
