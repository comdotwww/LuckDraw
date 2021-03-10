package com.dotwww.luckydraw.mapper;

import com.dotwww.luckydraw.bean.BaseOperationMapper;
import com.dotwww.luckydraw.model.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseOperationMapper<Award> {
    /**
    * 根据Setting ID进行查询
    */
    List<Award> selectBySettingId(Integer id);
}
