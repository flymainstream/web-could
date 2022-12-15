package com.js.service.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.js.api.goods.entity.Brand;
import com.js.bean.request.RequestGateway;
import com.js.bean.response.ResponseResult;
import com.js.service.goods.service.BrandService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jim.L
 * @title: BrandController
 * @projectName web-could
 * @date 2021/12/24
 * @dateTime 18:13
 * @description: TODO
 */
@RestController
@RequestMapping("/Brand")
@Getter
public class BrandController {

    @Qualifier("BrandService_v1")
    @Autowired
    private BrandService brandService;

    @PostMapping()
    public ResponseResult add(@RequestBody RequestGateway<Brand> request) {

        getBrandService().save(request.getBean());
        return ResponseResult.ok();
    }

    @PostMapping("/search")
    public ResponseResult search(@RequestBody RequestGateway<Brand> request) {

        List<Brand> brands = getBrandService().search(request.getBean());
        return ResponseResult.ok(brands);
    }

    @PostMapping("/search/pageNo/pageSize")
    public ResponseResult search(
            @RequestBody RequestGateway<Brand> request,
            @PathVariable(value = "pageNo") Long pageNo,
            @PathVariable(value = "pageSize") Long pageSize
    ) {

        Page<Brand> brandsForPage = getBrandService().search(request.getBean(), pageNo, pageSize);
        return ResponseResult.ok(brandsForPage);
    }


    @PutMapping
    public ResponseResult update(@RequestBody RequestGateway<Brand> request) {

        return ResponseResult.UnknownStatus(getBrandService().update(request.getBean()));
    }

    @DeleteMapping
    public ResponseResult delete(@RequestBody RequestGateway<String> request) {
        String ids = request.getBean();

        return ResponseResult.UnknownStatus(getBrandService().delete(ids));
    }


}
