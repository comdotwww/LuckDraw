package com.dotwww.luckydraw.controller;

import com.dotwww.luckydraw.model.Award;
import com.dotwww.luckydraw.model.Member;
import com.dotwww.luckydraw.model.Setting;
import com.dotwww.luckydraw.model.User;
import com.dotwww.luckydraw.service.AwardService;
import com.dotwww.luckydraw.service.MemberService;
import com.dotwww.luckydraw.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    /**
     * 进入抽奖设置页面，初始化接口，返回页面所有需要的数据：
     * setting对象中的属性：batchNumber
     * setting对象目前没有的属性：
     * （1）user（用户信息）
     * （2）awards(奖项列表：根据setting_id查)
     * （3）members（抽奖人员列表：根据setting_id查）
     */
    @GetMapping(path = "/querry")
    public Object query(HttpSession session) {
        // 已经登录，所以可以直接使用HttpSession
        // 获取session中的user
        User user = (User) session.getAttribute("user");
        // 根据userId查setting信息
        Setting setting = settingService.queryByUserId(user.getId());
        // 把user设置到setting新增的属性user中
        setting.setUser(user);
        // 根据setting_id查award列表
        // 设置到setting新增的属性awards中
        List<Award> awards = awardService.queryBySettingId(setting.getId());
        setting.setAwards(awards);
        // 根据setting id查member列表
        // 设置到setting新增的属性members中
        List<Member> members = memberService.queryBySettingId(setting.getId());
        setting.setMembers(members);
        return setting;
    }

    @GetMapping(path = "/update")
    public Object update(Integer batchNumber, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int n = settingService.update(batchNumber, user.getId());
        return null;
    }
}
