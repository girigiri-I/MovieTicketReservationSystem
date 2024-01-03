package com.mov.controller;

import com.mov.entity.*;
import com.mov.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingInfoService bookingInfoService;

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private MovieScheduleService movieScheduleService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpSession session) {
        User user = userService.login(username);
        ModelAndView mv = new ModelAndView();
        if (user != null && user.getPassword().equals(password)) {
            // 登录成功 将用户信息保存到session中
            session.setAttribute("user", user);
            mv.addObject("user", user);
            mv.setViewName("redirect:/index");
        } else {
            mv.addObject("msg", "用户名或密码错误");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView();
        boolean save = false;
        try {
            save = userService.save(user);
            if (save) {
                mv.addObject("msg", "注册成功");
                mv.setViewName("login");
            } else {
                mv.addObject("msg", "注册失败");
                mv.setViewName("register");
            }
        } catch (DuplicateKeyException e) {
            mv.addObject("msg", "用户名已存在");
            mv.setViewName("register");
        }
        System.out.println(user);
        return mv;

    }

    @RequestMapping("/toBooking")
    public ModelAndView toBuyTicket(Integer movieId) {
        List<MovieSchedule> msList = movieScheduleService.getMSByMovId(movieId);
        MovieInfo movieInfo = movieInfoService.getById(movieId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", msList);
        mv.addObject("movie", movieInfo);
        mv.setViewName("booking");
        return mv;
    }

    @RequestMapping("/booking")
    public ModelAndView buyTicket(String showId, int movieId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ModelAndView mv = new ModelAndView();
        if (user == null) {
            mv.addObject("msg", "请先登录后再购票");
            mv.setViewName("login");
            return mv;
        }

        // 判断是否已经购买过该场次的电影票
        List<BookingInfo> list = bookingInfoService.list();
        for (BookingInfo bookingInfo : list) {
            if(bookingInfo.getScheduleId().equals(showId) && bookingInfo.getUserName().equals(user.getUserName())){
                mv.addObject("msg", "您已购买过该场次的电影票，无法重复购买");
                mv.setViewName("forward:/user/toBooking?movieId=" + movieId);
                return mv;
            }
        }

        // 生成订单号 bookingId
        String bookingId = String.valueOf(System.currentTimeMillis());
        // 保存订单信息
        boolean save = bookingInfoService.save(new BookingInfo(bookingId, user.getUserName(), showId, new Date()));
        if(save){
            mv.addObject("msg", "购票成功");
            // 向用户发送邮件
            mailService.sendMail(new ToEmail(user.getEmail(), "购票成功", "您已成功购买电影票，订单号为：" + bookingId));
        }else{
            mv.addObject("msg", "购票失败");
        }
        mv.setViewName("forward:/user/toBooking?movieId=" + movieId);
        System.out.println(mv);
        return mv;
    }


}
