package com.hlk.ems.controller;

import com.hlk.ems.entity.User;
import com.hlk.ems.service.UserService;
import com.hlk.ems.util.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> Login(User user) {
        Map<String, String> map = new HashMap();
        userService.login(user);
        return map;
    }

    @RequestMapping("/register")
    public Map<String, String> Register(User user, String code, HttpSession session) {
        Map<String, String> map = new HashMap<String, String>();
        String realcode = (String) session.getAttribute("code");
        if (realcode.equals(code)) {
            userService.register(user);
            map.put("msg", "注册成功");
        } else {
            map.put("msg", "验证码错误");
        }
        return map;
    }

    @RequestMapping("/showAll")
    public String showAll() {
        List<User> users = userService.selectAll();
        httpServletRequest.setAttribute("list", users);
        return "emplist";
    }

    @RequestMapping("/add")
    public void add(User user) {
        userService.add(user);
    }

    @RequestMapping("selectById")
    public String selectById(User user) {
        User user1 = userService.selectById(user);
        httpServletRequest.setAttribute("user1", user1);
        return "updateEmp";
    }

    @RequestMapping("update")
    public String update(User user) {
        userService.update(user);
        return "emplist";
    }

    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) {
        String code = ValidateImageCodeUtils.getSecurityCode();
        session.setAttribute("code", code);
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/code1")
    @ResponseBody
    public Map<String, String> Code(String code2, HttpSession session) {
        Map<String, String> map = new HashMap<String, String>();
        String realcode = (String) session.getAttribute("code");
        System.out.println(realcode);
        System.out.println(code2);
        if (realcode.equals(code2)) {
            map.put("msg", "验证码正确");
        } else {
            map.put("msg", "验证码错误");
        }

        return map;
    }
}
