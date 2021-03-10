package com.dotwww.luckydraw.service;

import com.dotwww.luckydraw.mapper.SettingMapper;
import com.dotwww.luckydraw.model.Setting;
import org.springframework.stereotype.Service;

@Service
public class SettingService {


    private SettingMapper settingMapper;

    /**
     * @param id
     * @return
     */
    public Setting queryByUserId(Integer id) {

        return settingMapper.selectByUserId(id);
    }

    /**
     * @param batchNumber
     * @param userId
     * @return
     */
    public int update(Integer batchNumber, Integer userId) {

        return settingMapper.update(batchNumber, userId);
    }
}
