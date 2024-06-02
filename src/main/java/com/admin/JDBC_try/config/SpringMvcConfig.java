package com.admin.JDBC_try.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 16:51
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.admin.JDBC_try")
public class SpringMvcConfig implements WebMvcConfigurer {
    //Setup connection to DB
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource;

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8889/gamer_shop");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    //Creating connection to DB
//    @Bean
//    public DAO getDao() {
//        return new DAOimpl(getDataSource());
//    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //Path to .jsp files
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
