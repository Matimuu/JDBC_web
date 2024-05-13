package com.admin.JDBC_try.config;

import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 16:42
 */
public class WebInterfaceInitializer implements WebApplicationInitializer {

    //Initialzation of servlet.
    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(SpringMvcConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
