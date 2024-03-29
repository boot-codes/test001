package com.aosica.fscp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {

   @Bean
   public Decoder feignDecoder() {
       HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper());
       ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
       return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
   }

   @Bean
   public Encoder feignEncoder(){
       HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper());
       ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
       return new SpringEncoder(objectFactory);
   }


   public ObjectMapper objectMapper(){
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
       return objectMapper;
   }

}
