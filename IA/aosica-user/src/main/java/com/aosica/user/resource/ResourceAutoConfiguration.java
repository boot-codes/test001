package com.aosica.user.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ResourceAutoConfiguration {

//    @Autowired(required = false)
//    private List<ResourceClientSpecification> list = new ArrayList<>();
//
//    @Autowired
//    private List<Controller>  controllerList = new ArrayList<>() ;

    @PostConstruct
    public void resourceClient() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Controller.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }

//        System.out.println(controllerList);

//        list.stream().forEach(r->{
//
//            System.out.println(r.getName());
//            System.out.println(r.getConfiguration());
//        });
    }

}
