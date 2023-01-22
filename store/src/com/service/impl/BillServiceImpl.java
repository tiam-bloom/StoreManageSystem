package com.service.impl;

import com.dao.BillDao;
import com.po.Bill;
import com.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;

    @Override
    public List<Bill> findBill(String search) {
        return this.billDao.findBill(search);
    }

    @Override
    public List<Bill> findBillById(Integer id) {
        return this.billDao.findBillById(id);
    }

    @Override
    public List<Bill> findBillByCname(String cname) {
        return this.billDao.findBillByCname(cname);
    }

    @Override
    public List<Bill> findBillByName(String name) {
        return this.billDao.findBillByName(name);
    }

    @Override
    public List<Bill> findAllBill() {
        return this.billDao.findAllBill();
    }

    @Override
    public int deleteBill(Integer id) {
        return this.billDao.deleteBill(id);
    }

    @Override
    public int addBill(Bill bill) {
        return this.billDao.addBill(bill);
    }

    @Override
    public int updateBill(Bill bill) {
        return this.billDao.updateBill(bill);
    }
}
