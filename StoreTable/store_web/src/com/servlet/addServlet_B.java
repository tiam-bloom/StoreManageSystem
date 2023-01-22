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

@WebServlet("/addBill")
public class addServlet_B extends HttpServlet {
    private BillService service = new BillServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map = req.getParameterMap();
        Bill bill = BeanUT.mapToBean(map,Bill.class);
        System.out.println("新增的数据"+bill);
        int i = service.addBill(bill);
        resp.sendRedirect("/SearchServlet");
    }
}
