package com.js.service.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.api.goods.entity.Sku;
import com.js.service.goods.mapper.SkuMapper;
import com.js.service.goods.service.SkuService;
import org.springframework.stereotype.Service;

/**
 * @author Jim.L
 * @title: ProductServiceImpl
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 23:14
 * @description: TODO
 */
@Service("SkuServiceImpl_v1")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

}
