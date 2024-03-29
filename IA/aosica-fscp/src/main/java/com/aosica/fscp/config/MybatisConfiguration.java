package com.aosica.fscp.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/** 
 *  
 * 数据库配置
 *  
 */  
@Configuration
@ConditionalOnBean(DataSource.class)
@ConditionalOnClass({EnableTransactionManagement.class})
@AutoConfigureAfter({DataBaseConfiguration.class })
public class MybatisConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfiguration.class);


    /**
     *  如果是多个数据库使用：DynamicDataSource ds
     *  单个数据库使用DataSource ds
     * @param
     * @return
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();  
            sessionFactory.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sessionFactory.setMapperLocations(resolver.getResources("classpath*:/mapper/*.xml"));
            return sessionFactory.getObject();  
        } 
        catch (Exception e) {
            LOGGER.error("创建SqlSessionFactory 失败：" +e.getMessage());
            e.printStackTrace();
            return null;  
        }  
    }



    @Bean
    public PageHelper pageHelper() {
        LOGGER.info("************ init MyBatis pageHelper  *********** ");
	     PageHelper pageHelper = new PageHelper();
	     Properties p = new Properties();
	     p.setProperty("offsetAsPageNum", "true");
	     p.setProperty("rowBoundsWithCount", "true");
	     p.setProperty("reasonable", "true");
	     pageHelper.setProperties(p);
	     return pageHelper;
    }
    
    
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.aosica.fscp.mapper");
        return mapperScannerConfigurer;
    }
      

      
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}  


