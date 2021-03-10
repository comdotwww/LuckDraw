package com.dotwww.luckydraw.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class User implements Serializable {

    private Integer id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像url
     */
    private String head;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 每次抽奖的数量
     */
    private Integer BatchNumber;
}
