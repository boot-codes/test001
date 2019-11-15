package com.aosica.agriculture.word;

import io.swagger.annotations.*;
import org.apache.commons.math3.optim.linear.SolutionCallback;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
 


public class MyApplicationListener  {

    final  static  Class[] urlClazz = {RequestMapping.class ,GetMapping.class,PostMapping.class} ;

    public static void main(String[] args) {

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final String RESOURCE_PATTERN = "/**/*.class";
        // 扫描的包名
        final String BASE_PACKAGE = "com.aosica.agriculture.controller";
        Map<String,Class<?>> classCache = new HashMap<>();
        try
        {
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
                        classCache.put(className, clazz);
                        Method[] declaredMethods = clazz.getDeclaredMethods();
                        for (Method m:declaredMethods)
                        {
                            // 获取方法功能描述的注解。
                            System.out.println("方法功能描述：" + methodDescription(m));
                            //获取方法请求url
                            System.out.println("请求url:"+ getRequestURI(m));
                            // 获取请求参数的注解
                            System.out.println("请求参数："+requestParams(m));
                            // 获取返回类型的注解
                            System.out.println("返回值类型：" +requestResponse(m));
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取方法请求URI
     * @param m
     * @return
     */
    public static String getRequestURI(Method m) {
        String[] path =null ;
        for (Class c :urlClazz) {
            Annotation urlAnnotation = m.getAnnotation(c);
            if(urlAnnotation !=null) {
                if (urlAnnotation instanceof RequestMapping) {
                    RequestMapping requestMapping = (RequestMapping)urlAnnotation ;
                    path = requestMapping.value() ;
                }
                else if (urlAnnotation instanceof PostMapping) {
                    PostMapping postMapping =   (PostMapping)urlAnnotation ;
                    path = postMapping.value() ;
                }
                else if (urlAnnotation instanceof GetMapping) {
                    GetMapping getMapping =  (GetMapping)urlAnnotation ;
                    path = getMapping.value() ;
                }
            }
        }
        return  path[0] ;
    }

    // 获取方法功能描述的注解。
    public static String methodDescription(Method method) {

        String methodDescription = null ;
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        if( apiOperation != null) {
            methodDescription = apiOperation.value() ;
            //System.out.println("方法功能描述：" +methodDescription);
        }
        return  methodDescription ;
    }



    // 获取请求参数的注解
    public static RequestParam[] requestParams (Method method) {

        RequestParam[] params = null ;

        ApiImplicitParams apiImplicitParams = method.getAnnotation(ApiImplicitParams.class);
        if(apiImplicitParams != null) {
            //System.out.println("请求参数：");
            ApiImplicitParam[] value = apiImplicitParams.value();
            params = new RequestParam[value.length] ;
            int n = 0 ;
            for (ApiImplicitParam apiImplicitParam : value) {
                RequestParam requestParam = new RequestParam(apiImplicitParam.name(),apiImplicitParam.value()) ;
                params[n++] = requestParam ;
                //System.out.println("\t" +apiImplicitParam.name() + "--->" + apiImplicitParam.value());
            }
        }
        return  params ;
    }


    // 获取返回类型的注解

    public static RequestResponse requestResponse(Method method)
    {
        ApiResponses apiResponses = method.getAnnotation(ApiResponses.class);
        if(apiResponses != null) {
            //System.out.println("返回值类型：");
            ApiResponse[] value = apiResponses.value();
            for (ApiResponse a :value) {
                //System.out.println( "\t状态码：" +a.code()  +",返回消息提示：" +a.message() +"，返回类型：" +a.response());
                RequestResponse requestResponse = new RequestResponse() ;
                requestResponse.setCode(a.code());
                requestResponse.setMessage(a.message());
                requestResponse.setAClass(a.response());
                return  requestResponse ;
            }
        }
        return  null ;
    }

}