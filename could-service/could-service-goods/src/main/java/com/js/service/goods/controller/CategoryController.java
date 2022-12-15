package com.js.service.goods.controller;

import com.js.api.goods.entity.Brand;
import com.js.api.goods.entity.Category;
import com.js.api.goods.entity.SkuAttribute;
import com.js.bean.request.RequestGateway;
import com.js.bean.response.ResponseResult;
import com.js.service.goods.service.BrandService;
import com.js.service.goods.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim.L
 * @title: CategoryController
 * @projectName web-could
 * @date 2022/1/11
 * @dateTime 18:12
 * @description: TODO
 */
@RestController
@RequestMapping("/category")
@Setter
public class CategoryController {

    @Qualifier("CategoryServiceImpl_v1")
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/search")
    public ResponseResult<List<Category>> search(
            @RequestBody RequestGateway<Category> requestGateway
    ) {
        List<Category> categories = categoryService.search(requestGateway.getBean());
        return ResponseResult.ok(categories);
    }

    @PostMapping("/search/brand")
    public ResponseResult<List<Brand>> searchBrandByCategory(
            @RequestBody RequestGateway<Category> requestGateway
    ) {
        List<Brand> beans = categoryService.searchBrandByCategory(requestGateway.getBean());
        return ResponseResult.ok(beans);
    }

    @PostMapping("/search/attribute")
    public ResponseResult<List<SkuAttribute>> searchAttributeByCategory(
            @RequestBody RequestGateway<Category> requestGateway
    ) {
        List<SkuAttribute> beans = categoryService.searchAttributeByCategory(requestGateway.getBean());
        return ResponseResult.ok(beans);
    }
}
