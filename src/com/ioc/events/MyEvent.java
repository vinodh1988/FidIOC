package com.ioc.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class MyEvent  extends ApplicationEvent{

	public MyEvent(Object source) {
		super(source);
		
		System.out.println("Processing..!!!"+source);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
	    return "My Event has occured"+ this.source;
	}

}

/*
     class A{public String toString(){return "hello"}}
     A obj=new A();
     System.out.println(obj);  //defaul A@hashcode
                               //Every class in java is sub class of object class
                                * 
                                * 0bject class has a method toString
                                * when you print a reference it calls toString
                                * toString method default definition
                                * is it prints hashCode
                   
                                */

