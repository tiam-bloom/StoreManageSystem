package com.dao;

import com.bean.Bill;
import com.bean.PurchaseList;

import java.util.List;

public interface PLDao {
    List<PurchaseList> findPL(String name);

    int addPL(PurchaseList pl);

    int updatePL(PurchaseList pl);

    int deletePL(String id);
}
