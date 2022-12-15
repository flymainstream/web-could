package com.js.service.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.api.goods.domain.BaseDomainOfMybatisPlugin;
import com.js.api.goods.entity.Brand;
import com.js.api.goods.entity.Category;
import com.js.api.goods.entity.SkuAttribute;
import com.js.service.goods.mapper.CategoryBrandMapper;
import com.js.service.goods.mapper.CategoryMapper;
import com.js.service.goods.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jim.L
 * @title: CategoryServiceImpl
 * @projectName web-could
 * @date 2022/1/11
 * @dateTime 18:21
 * @description: TODO
 */
@Service("CategoryServiceImpl_v1")
@Setter
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> search(Category bean) {

        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper = new BaseDomainOfMybatisPlugin<Category>(bean).setUpOf(categoryQueryWrapper);
        return categoryMapper.selectList(categoryQueryWrapper);
    }

    @Override
    public List<Brand> searchBrandByCategory(Category bean) {
        return categoryMapper.searchBrandByCategory(bean.getId());
    }

    @Override
    public List<SkuAttribute> searchAttributeByCategory(Category bean) {
        return categoryMapper.searchAttributeByCategory(bean.getId());

    }
}
