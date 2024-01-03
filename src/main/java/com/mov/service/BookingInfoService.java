package com.mov.service;

import com.mov.entity.BookingInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mov.entity.QueryForm;

import java.util.List;

public interface BookingInfoService extends IService<BookingInfo> {

    List<BookingInfo> listByCond(QueryForm form);
}
