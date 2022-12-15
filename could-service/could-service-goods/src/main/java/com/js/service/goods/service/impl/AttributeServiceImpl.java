package com.js.service.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.api.goods.domain.BaseDomainOfMybatisPlugin;
import com.js.api.goods.entity.SkuAttribute;
import com.js.service.goods.mapper.SkuAttrMapper;
import com.js.service.goods.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim.L
 * @title: AttributeServiceImpl
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 17:19
 * @description: TODO
 */
@Service("AttributeServiceImpl_v1")
public class AttributeServiceImpl extends ServiceImpl<SkuAttrMapper, SkuAttribute> implements AttributeService {

    @Autowired
    private SkuAttrMapper skuAttrMapper;

    @Override
    public List<SkuAttribute> search(SkuAttribute bean) {
        QueryWrapper<SkuAttribute> wrapper = new QueryWrapper<>();
        wrapper = new BaseDomainOfMybatisPlugin<SkuAttribute>(bean).setUpOf(wrapper);
        return skuAttrMapper.selectList(wrapper);
    }
}
