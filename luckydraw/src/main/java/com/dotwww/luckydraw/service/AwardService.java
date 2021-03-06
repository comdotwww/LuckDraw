package com.dotwww.luckydraw.service;

import com.dotwww.luckydraw.mapper.AwardMapper;
import com.dotwww.luckydraw.mapper.SettingMapper;
import com.dotwww.luckydraw.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    @Autowired
    private SettingMapper settingMapper;

    public List<Award> queryBySettingId(Integer id) {

        return awardMapper.selectBySettingId(id);
    }

    public int add(Award award, Integer userId) {

        // 通过userId找settingId
        Integer settingId = settingMapper.queryIdByUserId(userId);

        // 设置award中settingId属性
        award.setSettingId(settingId);

        // 插入一条award
        return awardMapper.insertSelective(award);
    }

    public int update(Award award) {

        return awardMapper.updateByPrimaryKeySelective(award);
    }

    public int delete(Integer id) {

        return awardMapper.deleteByPrimaryKey(id);
    }
}
