package com.dotwww.luckydraw.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Member {
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String employeeNumber;

    /**
     * 抽奖设置id
     */
    private Integer settingId;

    /**
     * 创建时间
     */
    private Date createTime;
}
