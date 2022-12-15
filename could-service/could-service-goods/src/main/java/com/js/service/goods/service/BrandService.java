package com.js.service.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.js.api.goods.entity.Brand;

import java.util.List;

/**
 * @author Jim.L
 * @title: BrandService
 * @projectName web-could
 * @date 2021/12/24
 * @dateTime 18:06
 * @description: TODO
 */

public interface BrandService extends IService<Brand> {

    Boolean update(Brand bean);

    Boolean delete(String ids);

    List<Brand> search(Brand bean);

    Page<Brand> search(Brand bean, Long pageNo, Long pageSize);

}
