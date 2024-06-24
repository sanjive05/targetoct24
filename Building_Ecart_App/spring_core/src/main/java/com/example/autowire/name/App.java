package com.example.autowire.name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autoWireByName.xml");
        Car car = context.getBean("myCar", Car.class);
        car.displayDetails();
    }
}
