//package com.achilles.themis.infrastructure.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Data;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource.druid.mysql")
//@PropertySource("classpath:application-infrastructure.properties")
//@Data
//@MapperScan(basePackages = "com.achilles.themis.infrastructure.repository.mysql",sqlSessionFactoryRef = "mysqlSqlSessionFactory")
//public class DruidMysqlConfiguration {
//
//    private static final Logger logger = LoggerFactory.getLogger(DruidMysqlConfiguration.class);
//
//    private String type;
//
//    private String driverClassName;
//
//    private String url;
//
//    private String username;
//
//    private String password;
//
//    private Integer initialSize;
//
//    private Integer minIdle;
//
//    private Integer maxActive;
//
//    private Long maxWait;
//
//    private Long timeBetweenEvictionRunsMillis;
//
//    private Long minEvictableIdleTimeMillis;
//
//    private String validationQuery;
//
//    private boolean testWhileIdle;
//
//    private boolean testOnBorrow;
//
//    private boolean testOnReturn;
//
//    @Bean(name = "mysqlDataSource")
//    public DataSource DataSource(){
//        logger.info("start build mysql druid pool");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        return dataSource;
//    }
//
//    @Bean(name = "mysqlSqlSessionFactory")
//    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource datasource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(datasource);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        bean.setConfiguration(configuration);
//        return bean.getObject();
//    }
//
//    @Bean(name = "mysqlSqlSessionTemplate")
//    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sessionFactory) {
//        return new SqlSessionTemplate(sessionFactory);
//    }
//
//
//}
