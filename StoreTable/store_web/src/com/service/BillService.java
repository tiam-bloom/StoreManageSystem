package com.service;

import com.bean.Bill;

import java.util.List;

public interface BillService {
    List<Bill> findBill(Bill bill);

    int deleteBill(String id);

    int addBill(Bill bill);

    int updateBill(Bill bill);
}
