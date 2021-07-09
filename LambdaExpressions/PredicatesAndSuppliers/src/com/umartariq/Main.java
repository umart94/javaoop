package com.umartariq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Main.java created by umartariq on 28/10/2020
 * 11:53 AM inside the package - com.umartariq
 * in the java project PredicatesAndSuppliers using IDE IntelliJ IDEA
 */
public class Main {
    public final static String doStringConcatenation(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                            Predicate<Employee> ageCondition){


        System.out.println(ageText);

        /***********CHANGES TO THIS - USING PREDICATES ***************/
        for(Employee employee : employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName()+"\t"+employee.getAge());
            }
        }
        /***********CHANGES TO THIS - USING PREDICATES ***************/
    }

    public static void main(String[] args) {

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


        UpperConcat uc = (String s1,String s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        printEmployeesByAge(employees,"-----Employees Older than 30------",employee -> employee.getAge()>30);
        System.out.println("-------------------");
        printEmployeesByAge(employees,"\n------Employees Younger Than 30-------",employee -> employee.getAge()<=30);
        System.out.println("-------------------");
        printEmployeesByAge(employees, "\n------Employees Younger Than 25-------", new Predicate<Employee>() {
            //will return a boolean, we can do it this way if there are lots of conditions that we want to evaluate.

            @Override
            public boolean test(Employee employee) {
                return employee.getAge() <25;
            }
        });
        System.out.println("-------------------");
        /*
        IntPredicate:

        Interface IntPredicate
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

@FunctionalInterface
public interface IntPredicate
Represents a predicate (boolean-valued function) of one int-valued argument. This is the int-consuming primitive type specialization of Predicate.
This is a functional interface whose functional method is test(int).

         */

        //suppose we want to test a boolean condition, and print values, then what we wan do is use test function.


            IntPredicate intPredicategreaterThan4000 = i -> i>4000;
            System.out.println("4001 > 4000 ?? \t"+intPredicategreaterThan4000.test(4001));//true
            System.out.println("4000 > 4000 ?? \t"+intPredicategreaterThan4000.test(4000));//false
            System.out.println("3999 > 4000 ?? \t"+intPredicategreaterThan4000.test(3999));//false
            System.out.println("4567 > 4000 ?? \t"+intPredicategreaterThan4000.test(Integer.parseInt("4567")));//true
            int a = -321;
            System.out.println("4001 > 4000 ??\t"+intPredicategreaterThan4000.test(a+4322));
            //-321+4321=4000 , so with 4322 it is 4001, and gives true.

            IntPredicate intPredicatelessThan5000 = i -> i < 5000;
        System.out.println("4000<4999<5000 ?? \t"+intPredicategreaterThan4000.and(intPredicatelessThan5000).test(4999));
        System.out.println("4000<123456<5000 ?? \t"+intPredicategreaterThan4000.and(intPredicatelessThan5000).test(123456));
        //predicate interface contains or, negation and isequals method.

        Random randomObject = new Random();
        /*
        Supplier :
        Supplier always returns a value
        include return type
        use getMethod to get Object from a supplier.


        Interface Supplier<T>
Type Parameters:
T - the type of results supplied by this supplier
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.


Represents a supplier of results.
There is no requirement that a new or distinct result be returned each time the supplier is invoked.

This is a functional interface whose functional method is get().
         */
        Supplier<Integer> randomSupplier = () -> randomObject.nextInt(1000);
        for(int i=0;i<10;i++){
   //System.out.println(randomObject.nextInt(1000)); //when using Random class in java to generate 10 randon numbers
  System.out.println(randomSupplier.get()); //when using supplier, we use get method to return a distinct
            // result each time we invoke supplier through get method, so we just assign the random class object to
            // supplier method.
            /*
            boolean , double, int , long suppliers.
             */

        }

        




        
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
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;

        };
        System.out.println("The AnotherClass class name is : " + getClass().getSimpleName());
        return Main.doStringConcatenation(uc,"Lamborghini Aventador\t","vs Bugatti Veyron");
        /**************************** USING LAMBDA EXPRESSIONS *******************************/



    }
    public void printValue(){
        int number = 29;
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
