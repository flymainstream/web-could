package com.js.api.goods.domain.status;

import lombok.Data;

/**
 * @author Jim.L
 * @title: productLifeCycle
 * @projectName web-could
 * @date 2022/1/16
 * @dateTime 1:30
 * @description: TODO
 */
public enum ProductLifeCycle {
    DELETE(1, "current product was deleted "),
    CLOSE(0, "current product was close, the admin didn't approval for release "),
    RELEASE(2, "current product was release to market ");

    private Integer status;
    private String describe;


    ProductLifeCycle(Integer status, String describe) {
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
