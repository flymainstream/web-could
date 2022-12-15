package com.js.bean.response;

import java.io.Serializable;

/*****
 * @Author:
 * @Description:
 ****/
public class ResponseResult<T> implements Serializable {

    //响应数据结果集
    private T data;

    /**
     * 状态码
     * 20000 操作成功
     * 50000 操作失败
     */
    private Integer code;

    /***S
     * 响应信息
     */
    private String message;

    public ResponseResult() {
    }

    public ResponseResult(ResponseCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ResponseResult(T data, ResponseCode resultCode) {
        this.data = data;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static ResponseResult ok() {
        return new ResponseResult<>(null, ResponseCode.SUCCESS);
    }

    public static ResponseResult UnknownStatus(Boolean bool) {
        return new ResponseResult(null, bool ? ResponseCode.SUCCESS : ResponseCode.ERROR);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(data, ResponseCode.SUCCESS);
    }

    public static ResponseResult error() {
        return new ResponseResult(null, ResponseCode.ERROR);
    }

    public static ResponseResult error(String message) {
        return secByError(ResponseCode.ERROR.getCode(), message);
    }

    //自定义异常
    public static ResponseResult secByError(Integer code, String message) {
        ResponseResult err = new ResponseResult();
        err.setCode(code);
        err.setMessage(message);
        return err;
    }

    public static ResponseResult error(ResponseCode resultCode) {
        return new ResponseResult(resultCode);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
