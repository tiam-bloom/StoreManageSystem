package com.controller;

import com.po.DataStatus;
import com.po.PurchaseList;
import com.service.PurchaseListService;
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
public class PurchaseListController {
    @Autowired
    private PurchaseListService purchaseListService;
    @ResponseBody
    @RequestMapping("/findPLById")
    public JSONObject findPLById(Integer id) {
        PurchaseList purchaseList = purchaseListService.findPLById(id);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (purchaseList != null){
            ds.setStatusCode(100);
            ds.setStatusDescription("查询id成功");
            jo.put("DataStatus",ds);
            jo.put("Data",purchaseList);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询id失败");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findPLByName")
    public JSONObject findPLByName(String name) {
        List<PurchaseList> purchaseList = purchaseListService.findPLByName(name);
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (purchaseList != null){
            ds.setStatusCode(100);
            ds.setStatusDescription("模糊查询name成功");
            jo.put("DataStatus",ds);
            jo.put("Data",purchaseList);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("模糊查询name失败");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/findAllPL")
    public JSONObject findAllPL() {
        List<PurchaseList> purchaseList = purchaseListService.findAllPL();
        JSONObject jo = new JSONObject();
        DataStatus ds = new DataStatus();
        if (purchaseList != null){
            ds.setStatusCode(100);
            ds.setStatusDescription("查询全部成功");
            jo.put("DataStatus",ds);
            jo.put("Data",purchaseList);
            return jo;
        }else{
            ds.setStatusCode(104);
            ds.setStatusDescription("查询全部失败");
            jo.put("DataStatus",ds);
            return jo;
        }
    }
    @ResponseBody
    @RequestMapping("/deletePL")
    public DataStatus deletePL(Integer id){
        int row = this.purchaseListService.deletePL(id);
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
    @RequestMapping("/addPL")
    public DataStatus addPl(@RequestBody PurchaseList purchaseList){
        int row = this.purchaseListService.addPL(purchaseList);
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
    @RequestMapping("/updatePL")
    public DataStatus updatePL(@RequestBody PurchaseList purchaseList){
        int row = this.purchaseListService.updatePL( purchaseList);
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
