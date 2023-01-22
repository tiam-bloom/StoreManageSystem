package com.servlet;

import com.bean.Bill;
import com.jdbc.BeanUT;
import com.service.BillService;
import com.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateBill")
public class updateServlet_B extends HttpServlet {
    private BillService service = new BillServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map = req.getParameterMap();
        Bill bill = BeanUT.mapToBean(map,Bill.class);
        System.out.println("需要修改的值"+bill);
        int i = service.updateBill(bill);
        resp.sendRedirect("/SearchServlet");
    }
}
