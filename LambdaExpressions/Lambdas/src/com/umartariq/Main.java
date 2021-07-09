package com.umartariq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Main.java created by umartariq on 26/09/2020
 * 11:10 AM inside the package - com.umartariq
 * in the java project Lambdas using IDE IntelliJ IDEA
 */
public class Main {

    //Lambda Expressions Introduced in Java 8
    /*
    provide easier way to work with interfaces that only have 1 method.

     */
    public final static String doStringConcatenation(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }

    public static void main(String[] args) {

        //we can either do this or
        new Thread(new CodeToRun()).start();
        //use anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("printing from the anonymous runnable");
            }
        }).start();

        /******lambda expression*********/
        //lambda expressions have 3 parts, argument list, arrow token and thirdly the body.

        new Thread(() -> System.out.println("Printing from lambda expression runnable..")).start();
        /*
        thread constructors expects runnable
        it has only 1 method called run that has no parameters
        compiler matches lambda expression with the run method

        so lambda expressions can only work with functional interfaces that only contain 1 method to be implemented
        that will be matched with lambda expression.

        to use multiple statements , just use 1 curly brace.
         */

        new Thread(() -> {
            System.out.println("Printing from lambda expression runnable..");
            System.out.println("Printing from lambda expression runnable.. line2");
            System.out.println("Printing from lambda expression runnable.. line3");
        }).start();


        Employee alice = new Employee("Alice",20);
        Employee bugs = new Employee("Bugs Bunny ",21);
        Employee umar = new Employee("Muhammad Umar Tariq",26);
        Employee tomcat = new Employee("Thomas The Cat",27);
        Employee jerry = new Employee("Jerry Mouse",28);
        Employee lola = new Employee("Lola Bunny",30);
        Employee daffy = new Employee("Daffy Duck",25);
        Employee tinarusso = new Employee("Tina Russo Duck",25);
        Employee icebear = new Employee("Ice Bear",22);
        Employee panda = new Employee("Panda",23);
        Employee grizz = new Employee("Grizzly Bear",24);


        List<Employee> employees = new ArrayList<Employee>();
        employees.add(alice);
        employees.add(umar);
        employees.add(tomcat);
        employees.add(jerry);
        employees.add(bugs);
        employees.add(lola);
        employees.add(daffy);
        employees.add(tinarusso);
        employees.add(icebear);
        employees.add(panda);
        employees.add(grizz);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
//
//        for(Employee employee : employees){
//            //System.out.println(employee.getName());
//        }
//
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                //return employee1.getAge().compareTo(employee2.getAge()); works when i use Integer class, and
//                // compares in ascending order.
//
//                //return employee2.getAge() - employee1.getAge(); //descending order of age
//
//                return ((Integer)employee1.getAge()).compareTo(employee2.getAge()); //ascending order.
//
//            }
//        });
//
//        for(Employee employee : employees){
//            System.out.println(employee.getAge());
//        }
//

        //argument list is employee objects
        //arrow token
        //third part is the body, compareTo function
        //
     //   Collections.sort(employees,
       //         (Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));

        //compiler can infer from first parameter what are object types
        //we can delete the types.

        Collections.sort(employees,
                (employee1,employee2) -> employee1.getName().compareTo(employee2.getName()));


        for(Employee employee : employees){
          System.out.println(employee.getName());
        }
        /******lambda expression*********/

        String concatenatedString = doStringConcatenation(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() +"\t"+ s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(concatenatedString);


        //UpperConcat uc = (s1,s2) -> s1.toUpperCase() + s2.toUpperCase();
        UpperConcat uc = (String s1,String s2) -> s1.toUpperCase() + s2.toUpperCase();
        //return keyword would return a compiler error..
        //single return value is implied here.
        //we dont need to explicitly add a return statement.
        //we can remove the data types from inputs
        concatenatedString = doStringConcatenation(uc,employees.get(0).getName(), employees.get(1).getName());
    }


}

class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}

class Employee{
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

interface UpperConcat {
    public String upperAndConcat(String s1,String s2);
}