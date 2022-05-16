package com.example.billing.nigc.action;

import com.example.billing.nigc.entity.Account;
import com.example.billing.nigc.services.AccountServices;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@ParentPackage("default")
public class ReportAction extends ActionSupport {
    @Autowired
    private AccountServices accountServices;
    @Action(value = "/report")
    @Override
    public String execute() {
        List<Account> accounts=accountServices.getAccount();
        try {
            createPdfReport( accounts );
        } catch (JRException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
    private void createPdfReport(final List<Account> employees) throws JRException {
        
        
        
        
        
        final InputStream stream = this.getClass().getResourceAsStream( "/report.jrxml");
        
        final JasperReport report = JasperCompileManager.compileReport( stream);
        
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource( employees);
        
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Ali Mohammadi"+(new Date()));
        
        final JasperPrint print = JasperFillManager.fillReport( report, parameters, source);
        
        final String filePath = "D:\\";

        JasperExportManager.exportReportToPdfFile(print,  filePath+"account_report.pdf");
    }
}
