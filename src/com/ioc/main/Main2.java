package com.ioc.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ioc.system2.JavaConfig;
import com.ioc.system2.Project;

public class Main2 {
	public static void main(String n[]) throws InterruptedException {
		AbstractApplicationContext ac=new AnnotationConfigApplicationContext(
				JavaConfig.class);
 
		ac.registerShutdownHook();
		   Project p=(Project)ac.getBean("erp");
		   p.details();
		   Project x=p;
		   p=(Project)ac.getBean("mui");
		   p.details();
		   ac.close();
		   x.details();
		   System.gc();
		   
	}

}
