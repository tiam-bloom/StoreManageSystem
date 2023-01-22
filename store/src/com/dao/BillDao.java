package com.dao;

import com.po.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillDao {
    //@Param("search")表示为参数search命名，命名后，在映射文件SQL中才可使用#{search}获取到search的值
    public List<Bill> findBill(@Param("search") String search);
    public List<Bill> findBillById(Integer id);
    public List<Bill> findBillByCname(String cname);
    public List<Bill> findBillByName(String name);
    public List<Bill> findAllBill();
    public int deleteBill(Integer id);
    public int addBill(Bill bill);
    public int updateBill(Bill bill);
}
