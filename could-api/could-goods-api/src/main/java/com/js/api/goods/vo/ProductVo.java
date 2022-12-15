package com.js.api.goods.vo;

import com.js.api.goods.entity.Sku;
import com.js.api.goods.entity.Spu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*****
 * @Author:
 * @Description:
 ****/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo {
    // Spu
    private Spu spu;
    // Sku
    private List<Sku> skus;

}
