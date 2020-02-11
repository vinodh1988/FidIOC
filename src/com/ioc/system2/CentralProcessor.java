package com.ioc.system2;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CentralProcessor implements BeanPostProcessor {

	@PostConstruct
	public void init()
	{
		System.out.println("Central Procesor instantiated");
	}
	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Created instance in Post Init"+arg0.hashCode());
		System.out.println("Bean Name"+arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Created instance"+arg0.hashCode());
		System.out.println("Bean Name"+arg1);
	
	
		return arg0; 
	}

}
