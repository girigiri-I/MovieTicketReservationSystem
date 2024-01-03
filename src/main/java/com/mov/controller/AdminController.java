package com.mov.controller;

import com.mov.entity.BookingInfo;
import com.mov.entity.MovieSchedule;
import com.mov.entity.QueryForm;
import com.mov.entity.User;
import com.mov.service.BookingInfoService;
import com.mov.service.MovieInfoService;
import com.mov.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private BookingInfoService bookingInfoService;

    @Autowired
    private MovieScheduleService movieScheduleService;

    @RequestMapping("/toOrder")
    public ModelAndView toOrder(ModelAndView mv) {
        List<BookingInfo> list = bookingInfoService.list();
        mv.addObject("list", list);
        mv.setViewName("order");
        return mv;
    }

    @RequestMapping(value = "/booking/query", method = RequestMethod.POST)
    public ModelAndView query(QueryForm form, ModelAndView mv) {
        List<BookingInfo> list = bookingInfoService.listByCond(form);
        mv.addObject("list", list);
        mv.setViewName("order");
        return mv;
    }

    @RequestMapping("/booking/delete")
    public ModelAndView delete(String bookingId, ModelAndView mv) {
        bookingInfoService.removeById(bookingId);
        mv.setViewName("redirect:/admin/toOrder");
        return mv;
    }

    @RequestMapping(value = "/booking/toUpdate", method = RequestMethod.POST)
    public ModelAndView toUpdate(String bookingId, ModelAndView mv) {
        BookingInfo bookingInfo = bookingInfoService.getById(bookingId);
        mv.addObject("bookingInfo", bookingInfo);
        mv.setViewName("update");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/booking/getScheduleIds")
    public List<String> getScheduleIds(String bookingId) {
        BookingInfo bookingInfo = bookingInfoService.getById(bookingId);
        List<MovieSchedule> list = movieScheduleService.list();
        List<String> ids = new ArrayList<>();
        for (MovieSchedule ms : list) {
            if(ms.getScheduleId().equals(bookingInfo.getScheduleId()))
                continue;
            ids.add(ms.getScheduleId());
        }
        return ids;
    }

    @RequestMapping(value = "/booking/update", method = RequestMethod.POST)
    public ModelAndView update(BookingInfo bookingInfo, ModelAndView mv, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            mv.addObject("msg", "请先登录后再购票");
            mv.setViewName("login");
            return mv;
        }
        // 判断是否已经购买过该场次的电影票
        List<BookingInfo> list = bookingInfoService.list();
        for (BookingInfo info : list) {
            if(info.getScheduleId().equals(bookingInfo.getScheduleId()) && info.getUserName().equals(user.getUserName())){
                mv.addObject("msg", "该用户已购买过该场次的电影票，无法修改");
                mv.setViewName("forward:/admin/toOrder");
                return mv;
            }
        }

        bookingInfoService.updateById(bookingInfo);
        mv.setViewName("redirect:/admin/toOrder");
        return mv;
    }
}
