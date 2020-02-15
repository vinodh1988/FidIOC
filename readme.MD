# Spring IOC Demo Project and  Notes

## Topics

* [IOC Containers](#IOC-Containers)
* [IOC Implementation](#Implementing-dependency-injection)
 
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
