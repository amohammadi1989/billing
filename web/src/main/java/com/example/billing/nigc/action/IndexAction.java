package com.example.billing.nigc.action;

import com.example.billing.nigc.services.AccountServices;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private static final String URL_TIME = "http://worldtimeapi.org/api/ipfdfsdfsd/dfds";
    private static final String URL_IP = "http://ip-api.com/json";
    private static final String URL_BGP_TMPL = "https://www.radb.net/query?advanced_query=" +
    "&keywords=%s&-T+option=&ip_option=&-i+option=";
    private static final String START_POS_SIG = "query-result query-result-external\"><code>";
    private static final String END_POS_SIG = "</code>";
    private static final String USER_AGENT = "user-agent";
    private static final String TIMEZONE = "timezone";
    private static final String DATETIME = "datetime";
    private static final String CLIENT_IP = "client_ip";
    private static final String COUNTRY = "country";
    private static final String REGION_NAME = "regionName";
    private static final String CITY = "city";
    private static final String ISP = "isp";
    private static final String AS = "as";
    private String timeZone;
    private String time;
    private String clientIp;
    private String country;
    private String regionName;
    private String city;
    private String isp;
    private String as;
    private String browser;
    private String bgpData;
    private String timestamp;
    
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AccountServices accountServices;
    
    @Override
    @Action(value = "/index", results = {@Result(location = "index.jsp", name = "success")})
    public String execute() {
        accountServices.getAccount().parallelStream().forEach( System.out::println );
        return SUCCESS;
    }
    
    
}