package com.dotwww.luckydraw.controller;

import com.dotwww.luckydraw.model.Award;
import com.dotwww.luckydraw.model.User;
import com.dotwww.luckydraw.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @PostMapping(path = "/add")
    public Object add(@RequestBody Award award, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int n = awardService.add(award, user.getId());
        return award.getId();   //插入后，返回给前端自增主键id
    }

    @PostMapping(path = "/update")
    public Object update(@RequestBody Award award){
        int n = awardService.update(award);
        return null;
    }

    @GetMapping(path = "/delete/{id}")
    public Object delete(@PathVariable Integer id){
        int n = awardService.delete(id);
        return null;
    }

}
