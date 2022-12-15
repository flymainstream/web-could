package com.js.service.goods.service;

import com.js.api.goods.entity.SkuAttribute;

import java.util.List;

/**
 * @author Jim.L
 * @title: AttributeService
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 17:06
 * @description: TODO
 */
public interface AttributeService {
    List<SkuAttribute> search(SkuAttribute bean);
}
