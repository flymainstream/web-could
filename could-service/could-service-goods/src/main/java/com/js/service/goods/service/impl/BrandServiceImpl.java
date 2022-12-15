package com.js.service.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.api.goods.domain.BrandDomain;
import com.js.api.goods.entity.Brand;
import com.js.service.goods.mapper.BrandMapper;
import com.js.service.goods.service.BrandService;
import com.js.tools.chanages.ChangeForStr;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim.L
 * @title: ServiceImpl
 * @projectName web-could
 * @date 2021/12/24
 * @dateTime 18:07
 * @description: TODO
 */
@Service("BrandService_v1")
@Data
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Boolean update(Brand bean) {
        Wrapper<Brand> brandWrapper = new UpdateWrapper<Brand>(bean);
        return this.update(brandWrapper);
    }

    @Override
    public Boolean delete(String ids) {
        return this.removeByIds(ChangeForStr.getArrayForIds(ids));
    }

    @Override
    public List<Brand> search(Brand bean) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper = new BrandDomain(bean).setUpOf(queryWrapper);
        return getBrandMapper().selectList(queryWrapper);
    }

    @Override
    public Page<Brand> search(Brand bean, Long pageNo, Long pageSize) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper = new BrandDomain(bean).setUpOf(queryWrapper);
        return getBrandMapper().selectPage(new Page<>(pageNo, pageSize), queryWrapper);
    }
}
