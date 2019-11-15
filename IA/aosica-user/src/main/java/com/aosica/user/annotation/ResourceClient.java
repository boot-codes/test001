package com.aosica.user.annotation;



import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceClient {



    @AliasFor("name")
    String value() default "";


    @Deprecated
    String serviceId() default "";


    @AliasFor("value")
    String name() default "";


    String qualifier() default "";


    String url() default "";


    boolean decode404() default false;


    Class<?>[] configuration() default {};


    Class<?> fallback() default void.class;


    Class<?> fallbackFactory() default void.class;


    String path() default "";


    boolean primary() default true;

}
