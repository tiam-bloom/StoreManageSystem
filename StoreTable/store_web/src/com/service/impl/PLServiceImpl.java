package com.service.impl;

import com.bean.Bill;
import com.bean.PurchaseList;
import com.dao.PLDao;
import com.dao.impl.PLDaoImpl;
import com.service.PLService;

import java.util.List;

public class PLServiceImpl implements PLService {
    private PLDao dao = new PLDaoImpl();
    @Override
    public List<PurchaseList> findPL(String name) {
        return dao.findPL(name);
    }

    @Override
    public int addPL(PurchaseList pl) {
        return dao.addPL(pl);
    }

    @Override
    public int updatePL(PurchaseList pl) {
        return dao.updatePL(pl);
    }

    @Override
    public int deletePL(String id) {
        return dao.deletePL(id);
    }
}
