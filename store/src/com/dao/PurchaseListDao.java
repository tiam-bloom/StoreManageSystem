package com.dao;

import com.po.PurchaseList;

import java.util.List;

public interface PurchaseListDao {
    public PurchaseList findPLById(Integer id);
    public List<PurchaseList> findPLByName(String name);
    public List<PurchaseList> findAllPL();
    public int deletePL(Integer id);
    public int addPL(PurchaseList purchaseList);
    public int updatePL(PurchaseList purchaseList);
}
