package com.servlet;

import com.bean.PurchaseList;
import com.service.PLService;
import com.service.impl.PLServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchPL")
public class searchServlet_P extends HttpServlet {
    private PLService service = new PLServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name==null){
            name="";
        }
        List<PurchaseList> Pls = service.findPL(name);
        req.getSession().setAttribute("PL",Pls);
        req.getRequestDispatcher("/purchaseList.jsp").forward(req,resp);
    }
}
