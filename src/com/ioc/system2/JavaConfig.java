package com.ioc.system2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.ioc.system2","com.ioc.events"})
public class JavaConfig {

	  @Bean(name="erp")
	  public Project getPro() {
		  return new ERPProject();
	  }
	  
	  @Bean(name="mui")
	  public Project getPro2() {
		  return new MobileUI();
	  }
}
