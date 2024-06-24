package com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCouplingExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("looseCoupling.xml");
        UserManager userManager = context.getBean("userManager",UserManager.class);
        System.out.println(userManager.getUserInfo());
    }
}
