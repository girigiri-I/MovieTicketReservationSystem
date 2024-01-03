package com.mov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@TableName(value ="movie_info")
@Data
public class MovieInfo implements Serializable {
    /**
     * 电影编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 电影名称
     */
    private String movieName;

    /**
     * 电影简介
     */
    private String synopsis;

    /**
     * 上映时间
     */
    private Date showDate;

    /**
     * 电影时长
     */
    private Integer lengthTime;

    /**
     * 导演
     */
    private String director;

    /**
     * 演职人员
     */
    private String cast;

    /**
     * 语言与字幕
     */
    private String languageSubtitles;

    /**
     * 是否支持IMAX
     */
    private Integer isimax;

    /**
     * 海报
     */
    private String playbill;

}