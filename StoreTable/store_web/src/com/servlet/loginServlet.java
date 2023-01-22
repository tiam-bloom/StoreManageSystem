package com.servlet;

import com.bean.User;
import com.service.IUserService;
import com.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private IUserService service = new IUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        User user = new User();
        user.setUsername(username);
        user.setPsw(psw);
        User users = service.findUsername(user);
        System.out.println("账号密码为"+users);
        if (users != null){
            HttpSession session = req.getSession();
            session.setAttribute("Users",users);
            //cookie自动登录
            String autologin = req.getParameter("autologin");
            if (autologin != null){
                Cookie cookie = new Cookie("autologin",username+"-"+psw);
                cookie.setMaxAge(Integer.parseInt(autologin));
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
                System.out.println("存入的cookie为"+cookie);
            }
            //重定向
            resp.sendRedirect("/SearchServlet");
            return;
        }else {
            req.getSession().setAttribute("msg","用户名或密码错误！");
            resp.sendRedirect("/login.jsp");
        }
    }
}
