package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("Users");

        Cookie cookie = new Cookie("autologin","msg");
        cookie.setPath(req.getContextPath());
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        System.out.println("注销的cookie为"+cookie);
        resp.sendRedirect("login.jsp");
    }
}
