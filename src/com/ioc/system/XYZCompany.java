package com.ioc.system;

public class XYZCompany implements Company{

	private BusinessOperation branch;
	
	
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
	}

}
