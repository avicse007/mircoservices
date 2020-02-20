package com.avinash;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	//Value with default value 
	@Value("${my.greeting}")
	private String greet;
	
	//Value as list 
	@Value("${my.list}")
	private List<String> mylist;
	
	//value as map using Spring expression language SpEl
	@Value("#{${dbValues}}")
	private Map<String,String> dbValues;
	
	//use of ConfigurationProperties
	@Autowired
	private DBConnection dbConnection;
	
	@Autowired
	private LocalServiceBean localserviceBean;
	
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/greeting")
	public String greet() {
		 
		String env_bean = localserviceBean.getService()==null ? localserviceBean.getService1(): localserviceBean.getService();
		
		return greet + " Welcome My list value "+mylist +" My map value "+dbValues
				+dbConnection.getConnection()+" "+dbConnection.getPort() +" bean_env"+env_bean;
	}
	
	
	@RequestMapping("/getEnvDetails")
	public String getEnvDetails() {
		return env.toString();
	}
	
}
