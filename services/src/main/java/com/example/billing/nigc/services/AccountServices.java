package com.example.billing.nigc.services;
import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * Created By: Ali Mohammadi
 * Date: 15 May, 2022
 */
@Service
public class AccountServices {
  
  @Autowired
  private  AccountRepository accountRepository;

  
  public List<Account> getAccount() {
    List<Account> accounts=accountRepository.findAll();
    accounts.forEach(a-> session.execute( a ) );
    accounts.forEach( System.out::println );
    return accounts;
  }
  public List<Account> getAccountByName(String name){
    List<Account> accounts=accountRepository.getAccountWithElement( "40001" );
    return accountRepository.findAccountsByName(name);
  }
  public Account getAccountById(String id){
    return accountRepository.findById( id ).get();
  }
  
  private static StatelessKnowledgeSession session;
  @PostConstruct
  public void init() {
    Faker faker=new Faker(new Locale( "en-US"));
    IntStream.range( 1,30 ).forEach(i->{
      saveAccount( faker.name().name(),faker.name().lastName(),
                   faker.number().numberBetween( 10
      ,100 ),
                   faker.address().fullAddress(),String.valueOf(faker.number().numberBetween( 400
      ,900 )));
    }  );
  
    try {
      KnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
      session = knowledgeBase.newStatelessKnowledgeSession();
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
  private static KnowledgeBase createKnowledgeBaseFromSpreadsheet()
  throws Exception {
    DecisionTableConfiguration dtconf = KnowledgeBuilderFactory
    .newDecisionTableConfiguration();
    dtconf.setInputType( DecisionTableInputType.XLS);
    
    KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory
    .newKnowledgeBuilder();
    knowledgeBuilder.add( ResourceFactory
                          .newClassPathResource( "account.xls" ),
                          ResourceType.DTABLE, dtconf);
    
    if (knowledgeBuilder.hasErrors()) {
      throw new RuntimeException(knowledgeBuilder.getErrors().toString());
    }
    
    KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(knowledgeBuilder
                                       .getKnowledgePackages());
    return knowledgeBase;
  }
  
  public void saveAccount(String name, String lastName,int age,String address,String amount) {
    Account account = Account.builder()
    .age( age )
    .address( address )
    .amount(  amount )
    .name( name )
    .lastName( lastName )
    .build();
    accountRepository.save( account );
  }
}
