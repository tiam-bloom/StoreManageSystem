package com.servlet;

import com.service.BillService;
import com.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBill")
public class deleteServlet_B extends HttpServlet {
    private BillService service = new BillServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("需要删除的id为"+id);
        int i = service.deleteBill(id);
        System.out.println("删除的行数为"+i);
        resp.sendRedirect("/SearchServlet");
    }
}
