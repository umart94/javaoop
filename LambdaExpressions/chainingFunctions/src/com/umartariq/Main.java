package com.umartariq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.*;

/**
 * Main.java created by umartariq on 29/10/2020
 * 5:13 PM inside the package - com.umartariq
 * in the java project chainingFunctions using IDE IntelliJ IDEA
 */
public class Main {
    public final static String doStringConcatenation(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        /***********CHANGES TO THIS - USING PREDICATES ***************/
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + "\t" + employee.getAge());
            }
        }
        /***********CHANGES TO THIS - USING PREDICATES ***************/
    }

    public static void main(String[] args) throws IOException {
        List<Employee> employees = new ArrayList<Employee>();

        Employee Ahmed = new Employee("Muhammad Ahmed", 39);
        Employee Bilal = new Employee("Muhammad Bilal Umar", 38);
        Employee Daniyal = new Employee("Daniyal Mudassir", 36);
        Employee Farooq = new Employee("Farooq Ameen", 38);
        Employee Umar = new Employee("Muhammad Umar Tariq", 37);
        Employee Owais = new Employee("Owais Bin Abdul Rahman", 34);
        Employee Qasim = new Employee("Muhammad Qasim Rashid", 30);
        Employee Hamza = new Employee("Hamza Abdul Ghafoor", 27);
        Employee Saad = new Employee("Saad Waqas", 28);
        Employee Shoaib = new Employee("Muhammad Shoaib Akhtar", 26);
        Employee Ibraheem = new Employee("Ibraheem Zubair", 25);
        Employee Talha = new Employee("Talha Usman", 26);
        employees.add(Ahmed);
        employees.add(Bilal);
        employees.add(Daniyal);
        employees.add(Farooq);
        employees.add(Owais);
        employees.add(Qasim);
        employees.add(Hamza);
        employees.add(Saad);
        employees.add(Shoaib);
        employees.add(Ibraheem);
        employees.add(Talha);
        employees.add(Umar);


        Employee Amna = new Employee("Amna Ahmed", 29);
        Employee Asma = new Employee("Asma Abubakr", 28);
        Employee Bisma = new Employee("Bisma Aslam", 27);
        Employee Dua = new Employee("Dua Tahir", 26);
        Employee Fatima = new Employee("Fatima Muzzammil", 29);
        Employee Ghazala = new Employee("Ghazala Shahid", 28);
        Employee Hafsa = new Employee("Hafsa Umar", 27);
        Employee Hajra = new Employee("Hajra Asim", 26);
        Employee Iqra = new Employee("Iqra Waqar", 25);
        Employee Khadija = new Employee("Khadija Muhammad", 39);
        Employee Nadia = new Employee("Nadia Abdul Shakoor", 38);
        Employee Nasreen = new Employee("Nasreen Bint-e-Abdul Shakoor", 37);
        Employee Rida = new Employee("Rida Bint-e-Abdullah Saleem", 36);
        Employee Sara = new Employee("Sara Abdul Rahman", 35);
        Employee Sana = new Employee("Sana Abdullah", 34);
        Employee Sidra = new Employee("Sidra Bint-e-Abdul Shakoor", 33);
        Employee Shazia = new Employee("Shazia Bint-e-Abdul Shakoor", 32);
        Employee Tabeer = new Employee("Tabeer Tanveer", 31);
        Employee Umaima = new Employee("Umaima Bint-e- Abdul Rahman", 30);
        Employee Vardah = new Employee("Vardah Gul Ahmed", 29);
        Employee Wafa = new Employee("Wafa Binte Abdul Malik", 28);
        Employee Zaynab = new Employee("Zainab Saleem", 27);


        employees.add(Amna);
        employees.add(Asma);
        employees.add(Bisma);
        employees.add(Dua);
        employees.add(Fatima);
        employees.add(Ghazala);
        employees.add(Hafsa);
        employees.add(Hajra);
        employees.add(Iqra);
        employees.add(Khadija);
        employees.add(Nadia);
        employees.add(Nasreen);
        employees.add(Rida);
        employees.add(Sara);
        employees.add(Sana);
        employees.add(Sidra);
        employees.add(Shazia);
        employees.add(Tabeer);
        employees.add(Umaima);
        employees.add(Vardah);
        employees.add(Wafa);
        employees.add(Zaynab);


        /************    PREDICATE INTERFACE**********/


        Collections.sort(employees,
                (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        UpperConcat uc = (String s1, String s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        //   printEmployeesByAge(employees, "-----Employees Older than 30------", employee -> employee.getAge() > 30);
        //      System.out.println("-------------------");
        //   printEmployeesByAge(employees, "\n------Employees Younger Than 30-------",
        //           employee -> employee.getAge() <= 30);
        //     System.out.println("-------------------");
//       printEmployeesByAge(employees, "\n------Employees Younger Than 25-------", new Predicate<Employee>() {
//            //will return a boolean, we can do it this way if there are lots of conditions that we want to evaluate.
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
        //     System.out.println("-------------------");
        /************    PREDICATE INTERFACE**********/

        /************    SUPPLIER INTERFACE**********/
        Random randomObject = new Random();
        Supplier<Integer> randomSupplier = () -> randomObject.nextInt(1000);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Supplier - Random Number("+(i+1)+")==\t"+randomSupplier.get());
//
//        }

//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ')+1);
//            System.out.println("Last Name is: "+lastName);
//        });

/************    SUPPLIER INTERFACE**********/


        /************    FUNCTION INTERFACE**********/
        //Consumer - Does not Return a value
        //Supplier returns a value, but does not accept parameters
        //predicate returns either true or false

        /*
        to pass in a value, and then perform some operation
        we need to use functional interface.

        Function<>
Represents a function that accepts one argument and produces a result.

Type Parameters:
T - the type of the input to the function
R - the type of the result of the function
All Known Subinterfaces:
UnaryOperator<T>
Functional Interface:
This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
@FunctionalInterface
public interface Function<T,​R>
Represents a function that accepts one argument and produces a result.
This is a functional interface whose functional method is apply(Object).




we want to pass a string, and perform operation, and then return string
limitation is that we can only use 1 value as parameter
         */

        Function<Employee, String> getFirstNameThroughFunctionalInterface = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' ')).toUpperCase();
        };
        Function<Employee, String> getLastNameThroughFunctionalInterface = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1).toUpperCase();
        };

        String firstNameFunctional = getFirstNameThroughFunctionalInterface.apply(employees.get(2));
        //     System.out.println("First Name of Employee # 2 In List - retrieved through Function Interface, is== " +
        //     firstNameFunctional);

        String lastNameFunctional = getLastNameThroughFunctionalInterface.apply(employees.get(2));
        //    System.out.println("Last Name Of Employee # 2 in List - retrieved through Function Interface, is== " +
        //    lastNameFunctional);

        //we get only 1 value this way
        //we need to get any number of values we want, so we would have to create a function for this
        //pass in the functional interface and object we create with the condition
        //and then use the conditions in the function to return the values.

        System.out.println("------------- FIRST NAMES OF EMPLOYEES ---------------");
        for (Employee employee : employees) {
            System.out.println("FIRSTNAME OF EMPLOYEE #(" + (employees.indexOf(employee) + 1) + ")\t" + getAName(getFirstNameThroughFunctionalInterface, employee));
        }
        System.out.println("------------- LAST NAMES OF EMPLOYEES ---------------");
        for (Employee employee : employees) {
            System.out.println("LASTNAME OF EMPLOYEE #(" + (employees.indexOf(employee) + 1) + ")\t" + getAName(getLastNameThroughFunctionalInterface, employee));
        }
        System.out.println("RETRIEVING NAMES RANDOMLY FROM LIST....");

        //This will return firstname or lastname randomly, depending on what is returned by random object.
        //so sometimes the if block will run
        //sometimes the else block will run
        Random randomObjectForFunctionalInterface = new Random();
        for (Employee employee : employees) {
            if (randomObjectForFunctionalInterface.nextBoolean()) {
                System.out.println("FIRSTNAME OF EMPLOYEE #(" + (employees.indexOf(employee) + 1) + ")\t" + getAName(getFirstNameThroughFunctionalInterface, employee));

            } else {
                System.out.println("LASTNAME OF EMPLOYEE #(" + (employees.indexOf(employee) + 1) + ")\t" + getAName(getLastNameThroughFunctionalInterface, employee));

            }
        }


/************    FUNCTION INTERFACE**********/

    /*
    long to int function - accepts long variable, returns int variable.
    int to double function

    we can also chain functions together
    use andthen method

    that method takes function as a parameter.

     */


        /*************** CHAINING JAVA FUNCTIONS TOGETHER ****************************/
    Function<Employee,String> upperCase = employee -> employee.getName().toUpperCase();
  //  when this function returns a value, we want to operate on that value () -> again
   //             so we will use and then method and use the second function inside that method.

        /*
        return value of each function is thus, operated on by the next function in the chain :
         */
        Function<Employee,String> EmployeeNameToFullNameStringValueInUpperCase =
                employee -> employee.getName().toUpperCase();
        Function<String,String> firstNameFunction = name -> name.substring(0,name.indexOf(' '));
       // Function<String,String> chainedconcatenatedFunction = upperCase.andThen(firstNameFunction); this will give
        // error
        //this is because, when chaining, we wont be specifying the data types at the end
        //because here the chaining ends
        //so we only use function class
        //we can do this n number of times, but at the end, we wont specify <> data types in template class.

        Function chainedFunction = upperCase.andThen(firstNameFunction);

        for(Employee employee : employees){
            System.out.println("UPPERCASE FIRST NAME employee#("+ employees.indexOf(employee)+")\t== "+chainedFunction
                    .apply(employee));
        }


        /*
        since a bi function only has 2 arguments, it cannot be used to chain more functions
        i.e , it will only work with 2 functions.
         */
        BiFunction<String,Employee,String> concatAge = (String name, Employee employee) -> {
            return name.concat(""+employee.getAge());
        };



        for(Employee employee : employees) {
            String upperName = upperCase.apply(employees.get(employees.indexOf(employee)))+"\t";
            System.out.println("\t"+concatAge.apply(upperName,
                    employee));
        }




        /*************** CHAINING JAVA FUNCTIONS TOGETHER ****************************/

        //we can also use unary operators

        IntUnaryOperator incrementBy5 = i -> i+5;
        System.out.println(incrementBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World");
        //THE RESULT of uppercase will be lost, no advantage to chain consumers.

        












    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

