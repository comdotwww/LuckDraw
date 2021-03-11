package com.dotwww.luckydraw.controller;

import com.dotwww.luckydraw.exception.ApplicationException;
import com.dotwww.luckydraw.model.User;
import com.dotwww.luckydraw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @param user
     * @param headFile
     * @return
     */
    @PostMapping(path = "/register")
    public Object register(@Validated User user, MultipartFile headFile) {
        // 校验请求数据
        // @Validated


        // 保存上传的用户头像到服务端本地
        if (headFile != null) {
            String head = userService.saveHead(headFile);
            // 上传的路径映射为http服务路径
            // 用户头像的http路径设置到user.head
            // 把user插入数据库
            user.setHead(head);
        }
        userService.register(user);
        return null;
    }

    /**
     * @param user
     * @param req
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestBody @Validated User user, HttpServletRequest req) {//username, password
        //根据账号查用户
        User exist = userService.queryByUsername(user.getUsername());
        //用户不存在
        if (exist == null) throw new ApplicationException("LOG001", "用户不存在");
        //用户存在，校验密码
        if (!user.getPassword().equals(exist.getPassword()))
            throw new ApplicationException("LOG002", "账号或密码错误");
        //校验通过，保存数据库的用户(包含所有字段)到session
        HttpSession session = req.getSession();//先创建session
        session.setAttribute("user", exist);
        return null;//登录成功
    }

    /**
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }
}
