package com.aoscia.base.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * druid数据库连接池配置类
 * @author yuzp
 *
 */
@Configuration
public class DataBaseConfiguration {


    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConfiguration.class);

	/**
	 * druid数据库连接池配置
	 */
    @Value("${spring.datasource.url}")  
    private String dbUrl;

    @Value("${spring.datasource.username}")  
    private String username;

    @Value("${spring.datasource.password}")  
    private String password;

    @Value("${spring.datasource.driverClassName}")  
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")  
    private int initialSize;

    @Value("${spring.datasource.minIdle}")  
    private int minIdle;

    @Value("${spring.datasource.maxActive}")  
    private int maxActive;

    @Value("${spring.datasource.maxWait}")  
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")  
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")  
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")  
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")  
    private boolean testOnReturn;

//    @Value("${spring.datasource.poolPreparedStatements}")
//    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")  
    private String filters;

    @Value("${spring.datasource.type}")
    private String dataSourceType ;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;
    
    /**
     * 创建druid数据库连接池bean
     * @return
     */
    @Bean
    public DataSource dataSource() throws Exception{

        LOGGER.info(".............初始化 lot 数据..................");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setDbType(dataSourceType);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        //datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setFilters(filters);

        datasource.setConnectionProperties(connectionProperties);

        LOGGER.info("............数据lot连接成功..................");
        return datasource;
    }
    
}