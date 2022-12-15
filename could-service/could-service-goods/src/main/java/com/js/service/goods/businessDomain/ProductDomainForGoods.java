package com.js.service.goods.businessDomain;

import com.alibaba.fastjson.JSON;
import com.js.api.goods.domain.ProductDomain;
import com.js.api.goods.domain.status.AdminLifeCycle;
import com.js.api.goods.domain.status.MarketLifeCycle;
import com.js.api.goods.domain.status.ProductLifeCycle;
import com.js.api.goods.entity.Sku;
import com.js.api.goods.entity.Spu;
import com.js.service.goods.service.SkuService;
import com.js.service.goods.service.SpuService;
import com.js.tools.date.DateUtils;
import com.js.tools.verify.CheckForBasicLogic;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jim.L
 * @title: ProdDomain
 * @projectName web-could
 * @date 2022/1/14
 * @dateTime 23:38
 * @description: TODO
 */
@Data
public class ProductDomainForGoods extends ProductDomain {


    private SkuService skuService;

    private SpuService spuService;

    public ProductDomainForGoods(Spu spu, List<Sku> skus) {
        super(spu, skus);
    }

    public ProductDomainForGoods(SkuService skuService, SpuService spuService, Spu spu, List<Sku> skus) {
        super(spu, skus);

    }

    public ProductDomainForGoods() {

    }

    private void mustHasCheck() {
        if (CheckForBasicLogic.ifNotNull(skuService) && CheckForBasicLogic.ifNotNull(spuService)) {
            throw new RuntimeException(" If you wanna use domain server please setup skuService and spuService");
        }
    }


    public Boolean save() {
        mustHasCheck();
        initSpu(getSpu());
        boolean saveSpu = spuService.save(getSpu());
        initSku(getSpu(), getSkus());
        boolean saveSkuAll = skuService.saveBatch(getSkus());
        return saveSpu && saveSkuAll;
    }

    private void initSku(Spu spu, List<Sku> skus) {
        if (CheckForBasicLogic.ifNull(spu) || CheckForBasicLogic.ifNull(skus)) {
            return;
        }
        for (Sku sku : skus) {
//            sku Name
            Map<String, String> skuAttrMap = JSON.parseObject(sku.getSkuAttribute(), Map.class);
            StringBuilder skuName = new StringBuilder(spu.getName());
            skuAttrMap.forEach((key, value) -> skuName.append(" ").append(value));
            sku.setName(skuName.toString());
            sku.setCreateTime(DateUtils.getNow());
            sku.setUpdateTime(DateUtils.getNow());
            sku.setCategoryId(spu.getCategoryThreeId());
            sku.setCategoryId(spu.getCategoryThreeId());
            sku.setBrandId(spu.getBrandId());
            sku.setSpuId(spu.getId());
            sku.setStatus(AdminLifeCycle.WAIT_APPROVAL.getStatus());
        }


    }

    public void initSpu(Spu spu) {
        if (CheckForBasicLogic.ifNull(spu)) {
            return;
        }
        spu.setIsDelete(ProductLifeCycle.CLOSE.getStatus());
        spu.setIsMarketable(MarketLifeCycle.VIEW.getStatus());
        spu.setStatus(AdminLifeCycle.WAIT_APPROVAL.getStatus());

    }


}
