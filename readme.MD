# Spring IOC Demo Project and  Notes

## Topics

* [IOC Containers](#IOC-Containers)
* [IOC Implementation](#Implementing-dependency-injection)
* [XML Configuration](#XML-Configuration)
	* [Constructor Injection](#Constructor-Injection)
	* [Setter Injection](#Setter-Injection)
	* [Spring Bean Scopes](#Spring-bean-scopes)
* [Annotation and XML Configuration](#Annotation-and-XML-Configuration)
	*[Autowiring Modes](#Autowiring-modes)
	*[Stereotypes](#Stereotypes)

* [Java Configuration](Java-Configuration)
 
### Inversion of Control

Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework. 

### Dependency Injection

Dependency Injection (DI) is a design pattern used to implement IoC. It allows the creation of dependent objects outside of a class and provides those objects to a class through different ways

## IOC Containers

Spring IoC container is  the core of the Spring Framework. The container will create the objects, wire them together, configure them, and manage their complete life cycle from creation till destruction. The Spring container uses dependency injection (DI) to manage the components that make up an application.

Spring provides following two types of containers.

1. BeanFactory container
2. ApplicationContext container

    ## 1. Bean Factory

 The BeanFactory is the actual container which instantiates, configures, and manages a number of beans. These beans typically collaborate with one another, and thus have dependencies between themselves. These dependencies are reflected in the configuration data used by the BeanFactory (although some dependencies may not be visible as configuration data, but rather be a function of programmatic interactions between beans at runtime).

A BeanFactory is represented by the interface org.springframework.beans.factory.BeanFactory, for which there are multiple implementations. The most commonly used simple BeanFactory implementation is org.springframework.beans.factory.xml.XmlBeanFactory. (This should be qualified with the reminder that ApplicationContexts are a subclass of BeanFactory, and most users end up using XML variants of ApplicationContext).

Although for most scenarios, almost all user code managed by the BeanFactory does not have to be aware of the BeanFactory, the BeanFactory does have to be instantiated somehow. This can happen via explicit user code such as:

``` BeanFactory creation from xml configuration
Resource res = new FileSystemResource("beans.xml");
XmlBeanFactory factory = new XmlBeanFactory(res);
```

  ## 2. ApplicationContext

ApplicationContext container adds more enterprise-specific functionality such as the ability to resolve textual messages from a properties file and the ability to publish application events to interested event listeners. This container is defined by the org.springframework.context.ApplicationContext interface.

The ApplicationContext container includes all functionality of the BeanFactory container, so it is generally recommended over the BeanFactory. BeanFactory can still be used for lightweight applications like mobile devices or applet based applications where data volume and speed is significant.

#### Types of ApplicationContext
The most commonly used ApplicationContext implementations are:

* #### FileSystemXmlApplicationContext 
 This container loads the definitions of the beans from an XML file.Here you need to provide the full path of the XML bean configuration file to the constructor.
* #### ClassPathXmlApplicationContext 
This container loads the definitions of the beans from an XML file. Here you do not need to provide the full path of the XML file but you need to set CLASSPATH properly because this container will look bean configuration XML file in CLASSPATH.
* #### WebXmlApplicationContext 
This container loads the XML file with definitions of all beans from within a web application.

## Implementing Dependency Injection

Using Spring Framework, Dependency Injection can be implemented in following ways
    
* XML Configuration
* XML and Annotation Configuration
* Java and Annotation Configuration

### XML Configuration

 In XML Configuration we need to create a bean configuration xml file as follows

 ```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-cache-4.1.xsd 
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd
">

<bean id="abc" class="com.ioc.system.ABCCompany" ></bean>
<bean id="xyz" class="com.ioc.system.XYZCompany" ></bean>

</beans>

 ```

 Creating Application Context, By using the xml file we can create Application Context using _ClasspathXMLApplicationContext_

and we can get the object by using getBean Method

```
ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	    Company company=(Company) ac.getBean("abc");

```

Dependency Injection in XML Configuration can be implemented in two ways

1. Constructor Injection
1. Setter Injection

#### Constructor Injection

Constructor Injection is implemented in the following way

```
public class XYZCompany implements Company{

	private BusinessOperation branch;

    	
	public XYZCompany(BusinessOperation branch) {
		super();
		System.out.println("Constructor called");
		this.branch = branch;
	}

    ---
    ---
    ---
}
```

  And in the xml Configuration file, configure the constructor parameter as follows

  ```
  <bean id="xyz" class="com.ioc.system.XYZCompany">
     <constructor-arg name="branch" ref="b"></constructor-arg>
</bean>
```

#### Setter Injection

  In the class, Added getters and Setter for the properties which you want to configure and inject

```

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

---
---
---
---
}
```

 Configure the properties in xml configuration as follows

```
<bean id="abc" class="com.ioc.system.ABCCompany">
     <property name="branch" ref="b"></property>
     <property name="manufacturing" ref="m"></property>
</bean>
```

#### Differences between constructor vs Setter injection

![Constructor vs Setter Inject](https://funny-bucket.s3.ap-south-1.amazonaws.com/constructor.jpg)

#### Spring Bean Scopes

Spring Bean Scopes allows us to have more granular control of the bean instances creation. Sometimes we want to create bean instance as singleton but in some other cases we might want it to be created on every request or once in a session.

![Bean Scopes](https://funny-bucket.s3.ap-south-1.amazonaws.com/bean-scopes.gif)

#### Annotation and XML Configuration

In Spring framework, declaring bean dependencies in configuration files is a good practice to follow, so the Spring container is able to autowire relationships between collaborating beans. This means that it is possible to automatically let Spring resolve collaborators (other beans) for your beans by inspecting the contents of the BeanFactory. This is called spring bean autowiring.

#### Autowiring Modes

   Autowiring happens in following ways

![Autowiring Modes](https://funny-bucket.s3.ap-south-1.amazonaws.com/Capture.PNG)

##### Autowiring by Name

  Use Autowired annotation as used in the following class

```
public class XYZCompany implements Company{

	private BusinessOperation branch;
	
	@Autowired
	private Process accounting;
	@Autowired
	private Process production;

    ---
    ---
    ---
}
```

Create a class with Stereotype as follows

```
@Component("accounting")
public class Accounting implements Process {

	@Override
	public void process(String name) {
		// TODO Auto-generated method stub
		System.out.println("Managing Accounts "+name);
	}

}
```

Based on the name of the reference variable _account_ , Accounting class get Autowired.

For the Autowiring to work in XML Configuration, Add the following lines in XML file

```
<context:annotation-config></context:annotation-config>
<context:component-scan base-package="com.ioc.system"></context:component-scan>
```

### Stereotypes

  For Autowiring by name or type to happen,We should have stereotyped
  the classes with any othe following Stereotypes

  ![Stereotypes](https://funny-bucket.s3.ap-south-1.amazonaws.com/stereotype.png)

## Java Configuration

 To Implement IOC in Java Configuration, We need to create a java Configuration class
 annotated with @Configuration and Component scan need to be configured

 ```
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
```

And the application Context is created in the following way

```

AbstractApplicationContext ac=new AnnotationConfigApplicationContext(
				JavaConfig.class);

```
