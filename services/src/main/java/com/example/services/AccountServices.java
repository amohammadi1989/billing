package com.example.services;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
/**
 * Created By: Ali Mohammadi
 * Date: 15 May, 2022
 */
@Service
public class AccountServices {
  private final AccountRepository accountRepository;
  
  public AccountServices(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
  
  public List<Account> getAccount(){
    return  accountRepository.findAll();
  }
  @PostConstruct
  public void init(){
    saveAccount("A","L");
    saveAccount("A1","L1");
    saveAccount("A2","L2");
    saveAccount("A3","L3");
    saveAccount("A4","L4");
    saveAccount("A5","L5");
  }
  
  private void saveAccount(String name,String lastName) {
    Account account=Account.builder().name( name ).lastName( lastName ).build();
    accountRepository.save( account );
  }
}
