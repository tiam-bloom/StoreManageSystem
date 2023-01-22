package com.servlet;

import com.bean.User;
import com.service.impl.IUserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for (int i = 0;cookies!=null&&i<cookies.length;i++){
            if ("autologin".equals(cookies[i].getName())){
                autologin=cookies[i].getValue();
                break;
            }
        }
        if (autologin !=null){
            String[] parts = autologin.split("-");
            String username = parts[0];
            String psw = parts[1];

            User user = new User();
            user.setUsername(username);
            user.setPsw(psw);
            IUserServiceImpl service = new IUserServiceImpl();
            User users = service.findUsername(user);
            System.out.println("cookie查到的"+users);
            if (users!=null){
                request.getSession().setAttribute("Users",user);
            }
        }
        filterChain.doFilter(request,response);
    }
    @Override
    public void destroy() {

    }
}
