package com.bean;

//进货清单
public class PurchaseList {
    private Integer id;//商品编号 主键 自增
    private String name;//商品名
    private Integer amount;//商品数量
    private Integer priceIn;//进货单价
    private Integer amountPrice;//总金额

    @Override
    public String toString() {
        return "PurchaseList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", priceIn=" + priceIn +
                ", amountPrice=" + amountPrice +
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Integer priceIn) {
        this.priceIn = priceIn;
    }

    public Integer getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(Integer amountPrice) {
        this.amountPrice = amountPrice;
    }
}
