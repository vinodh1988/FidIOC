package com.ioc.system;

import org.springframework.stereotype.Component;

@Component
public class Production implements Process {

	@Override
	public void process(String name) {
		// TODO Auto-generated method stub
        System.out.println("Producing "+ name);
	}

}
