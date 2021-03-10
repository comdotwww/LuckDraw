package com.dotwww.luckydraw.mapper;

import com.dotwww.luckydraw.bean.BaseOperationMapper;
import com.dotwww.luckydraw.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseOperationMapper<Record> {
    /**
    * 批量插入
    */
    int batchInsert(@Param("memberId") List<Integer> memberId, @Param("awardId") Integer awardId);

    /**
    * 根据Member ID删除
    */
    int deleteByMemberId(Integer id);

    /**
    * 根据Award ID删除
    */
    int deleteByAwardId(Integer id);

    /**
    * 根据User ID删除
    */
    int deleteByUserId(Integer id);
}
