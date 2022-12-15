package com.js.api.goods.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.js.api.goods.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*****
 * @Author:
 * @Description:
 ****/
@Data
public class BrandDomain extends BaseDomainOfMybatisPlugin<Brand> {


    public BrandDomain(Brand bean) {
        super(bean);
    }

    @Override
    public QueryWrapper<Brand> setUpOf(QueryWrapper<Brand> queryWrapper) {
        queryWrapper= super.setUpOf(queryWrapper);
        return queryWrapper;
    }
}
