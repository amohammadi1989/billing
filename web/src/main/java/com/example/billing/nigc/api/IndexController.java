package com.example.billing.nigc.api;

import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.sql.DataSource;
import javax.websocket.server.PathParam;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/billing")
public class IndexController {
  @Autowired
     private AccountServices accountServices;
  @Autowired private ApplicationContext appContext;
  @Autowired private DataSource dataSource;

    @GetMapping("/")
    public RedirectView index(RedirectAttributes attributes) {
        return new RedirectView("index.html");
    }
    @GetMapping("/getAccount")
    public List<Account> getAccount(){
        return accountServices.getAccount();
    }
  @GetMapping(value = "/pdf")
  public ResponseEntity<byte[]> getEmployeeRecordReport(@PathParam( "name" ) String name) {
  
    try {
   
      List<Account> accounts = accountServices.getAccount();
  
      final InputStream stream = this.getClass().getResourceAsStream( "/report.jrxml");
  
      final JasperReport report = JasperCompileManager.compileReport( stream);
  
      final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource( accounts);
  
      final Map<String, Object> parameters = new HashMap<>();
      parameters.put("Date",(new Date()).toString());
  
      final JasperPrint print = JasperFillManager.fillReport( report, parameters, source);
      
      
      HttpHeaders headers = new HttpHeaders();
      //set the PDF format
      headers.setContentType( MediaType.APPLICATION_PDF);
      headers.setContentDispositionFormData("filename", "account.pdf");
      //create the report in PDF format
      return new ResponseEntity<>
      (JasperExportManager.exportReportToPdf( print), headers, HttpStatus.OK);
    
    } catch(Exception e) {
      return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
