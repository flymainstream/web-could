package com.js.api.goods.domain.status;

/**
 * @author Jim.L
 * @title: productLifeCycle
 * @projectName web-could
 * @date 2022/1/16
 * @dateTime 1:30
 * @description: TODO
 */
public enum MarketLifeCycle {
    VIEW(0, " this status in market only for view "),
    PRE_SALE(1, "this status in market for pre-sale "),
    SALES(2, " this status in market able for sale "),
    SOLD_OUT(3, " this status in market able for sale ")
    ;

    private Integer status;
    private String describe;


    MarketLifeCycle(Integer status, String describe) {
        this.status = status;
        this.describe = describe;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDescribe() {
        return describe;
    }
}
