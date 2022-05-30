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
  
  public List getAccountWithElement(String id){
  List<Account> accounts=  entityManager.createNamedQuery( "getAll", Account.class ).getResultList();
  return accounts;
  }
}
