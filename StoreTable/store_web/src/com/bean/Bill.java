package com.bean;

//账单
public class Bill {
    private Integer id;//订单编号
    private String name;//商品名
    private String cname;//客户名
    private Integer amountb;//购买数量
    private String time;//购买时间
    private Integer price;//收款金额

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", amount=" + amountb +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getAmountb() {
        return amountb;
    }

    public void setAmountb(Integer amountb) {
        this.amountb = amountb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
