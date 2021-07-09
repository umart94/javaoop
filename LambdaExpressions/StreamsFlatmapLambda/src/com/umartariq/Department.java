package com.umartariq;

import java.util.ArrayList;
import java.util.List;

/**
 * Department.java created by umartariq on 30/10/2020
 * 1:08 PM inside the package - com.umartariq
 * in the java project StreamsFlatmapLambda using IDE IntelliJ IDEA
 */
public class Department {

    private String name;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
