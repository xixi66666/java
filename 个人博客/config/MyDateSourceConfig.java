//package com.example.demo.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import javax.xml.crypto.Data;
//import java.sql.SQLException;
//
//@Configuration
//public class MyDateSourceConfig {
//
//    @ConfigurationProperties("spring.datasource")
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        //加入了监控功能
//        druidDataSource.setFilters("stat");
//        return druidDataSource;
//    }
//
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        StatViewServlet statViewServlet = new StatViewServlet();
//        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
////
////        registrationBean.addInitParameter("loginUsername", "admin");
////        registrationBean.addInitParameter("loginPassword", "123456");
//
//
//        return registrationBean;
//    }
//
//}
