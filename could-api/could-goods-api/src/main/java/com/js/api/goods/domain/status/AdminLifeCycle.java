package com.js.api.goods.domain.status;

/**
 * @author Jim.L
 * @title: productLifeCycle
 * @projectName web-could
 * @date 2022/1/16
 * @dateTime 1:30
 * @description: TODO
 */
public enum AdminLifeCycle {
    WAIT_APPROVAL(0, " this status is waiting for approval from admin users  "),
    REJECTED(1, " this status is rejected from admin users "),
    APPROVED(2, "this status is approved from admin users "),
    ;

    private Integer status;
    private String describe;


    AdminLifeCycle(Integer status, String describe) {
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
