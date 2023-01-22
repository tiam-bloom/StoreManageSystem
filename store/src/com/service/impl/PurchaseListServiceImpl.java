package com.service.impl;

import com.dao.PurchaseListDao;
import com.po.PurchaseList;
import com.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PurchaseListServiceImpl implements PurchaseListService {
    @Autowired
    private PurchaseListDao purchaseListDao;
    public PurchaseList findPLById(Integer id){
        return  this.purchaseListDao.findPLById(id);
    }

    @Override
    public List<PurchaseList> findPLByName(String name) {
        return this.purchaseListDao.findPLByName(name);
    }

    @Override
    public List<PurchaseList> findAllPL() {
        return this.purchaseListDao.findAllPL();
    }

    @Override
    public int deletePL(Integer id) {
        return this.purchaseListDao.deletePL(id);
    }

    @Override
    public int addPL(PurchaseList purchaseList) {
        return this.purchaseListDao.addPL(purchaseList);
    }

    @Override
    public int updatePL(PurchaseList purchaseList) {
        return this.purchaseListDao.updatePL(purchaseList);
    }

}
