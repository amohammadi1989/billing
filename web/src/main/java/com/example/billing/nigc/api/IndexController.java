package com.example.billing.nigc.api;

import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.util.List;

@RestController
@RequestMapping("/billing")
public class IndexController {
     @Autowired
     private AccountServices accountServices;
    @GetMapping("/")
    public RedirectView index(RedirectAttributes attributes) {
        return new RedirectView("index.html");
    }
    @GetMapping("/getAccount")
    public List<Account> getAccount(){
        return accountServices.getAccount();
    }
}
