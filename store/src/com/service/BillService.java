package com.service;

import com.po.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {
    public List<Bill> findBill(@Param("search") String search);
    public List<Bill> findBillById(Integer id);
    public List<Bill> findBillByCname(String cname);
    public List<Bill> findBillByName(String name);
    public List<Bill> findAllBill();
    public int deleteBill(Integer id);
    public int addBill(Bill bill);
    public int updateBill(Bill bill);
}
