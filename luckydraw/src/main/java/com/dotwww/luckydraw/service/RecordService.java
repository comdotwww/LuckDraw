package com.dotwww.luckydraw.service;

import com.dotwww.luckydraw.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 批量插入抽奖记录
     *
     * @param memberIds
     * @param awardId
     * @return
     */
    public int addRecord(List<Integer> memberIds, Integer awardId) {

        return recordMapper.batchInsert(memberIds, awardId);
    }

    /**
     * 根据奖项 id 删除
     * @param id
     * @return
     */
    public int deleteByAwardId(Integer id) {

        return recordMapper.deleteByAwardId(id);
    }

    /**
     * 根据用户 id 删除
     * @param id
     * @return
     */
    public int deleteByUserId(Integer id) {

        return recordMapper.deleteByUserId(id);
    }
}
