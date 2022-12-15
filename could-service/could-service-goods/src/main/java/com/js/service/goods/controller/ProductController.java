package com.js.service.goods.controller;

import com.js.api.goods.entity.Spu;
import com.js.bean.request.RequestGateway;
import com.js.bean.response.ResponseResult;
import com.js.service.goods.businessDomain.ProductDomainForGoods;
import com.js.service.goods.businessVo.ProductVoForGoods;
import com.js.service.goods.service.SkuService;
import com.js.service.goods.service.SpuService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Jim.L
 * @title: CategoryController
 * @projectName web-could
 * @date 2022/1/11
 * @dateTime 18:12
 * @description: TODO
 */
@RestController
@RequestMapping("/product")
@Setter
public class ProductController {

    @Qualifier("SkuServiceImpl_v1")
    @Autowired
    private SkuService skuService;

    @Qualifier("SpuServiceImpl_v1")
    @Autowired
    private SpuService spuService;


    @PostMapping("/search/spu")
    public ResponseResult<List<Spu>> searchForSpu(
            @RequestBody RequestGateway<Spu> requestGateway
    ) {
        List<Spu> beans = spuService.search(requestGateway.getBean());
        return ResponseResult.ok(beans);
    }

    @PostMapping("/save")
    public ResponseResult save(
            @RequestBody RequestGateway<ProductVoForGoods> requestGateway
    ) {
        Optional<ProductVoForGoods> optional = Optional.of(requestGateway.getBean());
        ProductDomainForGoods productDomainForGoods = optional.get().toDomain(skuService, spuService);
        return ResponseResult.UnknownStatus(productDomainForGoods.save());
    }


}
