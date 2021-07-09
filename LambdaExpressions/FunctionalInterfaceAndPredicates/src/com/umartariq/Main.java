package com.umartariq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Main.java created by umartariq on 27/10/2020
 * 8:10 PM inside the package - com.umartariq
 * in the java project FunctionalInterfaceAndPredicates using IDE IntelliJ IDEA
 */

    /*
    functional interfaces are used with lambda expressions
    represent structure of lambda expressions

     */
public class Main {
    public final static String doStringConcatenation(UpperConcat uc,String s1,String s2){
            return uc.upperAndConcat(s1,s2);
        }

        private static void printEmployeesByAge(List<Employee> employees,String ageText,
                                                Predicate<Employee> ageCondition){

            //forEach - expects a Consumer
            // we have to use the enhanced for loop - so we can use predicate interface.
            System.out.println(ageText);

            /***********THIS - USES CONSUMER INTERFACE*****************/
//            employees.forEach(employee ->{
//                if(employee.getAge()<=30){
//                    System.out.println("Employees Older than 30 are : "+employee.getName()+"\t"+employee.getAge());
//                }
//            });
            /***********THIS - USES CONSUMER INTERFACE****************/

            /***********CHANGES TO THIS - USING PREDICATES ***************/
            for(Employee employee : employees){
                if(ageCondition.test(employee)){
                    System.out.println(employee.getName()+"\t"+employee.getAge());
                }
            }


            /***********CHANGES TO THIS - USING PREDICATES ***************/
        }

        public static void main(String[] args) {
   //         new Thread(new CodeToRun()).start();
            //use anonymous class
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("printing from the anonymous runnable");
//                }
//            }).start();
//
//
//            new Thread(() -> System.out.println("Printing from lambda expression runnable..")).start();
//
//            new Thread(() -> {
//                System.out.println("Printing from lambda expression runnable..");
//                System.out.println("Printing from lambda expression runnable.. line2");
//                System.out.println("Printing from lambda expression runnable.. line3");
//            }).start();


            Employee alice = new Employee("Alice",39);
            Employee bugs = new Employee("Bugs Bunny ",38);
            Employee umar = new Employee("Muhammad Umar Tariq",37);
            Employee tomcat = new Employee("Thomas The Cat",36);
            Employee jerry = new Employee("Jerry Mouse",38);
            Employee lola = new Employee("Lola Bunny",35);
            Employee daffy = new Employee("Daffy Duck",34);
            Employee tinarusso = new Employee("Tina Russo Duck",33);
            Employee icebear = new Employee("Ice Bear",20);
            Employee panda = new Employee("Panda",29);
            Employee grizz = new Employee("Grizzly Bear",28);


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
//            for(Employee employee : employees){
//                System.out.println(employee.getName());
//                new Thread(() -> System.out.println(employee.getAge())).start();
//                //will run, but wont print in the same order.
//            /*
//            in this case, the employee object value does change
//            and it is outside the lambda
//            but we can still use and access it
//
//            this is because in enhanced for each loop
//            a local variable is created on each instance.
//            on each iteration of the loop
//            so for each iteration the loop counter variable will be FINAL AND EFFECTIVELY FINAL.
//
//             */
//
//
//            }



/*
Iterating over a collection, we can use lambda expression , iterable forEach method
evaluates each item in iterable collection.

Functional Programming
 */

            /*
            the method forEach is looking for a parameter
             */
//            employees.forEach(employee -> {
//                System.out.println(employee.getName());
//                System.out.println(employee.getAge());
//            });
     /*       java.lang.Iterable<T> public void forEach(java.util.function.Consumer<? super T> action)
            Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception. Unless otherwise specified by the implementing class, actions are performed in the order of iteration (if an iteration order is specified). Exceptions thrown by the action are relayed to the caller.

            Params:
            action – The action to be performed for each element
            Throws:
            NullPointerException – if the specified action is null
            Implementation Requirements:
            The default implementation behaves as if:

            for (T t : this)
                action.accept(t);

                java.util.function
Interface Consumer<T>
Type Parameters:
T - the type of the input to the operation
All Known Subinterfaces:
Stream.Builder<T>
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

@FunctionalInterface
public interface Consumer<T>
Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
This is a functional interface whose functional method is accept(Object).





void	accept(T t)
Performs this operation on the given argument.
default Consumer<T>	andThen(Consumer<? super T> after)
Returns a composed Consumer that performs, in sequence, this operation followed by the after operation.

The Consumer interface has one method that needs to be implemented so its a functional interface
and lambdas can map to it

the accept method performs the operation on a given argument

we are not calling accept
we are calling forEach

forEach internally calls accept ( java code )
and that returns void

we pass forEach a lambda expression
a Consumer expects 1 argument and performs an action that does not return a value

Object in , and return type is void.

helps in printing out values.

the lambda takes an employee object and does not return anything
this matches consumer
forEach method iterates over list
calls accept method of consumer and passes employee object
accept method evaluates the lambda expression using passed employee object as argument.

java.util contains over 30 functional interfaces.



                */


//            for(Employee employee : employees){
//                if(employee.getAge() > 30){
//                    System.out.println(employee.getName()+"\t"+employee.getAge());
//                }
//            }

            //using lambda expressions.
//            employees.forEach(employee ->{
//                if(employee.getAge()>30){
//                    System.out.println("Employees Older than 30 are : "+employee.getName()+"\t"+employee.getAge());
//                }
//            });

//            employees.forEach(employee ->{
//                if(employee.getAge()<=30){
//                    System.out.println("Employees Younger than 30 are : "+employee.getName()+"\t"+employee.getAge());
//                }
//            });

            //we can use a boolean, pass it into a function, and that will work for two cases :

            /*
            1. for eg. true - if greater than 30
            2. false - less than 30

            done by using java predicate interface.
            test method is the functional method - that we will use - accepts a boolean - accepts a predicate
            that returns a boolean value.

            we can replace the if condition with a predicate.

             */











//lamba expression - without code block
//UpperConcat uc = (String s1,String s2) -> s1.toUpperCase() + s2.toUpperCase();

            //lambda expressions with code block.

            UpperConcat uc = (String s1,String s2) -> {
                String result = s1.toUpperCase() + s2.toUpperCase();
                return result;
            };


//            String concatenatedString = doStringConcatenation(uc,employees.get(0).getName(), employees.get(1).getName());
//            System.out.println(concatenatedString);

//            AnotherClass anotherClass = new AnotherClass();
//            String s = anotherClass.doSomething();
//            System.out.println(s);
//
//            anotherClass.printValue();
//




            /*
            here, we are using the predicate interface in java, and this function will accept 3 things :
            List<Employee> employees,String ageText,Predicate<Employee> ageCondition
            ageText is just a prompt.
            the collection is necessary and the predicate is like a boolean variable, that will evaluate to either
            true or false

            inside the function, we must use Enhanced for loop
            so, remember that :

            1. forEach loop , expects a Consumer Interface
            2. Enhanced for loop, predicate interface.
             */

            printEmployeesByAge(employees,"-----Employees Older than 30------",employee -> employee.getAge()>30);
            System.out.println("-------------------");
            printEmployeesByAge(employees,"\n------Employees Younger Than 30-------",employee -> employee.getAge()<=30);
            System.out.println("-------------------");

        }


    }

    class CodeToRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Printing from the runnable");
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
