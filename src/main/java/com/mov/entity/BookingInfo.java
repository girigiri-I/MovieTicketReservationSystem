package com.mov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value ="booking_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfo implements Serializable {

    @TableId
    private String bookingId;

    private String userName;

    private String scheduleId;

    private Date bookingTime;

    @Override public String toString(){
        return "Booking Information : ["+getBookingId()+", "+getUserName()+", "+getScheduleId()+", " + getBookingTime() + "]";
    }

}