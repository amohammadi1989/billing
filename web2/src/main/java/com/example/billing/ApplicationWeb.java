package com.example.billing;

import org.apache.struts.action.ActionServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example.billing.nigc"})
public class ApplicationWeb  {
    public static void main(String[] args) {
        SpringApplication.run( ApplicationWeb.class, args);
    }
    @Bean
    public ServletRegistrationBean actionServlet() {
        ActionServlet servlet = new ActionServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean( servlet, "*.do" );
        bean.addInitParameter( "config", "/WEB-INF/struts-config.xml" );
        bean.setLoadOnStartup( 1 );
        bean.setName( "action" );
        return bean;
    }
}
