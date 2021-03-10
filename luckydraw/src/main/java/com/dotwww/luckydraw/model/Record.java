package com.dotwww.luckydraw.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Record {
    private Integer id;

    /**
    * 中奖人的id
    */
    private Integer memberId;

    /**
     * 中奖奖项 id
     */
    private Integer awardId;

    /**
     * 创建时间
     */
    private Date creatDate;
}
