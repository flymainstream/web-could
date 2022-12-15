package com.js.api.goods.annotation;

import java.lang.annotation.*;

/**
 * @author Jim.L
 * @title: Like
 * @projectName web-could
 * @date 2022/1/13
 * @dateTime 14:54
 * @description: TODO
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Like {

    boolean enable() default true;

}
