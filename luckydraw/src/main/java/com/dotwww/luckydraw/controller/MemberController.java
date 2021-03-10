package com.dotwww.luckydraw.controller;

import com.dotwww.luckydraw.model.Member;
import com.dotwww.luckydraw.model.User;
import com.dotwww.luckydraw.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/add")
    public Object add(@RequestBody Member member, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int n = memberService.add(member, user.getId());
        return member.getId();
    }

    @PostMapping(path = "/update")
    public Object update(@RequestBody Member member) {
        int n = memberService.update(member);
        return null;
    }

    @GetMapping(path = "/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        int n = memberService.delete(id);
        return null;
    }
}
