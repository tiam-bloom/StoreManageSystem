package com.controller;

import com.po.Bill;
import com.po.DataStatus;
import com.service.BillService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class BillController {
    @Autowired
    private BillService billService;
    @ResponseBody
    @RequestMapping("/findBill")
    public JSONObject findBill(String search) {
        List<Bill> bill = billService.findBill(search);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (bill != null && bill.size()>0){
            ds.setStatusCode(100);
            ds.setStatusDescription("查询成功");
            jo.put("DataStatus",ds);
            jo.put("Data",bill);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询不到相关信息");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findBillById")
    public JSONObject findBillById(Integer id) {
        List<Bill> bill = billService.findBillById(id);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (bill != null && bill.size()>0){
            ds.setStatusCode(100);
            ds.setStatusDescription("查询id成功");
            jo.put("DataStatus",ds);
            jo.put("Data",bill);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查无此id");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findBillByCname")
    public JSONObject findBillByCname(String cname) {
        List<Bill> bill = billService.findBillByCname(cname);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (bill != null && bill.size()>0){
            ds.setStatusCode(100);
            ds.setStatusDescription("模糊查询客户名成功");
            jo.put("DataStatus",ds);
            jo.put("Data",bill);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询不到相关信息");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findBillByName")
    public JSONObject findBillByName(String name) {
        List<Bill> bill = billService.findBillByName(name);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (bill != null && bill.size()>0){
            ds.setStatusCode(100);
            ds.setStatusDescription("模糊查询name成功");
            jo.put("DataStatus",ds);
            jo.put("Data",bill);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询不到相关信息");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findAllBill")
    public JSONObject findAllBill() {
        List<Bill> bill = billService.findAllBill();
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (bill != null){
            ds.setStatusCode(100);
            ds.setStatusDescription("查询全部成功");
            jo.put("DataStatus",ds);
            jo.put("Data",bill);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询全部失败");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/deleteBill")
    public DataStatus deleteBill(Integer id){
        int row = this.billService.deleteBill(id);
        DataStatus ds = new DataStatus();
        if (row > 0){
            ds.setStatusCode(100);
            ds.setStatusDescription("删除成功");
            return ds;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("删除失败");
            return ds;
        }
    }
    @ResponseBody
    @RequestMapping("/addBill")
    public DataStatus addBill(@RequestBody Bill bill){
        int row = this.billService.addBill(bill);
        DataStatus ds = new DataStatus();
        if (row > 0){
            ds.setStatusCode(100);
            ds.setStatusDescription("新增成功");
            return ds;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("新增失败");
            return ds;
        }
    }
    @ResponseBody
    @RequestMapping("/updateBill")
    public DataStatus updateBill(@RequestBody Bill bill){
        int row = this.billService.updateBill(bill);
        DataStatus ds = new DataStatus();
        if (row>0){
            ds.setStatusCode(100);
            ds.setStatusDescription("数据更新成功");
            return ds;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("数据更新失败");
            return ds;
        }
    }
}
