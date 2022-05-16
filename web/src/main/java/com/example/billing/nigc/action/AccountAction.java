package com.example.billing.nigc.action;

import com.example.billing.nigc.services.AccountServices;
import com.github.javafaker.Faker;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Getter
@Setter
@Log
@InterceptorRefs({
        @InterceptorRef(value = "defaultStack"),
        @InterceptorRef(value = "execAndWait")}
)
public class AccountAction extends ActionSupport {
    private static final long serialVersionUID = 3919456810740031020L;

    @Autowired
    AccountServices accountServices;
    private String name;
    private String lastName;
    private String age;
    private String address;
    private String amount;


    public AccountAction() {

    }

    @Override
    @Action(value = "/addAccount", results = {
            @Result(location = "complete.jsp", name = SUCCESS),
            @Result(location = "wait.jsp", name = "wait"),
            @Result(location = "fail.jsp", name = ERROR)})
    public String execute() {
        try {
            Faker faker=new Faker(new Locale( "en-US"));
            accountServices.saveAccount( name,lastName,age,address,amount );
        } catch (Exception e) {
            return ERROR;
        }
        return SUCCESS;
    }
    

}
