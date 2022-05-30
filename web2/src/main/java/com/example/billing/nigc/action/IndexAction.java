package com.example.billing.nigc.action;
import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
public class IndexAction extends Action {
  @Autowired
  private AccountServices accountServices;
  
  List<Account> accountList;
  private String helloWorldMessage="test";
  
  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
  throws Exception {
    
    accountList=accountServices.getAccount();
 /*   com.example.billing.nigc.action.test.ActionForm exampleForm = (com.example.billing.nigc.action.test.ActionForm) form;
    exampleForm.setAccountList( accountList );
    exampleForm.setName( "ali mohammadi" );*/
   // request.getSession().setAttribute( "accountList",accountList );
    request.setAttribute( "sizeali",accountList.size() );
    request.setAttribute( "listAcc",accountList );
    return mapping.findForward("success");
  }
  
}