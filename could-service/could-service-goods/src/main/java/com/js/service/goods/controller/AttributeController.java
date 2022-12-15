package com.js.service.goods.controller;

import com.js.api.goods.entity.Brand;
import com.js.api.goods.entity.Category;
import com.js.api.goods.entity.SkuAttribute;
import com.js.bean.request.RequestGateway;
import com.js.bean.response.ResponseResult;
import com.js.service.goods.service.AttributeService;
import com.js.service.goods.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/attribute")
@Setter
public class AttributeController {

    @Qualifier("AttributeServiceImpl_v1")
    @Autowired
    private AttributeService attributeService;


    @PostMapping("/search")
    public ResponseResult<List<SkuAttribute>> search(
            @RequestBody RequestGateway<SkuAttribute> requestGateway
    ) {
        List<SkuAttribute> beans = attributeService.search(requestGateway.getBean());
        return ResponseResult.ok(beans);
    }


}
