package com.pay.channel.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by kaifa4 on 2017/1/17.
 *
 * 此类是为了以后配置多数据源，
 * 如果没有多数据源，此类则可去掉，在mapper文件下所有的累加上@Mapper注解即可
 * 相关配置参考：http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
 */
@Configuration
@MapperScan("com.pay.channel.dao.mapper")
@Deprecated //阉割版
public class MyBatisConfig {

    private static final Logger log = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private DataSource dataSource;

    //多数据源参考：http://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        log.info("MyBatisConfig create sqlSessionFactory with ConditionalOnMissingBean");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        return factory.getObject();
    }

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        log.info("MyBatisConfig create sqlSessionTemplate with ConditionalOnMissingBean");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
