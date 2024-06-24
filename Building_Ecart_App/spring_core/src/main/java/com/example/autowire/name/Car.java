package com.example.autowire.name;

public class Car {
    private Specification specification;

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Car(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails(){
        System.out.println(specification.toString());
    }
}
