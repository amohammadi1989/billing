package com.example.billing.nigc.action;

import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Getter
@Setter
public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Autowired
    private AccountServices accountServices;
    List<Account> accounts;
    @Override
    @Action(value = "/index", results = {@Result(location = "index.jsp", name = "success")})
    public String execute() {
        accounts=accountServices.getAccount();
        return SUCCESS;
    }
    
    
}