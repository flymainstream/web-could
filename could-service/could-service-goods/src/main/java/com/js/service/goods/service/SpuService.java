package com.js.service.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.js.api.goods.entity.Spu;

import java.util.List;

/**
 * @author Jim.L
 * @title: productService
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 23:11
 * @description: TODO
 */
public interface SpuService extends IService<Spu> {

    List<Spu> search(Spu bean);
    
}
