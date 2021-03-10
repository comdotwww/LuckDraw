package com.dotwww.luckydraw.mapper;

import com.dotwww.luckydraw.bean.BaseOperationMapper;
import com.dotwww.luckydraw.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper extends BaseOperationMapper<Member> {
    /**
     * 根据Setting ID查询
     */
    List<Member> selectBySettingId(Integer id);
}
