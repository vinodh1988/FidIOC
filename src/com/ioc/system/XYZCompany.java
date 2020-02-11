package com.ioc.system;

import org.springframework.beans.factory.annotation.Autowired;

public class XYZCompany implements Company{

	private BusinessOperation branch;
	
	@Autowired
	private Process accounting;
	@Autowired
	private Process production;
	
	public XYZCompany(BusinessOperation branch) {
		super();
		System.out.println("Constructor called");
		this.branch = branch;
	}


	@Override
	public void establish(String name) {
		// TODO Auto-generated method stub
		System.out.println("Registed and Started "+name+" Company");
		branch.perform("Bengaluru");
		accounting.process("Second Quarter");
		production.process("Nuts and bolts");
	}

}
