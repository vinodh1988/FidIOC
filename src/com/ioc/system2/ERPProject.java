package com.ioc.system2;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ioc.events.MyEventPublisher;


public class ERPProject implements Project, InitializingBean,DisposableBean {
@Autowired
   MyEventPublisher publish;

	public ERPProject()
	{
		System.out.println("ERP Project instantiated");
		System.out.println(hashCode());
	}
	
	@Override
	public void details() {
		// TODO Auto-generated method stub
       System.out.println("ERP Project Started");
       publish.publish("ERP PROJECT DATA");
       
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After Properties Set");
	}
	
	@PreDestroy
	    public void doTask() {
		System.out.println("Destruction Task");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Finalization Task");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Object Destroyed");
	}
	
	

}
