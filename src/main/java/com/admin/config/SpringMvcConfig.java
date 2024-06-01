package com.admin.config;

import com.admin.dao.DAO;
import com.admin.dao.DAOimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 16:51
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.admin")
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource;

        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8889/JDBC_app");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
    @Bean
    public DAO getDao() {
        return new DAOimpl(getDataSource());
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }
}
