package com.service.impl;

import com.bean.Bill;
import com.dao.BillDao;
import com.dao.impl.BillDaoImpl;
import com.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {
    private BillDao dao = new BillDaoImpl();
    @Override
    public List<Bill> findBill(Bill bill) {
        return dao.findBill(bill);
    }

    @Override
    public int deleteBill(String id) {
        return dao.deleteBill(id);
    }

    @Override
    public int addBill(Bill bill) {
        return dao.addBill(bill);
    }

    @Override
    public int updateBill(Bill bill) {
        return dao.updateBill(bill);
    }
}
