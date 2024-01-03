package com.mov.controller;

import com.mov.entity.MovieInfo;
import com.mov.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MovieInfoService movieInfoService;

    @RequestMapping({"/index", "/"})
    public ModelAndView index(ModelAndView mv) {
        List<MovieInfo> list = movieInfoService.list();
        mv.addObject("list", list);
        mv.setViewName("index");
        return mv;
    }

}
