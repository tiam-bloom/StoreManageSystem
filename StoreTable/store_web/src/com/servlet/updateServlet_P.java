package com.servlet;

import com.bean.PurchaseList;
import com.jdbc.BeanUT;
import com.service.PLService;
import com.service.impl.PLServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updatePL")
public class updateServlet_P extends HttpServlet {
    private PLService service = new PLServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map = req.getParameterMap();
        PurchaseList pl = BeanUT.mapToBean(map,PurchaseList.class);
        int i = service.updatePL(pl);
        resp.sendRedirect("/SearchPL");
    }
}
