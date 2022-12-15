package com.js.service.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.js.api.goods.entity.Brand;
import com.js.api.goods.entity.Category;
import com.js.api.goods.entity.SkuAttribute;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jim.L
 * @title: CouldGoodsMapper
 * @projectName web-could
 * @date 2021/12/21
 * @dateTime 22:30
 * @description: TODO
 */
public interface CategoryMapper extends BaseMapper<Category> {

    @Select("select a.* from  brand a inner join (select distinct brand_id from category_brand where category_id = #{id}) cb on a.id=cb.brand_id order by a.sort desc ")
    List<Brand> searchBrandByCategory(@Param("id") Integer id);

    @Select("select * from sku_attribute a inner join (select distinct attr_id from category_attr where category_id= #{id}) ca on a.id=ca.attr_id;")
    List<SkuAttribute> searchAttributeByCategory(@Param("id") Integer id);

}
