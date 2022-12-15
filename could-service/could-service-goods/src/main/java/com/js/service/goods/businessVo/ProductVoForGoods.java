package com.js.service.goods.businessVo;

import com.js.api.goods.vo.ProductVo;
import com.js.service.goods.businessDomain.ProductDomainForGoods;
import com.js.service.goods.service.SkuService;
import com.js.service.goods.service.SpuService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*****
 * @Author:
 * @Description:
 ****/
@Data
public class ProductVoForGoods extends ProductVo {


    public ProductDomainForGoods toDomain(SkuService skuService, SpuService spuService) {
        ProductDomainForGoods productDomainForGoods = new ProductDomainForGoods(super.getSpu(), super.getSkus());
        productDomainForGoods.setSkuService(skuService);
        productDomainForGoods.setSpuService(spuService);
        return productDomainForGoods;
    }
}
