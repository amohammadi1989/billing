package com.example.billing.nigc.repository;
import com.example.billing.nigc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
public interface AccountRepository extends JpaRepository<Account, Long> {
  @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
  List<Account> findAll();
  List<Account> findAccountsByName(String name);
  public List getAccountWithElement(Long id);
  
}
