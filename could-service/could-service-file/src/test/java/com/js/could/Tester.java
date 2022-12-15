package com.js.could;

import com.alibaba.fastjson.JSONObject;
import com.js.bean.request.RequestGateway;
import com.js.could.file.vo.FileInfo;

/**
 * @author Jim.L
 * @title: Tester
 * @projectName web-could
 * @date 2021/12/31
 * @dateTime 16:49
 * @description: TODO
 */
public class Tester {

    public static void main(String[] args) {

        RequestGateway<FileInfo> fileInfoRequestGateway = new RequestGateway<>();
        fileInfoRequestGateway.setRequestToken("123");
        fileInfoRequestGateway.setAction("delete");
        fileInfoRequestGateway.setBean(new FileInfo("springboot-mybatis-0.0.1-SNAPSHOT.jar"));
        Object o = JSONObject.toJSON(fileInfoRequestGateway);
        System.out.println(
                o
        );
    }
}
