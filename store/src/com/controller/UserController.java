package com.controller;

import com.po.DataStatus;
import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//@CrossOrigin
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    public String login(String username, String psw, Model model, HttpSession session){
        User user = userService.findUser(username,psw);
        if(user != null){
            session.setAttribute("User",user);
            return "bill";
        }
        model.addAttribute("msg","账号或密码输入错误，请重新输入");
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:findUser";
    }
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public DataStatus addUser(User user) {
        int row = userService.addUser(user);
        DataStatus ds = new DataStatus();
        if (row > 0){
            ds.setStatusCode(100);
            ds.setStatusDescription("注册成功");
            return ds;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("账号已存在");
            return ds;
        }
    }
}
