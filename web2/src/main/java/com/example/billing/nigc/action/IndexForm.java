package com.example.billing.nigc.action;

import com.example.billing.nigc.entity.Account;

import java.util.List;
/**
 * Created By: Ali Mohammadi
 * Date: 28 May, 2022
 */
public class IndexForm extends org.apache.struts.action.ActionForm {
  private List<Account> accountList;
  private String name;
  
  public List<Account> getAccountList() {
    return accountList;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setAccountList(List<Account> accountList) {
    this.accountList = accountList;
  }
}
