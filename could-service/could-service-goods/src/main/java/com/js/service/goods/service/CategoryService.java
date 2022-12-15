package com.js.service.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.js.api.goods.entity.Brand;
import com.js.api.goods.entity.Category;
import com.js.api.goods.entity.SkuAttribute;

import java.util.List;

/**
 * @author Jim.L
 * @title: BrandService
 * @projectName web-could
 * @date 2021/12/24
 * @dateTime 18:06
 * @description: TODO
 */

public interface CategoryService extends IService<Category> {


    /**
     *
     * @param bean category entity bean
     * @return Category list
     */
    List<Category> search(Category bean);

    List<Brand> searchBrandByCategory(Category bean);

    List<SkuAttribute> searchAttributeByCategory(Category bean);
}
