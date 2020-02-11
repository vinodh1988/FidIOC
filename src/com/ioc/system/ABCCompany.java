package com.ioc.system;

public class ABCCompany implements Company {

private BusinessOperation branch;
private BusinessOperation manufacturing;



public BusinessOperation getBranch() {
	return branch;
}



public void setBranch(BusinessOperation branch) {
	System.out.println("Branch is set");
	this.branch = branch;
}



public BusinessOperation getManufacturing() {
	return manufacturing;
}



public void setManufacturing(BusinessOperation manufacturing) {
	this.manufacturing = manufacturing;
}



	@Override
	public void establish(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" company is established");
		branch.perform("Chennai");
		manufacturing.perform("Tyre Manufacturing");
	}

}
