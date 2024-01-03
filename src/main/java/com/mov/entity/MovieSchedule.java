package com.mov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@TableName(value ="movie_schedule")
@Data
public class MovieSchedule implements Serializable {
    /**
     * 演出编号
     */
    @TableId
    private String scheduleId;

    /**
     * 电影编号
     */
    private Integer id;

    /**
     * 地区
     */
    private String district;

    /**
     * 电影院
     */
    private String cinema;

    /**
     * 演出日期
     */
    private Date scheduleDate;

    /**
     * 演出时间
     */
    private Date scheduleTime;

    /**
     * 电影院厅
     */
    private String house;

    /**
     * 电影价格
     */
    private Integer price;

}