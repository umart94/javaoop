package com.umartariq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main.java created by umartariq on 27/10/2020
 * 7:45 PM inside the package - com.umartariq
 * in the java project NestedBlocksPart2 using IDE IntelliJ IDEA
 */

public class Main {
    public final static String doStringConcatenation(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }

    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();
        //use anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("printing from the anonymous runnable");
            }
        }).start();


        new Thread(() -> System.out.println("Printing from lambda expression runnable..")).start();

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
        Collections.sort(employees,
                (employee1,employee2) -> employee1.getName().compareTo(employee2.getName()));


        //Employee employee = somethingvalue
        //if we create employee variable outside a for loop, then it wont be final, and its value will change
        //only the for loop counter variable can be final in this case.

        //this is the difference.
        for(Employee employee : employees){
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
            //will run, but wont print in the same order.
            /*
            in this case, the employee object value does change
            and it is outside the lambda
            but we can still use and access it

            this is because in enhanced for each loop
            a local variable is created on each instance.
            on each iteration of the loop
            so for each iteration the loop counter variable will be FINAL AND EFFECTIVELY FINAL.

             */


        }



/*
Iterating over a collection, we can use lambda expression , iterable forEach method
evaluates each item in iterable collection.

Functional Programming
 */

        /*

         */
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
















//lamba expression - without code block
//UpperConcat uc = (String s1,String s2) -> s1.toUpperCase() + s2.toUpperCase();

        //lambda expressions with code block.

        UpperConcat uc = (String s1,String s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };


        String concatenatedString = doStringConcatenation(uc,employees.get(0).getName(), employees.get(1).getName());
        System.out.println(concatenatedString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        anotherClass.printValue();


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

class AnotherClass{
    public String doSomething(){

        /**************************** USING LAMBDA EXPRESSIONS  *******************************/
        int i = 0;
        i++;
        UpperConcat uc = (s1,s2) -> {
            System.out.println("The Lambda Expression class name is - " +getClass().getSimpleName());
         //   System.out.println("i in the lambda expressions = +" + i);
            //java: local variables referenced from a lambda expression must be final or effectively final
            //effectively final means that use final keyword, or never change its value ( increment decrement, math
            // operations etc.
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;

        };

      //  s1 = "Lamborghini Gallardo"; // we cannot do this,
        /*
        also , we cannot change the value of the lambda expressions parameters.

         */
//        int j=0;
//        {
//           String s1;
//           String s2;
//            System.out.println("The Lambda Expression class name is - " +getClass().getSimpleName());
//            System.out.println("i in the lambda expressions = +" + i);
//
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//
//            /*
//            the s1 and s2 parameters of the lambda expressions are not local
//            s1 and s2 will not be available outside the lambda expression block.
//
//            these also have to be final if we want to use them anywhere else.
//
//             */
//
//        }
        System.out.println("The AnotherClass class name is : " + getClass().getSimpleName());
        return Main.doStringConcatenation(uc,"Lamborghini Aventador\t","vs Bugatti Veyron");




        /**************************** USING LAMBDA EXPRESSIONS *******************************/



    }

    //to demonstrate using lambda expression parameters elsewhere, we create a different function.

    //we are using lambda for a runnable
    //when the code runs
    /*
    the thread sleeps for 5 seconds and prints value of number variable.
    the local variable will not exist at the
     */
    public void printValue(){
        int number = 29;
        /*
        until the thread is executing, we dont want the value of number to change
        because in a large scale application there will be huge number of threads
        and by the time the thread runs again after interrupting the value of variable will have changed.

        so we either must declare the variables to be final.
        or use something else for constantly changing variables.

        i.e method will finish executing , before the lambda actually runs.


         */
        Runnable r = () -> {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException exception){
            exception.printStackTrace();

        }
        System.out.println("The value is +" + number);
    };

        new Thread(r).start();
    }



}
