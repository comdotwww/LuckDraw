package com.dotwww.luckydraw.model;


import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Setting {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 每次抽奖人数
     */
    private Integer batchNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private User user;

    /**
     * 创建的奖项
     */
    private List<Award> awards;

    /**
     * 获奖者
     */
    private List<Member> members;
}
