package com.aosica.fscp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @program:
 * @description: 跨域请求
 * @author: yuzp
 * @create: 2019-08-26 16:25
 **/

// @Configuration
public class CorsConfig   {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //
        corsConfiguration.addAllowedHeader("*"); //
        corsConfiguration.addAllowedMethod("*"); //
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); //
        return new CorsFilter(source);
    }


}
