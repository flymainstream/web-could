package com.js.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jim.L
 * @title: RequestGateway
 * @projectName web-could
 * @date 2021/12/24
 * @dateTime 18:34
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestGateway<T> implements Serializable {

    private String requestToken;
    private String action;
    private T bean;

}
