package com.library.models;

public abstract class Person {
    //instance variables:
    private String name;

    //constructor:
    public Person(String name) {
        this.name = name;
    }

    //getter and setter methods:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //abstract method:
    public abstract void who();
}
