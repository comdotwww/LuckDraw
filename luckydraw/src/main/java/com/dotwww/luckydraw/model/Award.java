package com.dotwww.luckydraw.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Award {
    private Integer id;

    /**
     * 奖项名称
     */
    private String name;

    /**
     * 奖项人数
     */
    private Integer count;

    /**
     * 奖项
     */
    private String award;

    /**
     * 抽奖设置 id
     */
    private Integer settingId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 每个奖项的中奖人员id集合
     */
    private List<Integer> luckyMemberIds;
}
