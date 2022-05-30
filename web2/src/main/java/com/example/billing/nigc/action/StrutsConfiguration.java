package com.example.billing.nigc.action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
@Configuration
public class StrutsConfiguration {
  
  private static Logger logger = LoggerFactory.getLogger( StrutsConfiguration.class);
  
  public StrutsConfiguration(AutowireCapableBeanFactory beanFactory, ServletContext servletContext) {
    logger.info("*** CONFIGURING STRUTS ***");
    logger.info("Got beanFactory: " + (beanFactory != null));
    logger.info("Got servletContext: " + (servletContext != null));
    servletContext.setAttribute("spring.bean.factory", beanFactory);
  }
}