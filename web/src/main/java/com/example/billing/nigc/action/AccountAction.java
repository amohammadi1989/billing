package com.example.billing.nigc.action;

import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@Log
/*@InterceptorRefs({
        @InterceptorRef(value = "defaultStack"),
        @InterceptorRef(value = "execAndWait")}
)*/
public class AccountAction extends ActionSupport {
    private static final long serialVersionUID = 3919456810740031020L;
    @Autowired
    AccountServices accountServices;
    List<Account> accounts;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private String amount;
    
    
    public AccountAction() {
    
    }
    
    @Override
    @Action(value = "/addAccount", results = {
    @Result(location = "index.jsp", name = "success")})
    
    public String execute() {
        try {
            accountServices.saveAccount( name,lastName,age,address,amount );
            accounts=accountServices.getAccount();
        } catch (Exception e) {
            //  return ERROR;
        }
        return "success";
        //return null;
    }
    
    
    
}
