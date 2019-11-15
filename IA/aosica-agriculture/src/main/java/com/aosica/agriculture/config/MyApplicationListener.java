package com.aosica.agriculture.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
 
/**
 * 扫描指定包下带有指定注解的class
 * @author jaffreyen
 * @date 2018/3/5
 */

public class MyApplicationListener  {
 //implements ApplicationListener


    // @Override
    public static void main(String[] args) {

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final String RESOURCE_PATTERN = "/**/*.class";
        // 扫描的包名
        final String BASE_PACKAGE = "com.aosica.agriculture.controller";
        Map<String,Class<?>> classCache = new HashMap<>();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    MetadataReader reader = readerFactory.getMetadataReader(resource);
                    //扫描到的class
                    String className = reader.getClassMetadata().getClassName();
                    Class<?> clazz = Class.forName(className);
                    //判断是否有指定注解
                    Api annotation = clazz.getAnnotation(Api.class);
                    if(annotation != null){
                        //这个类使用了自定义注解
                        classCache.put(className, clazz);
                        //System.out.println(className + " :" +annotation.tags()[0]);

                        Method[] declaredMethods = clazz.getDeclaredMethods();
                        for (Method m:declaredMethods)
                        {
//                            Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
//                            for (Annotation a : declaredAnnotations) {
//                                System.out.println(a.annotationType());
//                            }
                            ApiOperation apiOperation = m.getAnnotation(ApiOperation.class);
                            if( apiOperation != null) {
                                System.out.println(apiOperation.value());
                            }

                            ApiImplicitParams apiImplicitParams = m.getAnnotation(ApiImplicitParams.class);
                            if(apiImplicitParams != null) {
                                ApiImplicitParam[] value = apiImplicitParams.value();
                                for (ApiImplicitParam apiImplicitParam : value) {
                                    System.out.println(apiImplicitParam.name() + "--->" + apiImplicitParam.value());
                                }
                            }

                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            //log.error("读取class失败", e);
            e.printStackTrace();

        }
    }
}