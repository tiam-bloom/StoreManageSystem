package com.dao.impl;

import com.bean.Bill;
import com.bean.PurchaseList;
import com.dao.PLDao;
import com.jdbc.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PLDaoImpl implements PLDao {
    //查询
    @Override
    public List<PurchaseList> findPL(String name) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        String sql = "select * from s_purchaseList where name like concat('%',?,'%')";
        try {
            return qr.query(sql,new BeanListHandler<PurchaseList>(PurchaseList.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //新增
    @Override
    public int addPL(PurchaseList pl) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        Object [] args = {pl.getName(),pl.getAmount(),pl.getPriceIn(),pl.getAmountPrice()};
        try {
            return qr.update("insert into s_purchaseList value(null,?,?,?,?)",args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //更新
    @Override
    public int updatePL(PurchaseList pl) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        Object [] args = {pl.getName(),pl.getAmount(),pl.getPriceIn(),pl.getAmountPrice(),pl.getId()};
        try {
            return qr.update("update s_purchaseList set name =?,amount =?,priceIn=?,amountPrice=? where id=?",args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deletePL(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            return qr.update("delete from s_purchaseList where id =?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //删除

}
