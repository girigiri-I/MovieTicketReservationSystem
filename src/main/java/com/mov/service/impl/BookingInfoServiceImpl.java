package com.mov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mov.entity.BookingInfo;
import com.mov.entity.QueryForm;
import com.mov.service.BookingInfoService;
import com.mov.mapper.BookingInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookingInfoServiceImpl extends ServiceImpl<BookingInfoMapper, BookingInfo>
    implements BookingInfoService{

    @Override
    public List<BookingInfo> listByCond(QueryForm form) {
        LambdaQueryWrapper<BookingInfo> wrapper = new LambdaQueryWrapper<>();

        // 若当前字段不为空，则进行eq查询
        wrapper.eq(!StringUtils.isEmpty(form.getUserName()), BookingInfo::getUserName, form.getUserName());
        wrapper.eq(!StringUtils.isEmpty(form.getScheduleId()), BookingInfo::getScheduleId, form.getScheduleId());
        wrapper.eq(!StringUtils.isEmpty(form.getBookingId()), BookingInfo::getBookingId, form.getBookingId());

        return this.list(wrapper);
    }
}




