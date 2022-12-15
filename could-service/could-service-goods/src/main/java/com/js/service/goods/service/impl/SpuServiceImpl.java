package com.js.service.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.api.goods.domain.BaseDomainOfMybatisPlugin;
import com.js.api.goods.entity.Sku;
import com.js.api.goods.entity.Spu;
import com.js.service.goods.mapper.SkuMapper;
import com.js.service.goods.mapper.SpuMapper;
import com.js.service.goods.service.SkuService;
import com.js.service.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim.L
 * @title: ProductServiceImpl
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 23:14
 * @description: TODO
 */
@Service("SpuServiceImpl_v1")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public List<Spu> search(Spu bean) {
        QueryWrapper<Spu> spuQueryWrapper = new QueryWrapper<>();
        spuQueryWrapper = new BaseDomainOfMybatisPlugin<Spu>(bean).setUpOf(spuQueryWrapper);
        return spuMapper.selectList(spuQueryWrapper);
    }
}
