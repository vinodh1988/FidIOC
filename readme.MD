# Spring IOC Demo Project and  Notes

##Topics
 [IOC Containers](#IOC-Containers)
 
### Inversion of Control

Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework. 

### Dependency Injection

Dependency Injection (DI) is a design pattern used to implement IoC. It allows the creation of dependent objects outside of a class and provides those objects to a class through different ways

## IOC Containers

Spring IoC container is  the core of the Spring Framework. The container will create the objects, wire them together, configure them, and manage their complete life cycle from creation till destruction. The Spring container uses dependency injection (DI) to manage the components that make up an application.

Spring provides following two types of containers.

1. BeanFactory container
2. ApplicationContext container