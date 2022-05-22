package com.example.billing.nigc.utils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.Configurable;
import org.hibernate.type.Type;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Stream;
/**
 * Created By: Ali Mohammadi
 * Date: 22 May, 2022
 */
public class MyGenerator
implements IdentifierGenerator, Configurable {
  private String prefix;
  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
    String query=String.format( "select %s from %s",
                                session
                                .getEntityPersister( obj.getClass().getName(),obj )
                                .getIdentifierPropertyName(),obj.getClass().getSimpleName() );
    Stream<String> ids=session.createQuery( query ).stream();
    
    Long max = ids.map( s->s.replace( prefix,"" ) )
    .mapToLong(Long::parseLong)
    .max()
    .orElse(0L);
  
    return  prefix+(max + 1);
  }
  
  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
   prefix=params.getProperty( "prefix" );
  }
  
  @Override
  public void configure(Map map) {
  
  }
}
