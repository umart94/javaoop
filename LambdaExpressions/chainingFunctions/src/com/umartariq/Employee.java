package com.umartariq;

/**
 * Employee.java created by umartariq on 29/10/2020
 * 5:13 PM inside the package - com.umartariq
 * in the java project chainingFunctions using IDE IntelliJ IDEA
 */
public class Employee{
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}