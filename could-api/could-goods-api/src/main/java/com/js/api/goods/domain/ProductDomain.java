package com.js.api.goods.domain;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.js.api.goods.entity.Sku;
import com.js.api.goods.entity.Spu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

/**
 * @author Jim.L
 * @title: ProdDomain
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 23:38
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {

    // Spu
    private Spu spu;
    // Sku
    private List<Sku> skus;


}
