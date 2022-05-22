package com.example.billing.nigc.repository;
import com.example.billing.nigc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
/**
 * Created By: Ali Mohammadi
 * Date: 22 May, 2022
 */

public class AccountRepositoryImpl {
  @Autowired
  private EntityManager entityManager;
  
  public List getAccountWithElement(Long id){
  List<Account> accounts=
  entityManager.createQuery( "select a from Account a", Account.class ).getResultList();
  return accounts;
  }
}
