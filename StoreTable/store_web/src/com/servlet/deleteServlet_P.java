package com.servlet;

import com.bean.PurchaseList;
import com.service.PLService;
import com.service.impl.PLServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePL")
public class deleteServlet_P extends HttpServlet {
    private PLService service = new PLServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = service.deletePL(id);
        resp.sendRedirect("/SearchPL");
    }
}
