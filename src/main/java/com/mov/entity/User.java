package com.mov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.*;
import java.io.Serializable;
import lombok.Data;

@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户名
     */
    @TableId
    @NotBlank
    @Size(min = 3, max = 50)
    private String userName;

    /**
     * 用户昵称
     */
    @NotBlank
    @Size(min = 3, max = 50)
    private String nickName;

    /**
     * 密码
     */
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    /**
     * 手机号
     */
    @NotBlank
    private String phone;

    /**
     * 电子邮件
     */
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @Override public String toString(){
        return "User : ["+getUserName()+", "+getNickName()+", "+getPassword()+", " + getPhone() + ", " + getEmail() + "]";
    }
}