package com.js.api.goods.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.js.api.goods.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/*****
 * @Author:
 * @Description:
 ****/
public class BaseDomainOfMybatisPluginUsing {


    public static void main(String[] args) {
        BaseDomainOfMybatisPlugin<Brand> baseDomainOfMybatisPlugin = new BaseDomainOfMybatisPlugin(getBrand());
        QueryWrapper<Brand> brandQueryWrapper = new QueryWrapper<>();
        brandQueryWrapper = baseDomainOfMybatisPlugin.setUpOf(brandQueryWrapper);

        System.out.println(brandQueryWrapper.getTargetSql());
        System.out.println(brandQueryWrapper.getParamNameValuePairs());
    }

    private static Brand getBrand() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setImage("Image");
        brand.setInitial("Initial");
        brand.setName("Name");
        return brand;
    }
}
