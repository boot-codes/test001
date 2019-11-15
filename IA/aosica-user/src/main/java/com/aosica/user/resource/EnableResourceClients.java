package com.aosica.user.resource;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ResourceClientsRegistrar.class)
public @interface EnableResourceClients {


	String[] value() default {};


	String[] basePackages() default {};


	Class<?>[] basePackageClasses() default {};


	Class<?>[] defaultConfiguration() default {};


	Class<?>[] clients() default {};
}
