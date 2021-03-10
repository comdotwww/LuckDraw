package com.dotwww.luckydraw.mapper;

import com.dotwww.luckydraw.bean.BaseOperationMapper;
import com.dotwww.luckydraw.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper extends BaseOperationMapper {
    /**
     * 根据User ID查询
     */
    Setting selectByUserId(Integer id);

    /**
     * 根据User ID批量修改
     */
    int update(@Param("batchNumber") Integer batchNumber, @Param("userId") Integer userId);

    /**
     * 根据User ID
     */
    Integer queryIdByUserId(Integer userId);
}
