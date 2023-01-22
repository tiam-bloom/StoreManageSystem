package com.dao.impl;

import com.bean.Bill;
import com.dao.BillDao;
import com.jdbc.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class BillDaoImpl implements BillDao {
    //查询
    @Override
    public List<Bill> findBill(Bill bill) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            String sql = "select * from s_bill where cname like concat('%',?,'%') or name like concat('%',?,'%')";
            return qr.query(sql,new BeanListHandler<Bill>(Bill.class),bill.getName(),bill.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除
    @Override
    public int deleteBill(String id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try{
            return qr.update("delete from s_bill where id =?",id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    //新增
    @Override
    public int addBill(Bill bill) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        Object [] args ={bill.getId(),bill.getName(),bill.getCname(),bill.getAmountb(),bill.getTime(),bill.getPrice()};
        try {
            return qr.update("insert into s_bill values (?,?,?,?,?,?)",args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //修改
    @Override
    public int updateBill(Bill bill) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        Object [] args ={bill.getName(),bill.getCname(),bill.getAmountb(),bill.getTime(),bill.getPrice(),bill.getId()};
        try {
            return qr.update("update s_bill set name =?,cname =?,amountb =?,time =?,price =? where id=?",args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
