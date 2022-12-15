package com.js.api.goods.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.js.api.goods.annotation.Like;
import com.js.tools.chanages.ChangeForStr;
import com.js.tools.pickup.PickUpForReflection;
import com.js.tools.verify.CheckForBasicLogic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/*****
 * @Author:
 * @Description:
 ****/
@Data
public class BaseDomainOfMybatisPlugin<T> {

    private T bean;

    public BaseDomainOfMybatisPlugin(T bean) {
        if (bean == null) throw new RuntimeException(" bean can't be null on BaseDomainOfMybatisPlugin ");
        this.bean = bean;
    }

    private BaseDomainOfMybatisPlugin() {
    }

    public QueryWrapper<T> setUpOf(QueryWrapper<T> queryWrapper, T t) {
        setBean(t);
        return setUpOf(queryWrapper);
    }

    public QueryWrapper<T> setUpOf(QueryWrapper<T> queryWrapper) {


        T entity = getBean();
        if (isEmpty(entity)) {
            return queryWrapper;
        }

        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for (Field tFiled : declaredFields) {
            Object sqlValue = PickUpForReflection.pickUpForField(tFiled, entity);
            if (CheckForBasicLogic.ifNull(sqlValue)) {
                continue;
            }
            Like annotationOfLike = tFiled.getAnnotation(Like.class);
            if (annotationOfLike != null && annotationOfLike.enable()) {
                queryWrapper.like(ChangeForStr.fieldToColumn(tFiled.getName()), sqlValue);
            } else {
                queryWrapper.eq(ChangeForStr.fieldToColumn(tFiled.getName()), sqlValue);
            }
        }

        return queryWrapper;
    }

    public boolean isEmpty(T entity) {
        return entity == null;
    }

}
