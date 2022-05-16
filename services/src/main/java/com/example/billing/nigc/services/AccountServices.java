package com.example.billing.nigc.services;
import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    return accountRepository.findAll();
  }
  
  @PostConstruct
  public void init() {
    Faker faker=new Faker(new Locale( "en-US"));
    IntStream.range( 1,30 ).forEach(i->{
      saveAccount( faker.name().name(),faker.name().lastName(),
                   String.valueOf(faker.number().numberBetween( 10
      ,100) ),
                   faker.address().fullAddress(),String.valueOf(faker.number().numberBetween( 400
      ,900 )));
    }  );
  }
  
  public void saveAccount(String name, String lastName,String age,String address,String amount) {
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
