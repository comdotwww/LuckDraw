package com.dotwww.luckydraw.controller;

import com.dotwww.luckydraw.model.User;
import com.dotwww.luckydraw.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    // 抽奖：某个奖项下抽奖，一次抽多个人（插入多条抽奖记录）
    @PostMapping(path = "/add/{awardId}")
    public Object add(@RequestBody List<Integer> memberIds, @PathVariable Integer awardId) {
        int n = recordService.add(memberIds, awardId);
        return null;
    }

    @GetMapping(path = "/delete/member")
    public Object deleteByMemberId(Integer id) {
        int n = recordService.deleteByMemberId(id);
        return null;
    }

    @GetMapping(path = "/delete/award")
    public Object deleteByAwardId(Integer id) {
        int n = recordService.deleteByAwardId(id);
        return null;
    }

    @GetMapping(path = "/delete/setting")
    public Object deleteBySetting(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 获取 userid ---> 关联 setting_id
        // ----> 关联 member_id, award_id
        // ---> 删除关联 record
        int n = recordService.deleteByUserId(user.getId());
        return null;
    }
}
