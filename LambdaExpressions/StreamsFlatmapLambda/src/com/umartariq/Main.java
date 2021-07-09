package com.umartariq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main.java created by umartariq on 30/10/2020
 * 12:20 PM inside the package - com.umartariq
 * in the java project StreamsFlatmapLambda using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        List<String> bingoCodesList = Arrays.asList("B40","B36","B12","B6","O53","O49","O60","O50","N12","N34","N56",
                "N26","N48","G23","G34","G56","G56","I12","I35","I45","I67","I05","I23","I12","B10","G45","O58");
        List<String> bingoCodesSingleLetter = new ArrayList<>();
        bingoCodesList.forEach(number -> {
            if(number.toUpperCase().startsWith("O")){
                bingoCodesSingleLetter.add(number);
                 //System.out.println(number);
            }
        });
        bingoCodesSingleLetter.sort((String s1,String s2) -> s1.compareToIgnoreCase(s2));
        bingoCodesSingleLetter.forEach((String bingoCodestartingWithSingleLetter) -> {
       //          System.out.println(bingoCodestartingWithSingleLetter);
        });
        Stream<String> onlyIandONumberStream = Stream.of("I12","I34","I56","I78","O98","O76","O54",
                "O32");// 8 numbers
        Stream<String> onlyIAndNNumberStream = Stream.of("N12","N34","N56","N78","I12","I34","I78","I56");//8 numbers
        Stream<String> concatStream = Stream.concat(onlyIandONumberStream,onlyIAndNNumberStream);
        System.out.println("-------------------------------------");

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


        Employee Amna = new Employee("Amna Ahmed", 30);
        Employee Asma = new Employee("Asma Abubakr", 30);
        Employee Bisma = new Employee("Bisma Aslam", 30);
        Employee Dua = new Employee("Dua Tahir", 26);
        Employee Fatima = new Employee("Fatima Muzzammil", 26);
        Employee Ghazala = new Employee("Ghazala Shahid", 26);
        Employee Hafsa = new Employee("Hafsa Umar", 27);
        Employee Hajra = new Employee("Hajra Asim", 27);
        Employee Iqra = new Employee("Iqra Waqar", 27);
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

        Department Engineering =new Department("Engineering");
        Engineering.addEmployee(Ahmed);
        Engineering.addEmployee(Bilal);
        Engineering.addEmployee(Daniyal);
        Engineering.addEmployee(Amna);
        Engineering.addEmployee(Asma);
        Engineering.addEmployee(Bisma);
        Department InformationTechnology = new Department("InformationTechnology");
        InformationTechnology.addEmployee(Dua);
        InformationTechnology.addEmployee(Fatima);
        InformationTechnology.addEmployee(Ghazala);
        InformationTechnology.addEmployee(Hafsa);
        InformationTechnology.addEmployee(Hajra);
        InformationTechnology.addEmployee(Farooq);
        InformationTechnology.addEmployee(Owais);
        InformationTechnology.addEmployee(Qasim);
        InformationTechnology.addEmployee(Hamza);

        Department Cybersecurity = new Department("Cybersecurity");
        Cybersecurity.addEmployee(Iqra);
        Cybersecurity.addEmployee(Khadija);
        Cybersecurity.addEmployee(Nadia);
        Cybersecurity.addEmployee(Nasreen);
        Cybersecurity.addEmployee(Rida);
        Cybersecurity.addEmployee(Sara);
        Cybersecurity.addEmployee(Sana);
        Cybersecurity.addEmployee(Sidra);
        Cybersecurity.addEmployee(Shazia);
        Cybersecurity.addEmployee(Tabeer);
        Cybersecurity.addEmployee(Umaima);
        Cybersecurity.addEmployee(Vardah);
        Cybersecurity.addEmployee(Wafa);
        Cybersecurity.addEmployee(Zaynab);
        Cybersecurity.addEmployee(Saad);
        Cybersecurity.addEmployee(Shoaib);
        Cybersecurity.addEmployee(Ibraheem);
        Cybersecurity.addEmployee(Talha);
        Cybersecurity.addEmployee(Umar);

        /*
        print all the employee information :
         */

        List<Department> departments = new ArrayList<>();
        departments.add(Engineering);
        departments.add(InformationTechnology);
        departments.add(Cybersecurity);

    //    departments.stream().flatMap(department -> department.getEmployees().stream()).forEach(System.out::println);
        /*
        use collect method
        store contents of stream into a list
        then print items in a list
         */
//        System.out.println("---------------");
//        List<String> sortedONumbers = bingoCodesList.stream()
//                .map(String::toUpperCase).filter(s -> s.startsWith("O")).sorted()
//                .collect(Collectors.toList());


        System.out.println("---------------");
        List<String> sortedONumbers = bingoCodesList.stream()
                .map(String::toUpperCase).filter(s -> s.startsWith("O")).sorted()
                .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
        /*
        pass new when we want to call constructor
         */

        for(String s: sortedONumbers){
       //     System.out.println(s);
        }

        /*
        using collectors.groupingby method
        what we can do is if there are lots of employees with the same age,
        then we can map them together
         */

        Map<Integer,List<Employee>> groupedByAge =
                departments.stream().flatMap(department -> department.getEmployees()
                        .stream()).collect(Collectors.groupingBy(employee -> employee.getAge()));

       // System.out.println(groupedByAge.toString());

        groupedByAge.entrySet().forEach(entry->{
            //System.out.println(entry.getKey() + " " + entry.getValue());
         //   System.out.println("Employees of Age ("+entry.getKey()+") are  "+entry.getValue().toString());
          //  System.out.println("\n");
        });

        /*
        Q: use streams to find the youngest employee in the company
        Q: use streams to find the eldest employee in the company
         */

        departments.stream().flatMap(department -> department.getEmployees().stream()).reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1 : e2 ).ifPresent(System.out::println);
        departments.stream().flatMap(department -> department.getEmployees().stream()).reduce((e1,e2) -> e1.getAge() > e2.getAge() ? e1 : e2 ).ifPresent(System.out::println);

        /*
        we cannot reuse a stream after we have used it in 1 operation / statement
        operations in streams are lazily evaluated.
        intermediate operations are not performed until theres a terminal operation
        int streams, double streams
        some,min,max methods etc.
        parallel streams - used when we want to increase performance when executing streams in parallel.

         */

        /*
        nothing happens until there is a terminal operation

         */
        Stream.of("ABC","ACX","BXW","ASDF","GHJK","ST").filter(s -> {
            if(s.length()<=3) {
                System.out.println(s);
            }
            return s.length() == 2;
        }).count();



    }
}
