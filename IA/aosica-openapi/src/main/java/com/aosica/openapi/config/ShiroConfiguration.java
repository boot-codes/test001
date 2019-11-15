package com.aosica.openapi.config;

import com.aosica.openapi.filter.StatelessAuthenticationFilter;
import com.aosica.openapi.security.StatelessDefaultSubjectFactory;
import com.aosica.openapi.security.StatelessRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



@Configuration
public class ShiroConfiguration {

    @Autowired
    private StatelessRealm statelessRealm;

    @Autowired
    private StatelessDefaultSubjectFactory statelessDefaultSubjectFactory;


    @Autowired
    private StatelessAuthenticationFilter statelessAuthcFilter ;

    @Bean
    public SecurityManager  defaultWebSecurityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(statelessRealm);

        DefaultSessionManager defaultSessionManager = new DefaultSessionManager();
        defaultSessionManager.setSessionValidationSchedulerEnabled(false);
        securityManager.setSessionManager(defaultSessionManager);

        securityManager.setSubjectFactory(statelessDefaultSubjectFactory);

        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        defaultSubjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(defaultSubjectDAO);

        return securityManager;
    }



    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("sha-256");
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false);
        this.statelessRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return  hashedCredentialsMatcher ;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean() ;
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> chainDefinitionMap = new LinkedHashMap<String,String>();
        chainDefinitionMap.put("/user/login","anon");
        chainDefinitionMap.put("/open/api/user/create","anon");

        chainDefinitionMap.put("/**", "jwt");
        //chainDefinitionMap.put("/**", "anon");

        Map<String, Filter> filterMap = new HashMap<>(1);
        filterMap.put("jwt", statelessAuthcFilter);
        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(chainDefinitionMap);

        return  shiroFilterFactoryBean ;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager());
        return attributeSourceAdvisor;
    }


    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return ehCacheManager;
    }

}
