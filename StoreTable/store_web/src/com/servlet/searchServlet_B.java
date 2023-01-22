package com.servlet;

import com.bean.Bill;
import com.service.BillService;
import com.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class searchServlet_B extends HttpServlet {
    private BillService service = new BillServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("传入的搜索值为"+name);
        if(name == null){
            name="";
        }
        Bill bill = new Bill();
        bill.setName(name);
        List<Bill> bills = service.findBill(bill);
//        System.out.println(bills);
        req.getSession().setAttribute("bills",bills);
        req.getRequestDispatcher("/bill.jsp").forward(req,resp);
    }
}
