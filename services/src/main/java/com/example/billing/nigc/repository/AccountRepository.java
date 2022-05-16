package com.example.billing.nigc.repository;
import com.example.billing.nigc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  List<Account> findAccountsByName(String name);
}
