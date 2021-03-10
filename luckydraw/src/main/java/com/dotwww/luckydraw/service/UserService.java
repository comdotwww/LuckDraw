package com.dotwww.luckydraw.service;

import com.dotwww.luckydraw.exception.ApplicationException;
import com.dotwww.luckydraw.mapper.SettingMapper;
import com.dotwww.luckydraw.mapper.UserMapper;
import com.dotwww.luckydraw.model.Setting;
import com.dotwww.luckydraw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingMapper settingMapper;

    private static final DateFormat df = new SimpleDateFormat("yyyyMMdd");

    /**
     * 用户头像路径 - 本地
     */
    @Value("${user.head.local-path}")
    private String headLocalPath;

    /**
     * 用户头像路径 - 外链
     */
    @Value("{user.head.remote-path}")
    private String headRemotePath;

    /**
     * @param headFile
     * @return
     */
    public String saveHead(MultipartFile headFile) {
        // 文件夹为当天
        // 文件路径的间隔符和操作系统相关
        // 可以使用File.separator
        // Java会根据操作系统自行设置
        Date nowDate = new Date();
        String dirURI = "/" + df.format(nowDate);   // 20210310
        File dirFile = new File(headLocalPath + dirURI);

        // 若路径不存在，创建文件夹
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        String suffix = headFile.getOriginalFilename().substring(headFile.getOriginalFilename().lastIndexOf("."));
        String headFileName = UUID.randomUUID().toString() + suffix;
        String fullURI = dirURI + "/" + headFileName;
        try {
            headFile.transferTo(new File(headLocalPath + fullURI));
        } catch (IOException e) {
            throw new ApplicationException("REG001", "用户头像上传出错！");
        }
        return headRemotePath + fullURI;

    }

    // 事务处理：多个更新必须有，部分查询 + 更新 有时候也需要
    // 内部实现：aop，方法前加入开启事务逻辑，方法执行后，抛异常rollback，没有异常commit
    @Transactional//可以手动指定隔离级别和传播特性
    public void register(User user) {
        // 数据库校验：校验用户名不能重复，省略，自行扩展
        // 插入user数据：插入后自增主键会按照 useGeneratedKeys = true 设置到对象属性
        int n = userMapper.insertSelective(user);

        // 插入setting数据：登录后，进入设置页面，添加奖项和抽奖人员
        // 需要setting_id
        Setting setting = new Setting();
        setting.setUserId(user.getId());
        // setting.setBatchNumber(user.getBatchNumber());
        setting.setBatchNumber(8);  //每次抽奖的数量：设置一个默认值
        settingMapper.insertSelective(setting);
    }

    public User queryByUsername(String username) {

        return userMapper.selectByUsername(username);
    }

}
