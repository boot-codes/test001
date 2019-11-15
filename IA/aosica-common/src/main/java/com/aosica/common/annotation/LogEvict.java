package com.aosica.common.annotation;

import com.aosica.common.constant.OperationEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogEvict {

    /**操作事件*/
    String operEvent() default "";


    /**说明*/
    String explain() default "";


    /**业务Id 直接输入业务Id名*/
    String billId() default "";


    /** 日志类型 */
    OperationEnum operType() default OperationEnum.DEFAULT;
}
