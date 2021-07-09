package com.umartariq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main.java created by umartariq on 27/10/2020
 * 7:01 PM inside the package - com.umartariq
 * in the java project NestedBlocks using IDE IntelliJ IDEA
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


        for(Employee employee : employees){
        System.out.println(employee.getName());
        }

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

        /*
        when we create an instance, and use Anonymous class and use getClass..getSimpleName() inside a function,
        Next up,  is the code When we are using anonymous classes
        return Main.doStringConcatenation(new UpperConcat() {
        at this new UpperConcat object creation,

        anonymous class does not give us the name of the class.. so now we recode it using lambda expressions
         and   use         Instance classes and see the difference.

         */

        /**********    ANONYMOUS JAVA   CLASS *******/


       /* System.out.println("AnotherClass - class name is : "+getClass().getSimpleName());
        return Main.doStringConcatenation(new UpperConcat() {
        //anonymous class does not give us a name
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class name is : "+ getClass().getSimpleName());
                return s1.toUpperCase()+ s2.toUpperCase();
            }
        }, "Muhammad Umar Tariq   ","   coding in IntelliJ Idea. ");
*/
        /**********    ANONYMOUS JAVA  CLASS *******/

        /*
       Lambda Expressions with Java Instance Classes :

         */
        /**********     LAMBDA EXPRESSIONS WITH JAVA INSTANCE CLASS *******/

        /*
        The lambda expression (s1,s2) is treated as a nested block of code and shows the same class name
        as the parent class in which this lambda expression was created and called and used.

        it has the same scope as the nested block of code in which its used.
         */



   /*     UpperConcat uc = (s1,s2) -> {
            System.out.println("The lambda expression class is "+ getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass - class name is : "+getClass().getSimpleName());
        return Main.doStringConcatenation(uc,"Bugs Bunny\t","is playing tennis with lola bunny  ");
*/
        /**********     LAMBDA EXPRESSIONS WITH JAVA INSTANCE CLASS *******/



        //we are still inside doSomething() function, so uncomment each comment section to test the previous code :






        //note that anywhere inside a java code, when we do not type any keyword and simply use curly braces { }
        //this means that we are initializing an anonymous block of code section.
        //the scope rules apply to this block, so variables declared inside will be destroyed after the curly braces
        // end.


        /**************************** USING LAMBDA EXPRESSIONS WITH ANONYMOUS CLASSES *******************************/




      //int i = 0;//this variable is outside the nested block. BUT INSIDE doSomething() function.



//        final int i = 4000;//this variable is outside the nested block. BUT INSIDE doSomething() function.
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//
//                    //this is the anonymous class
//                    //the local variable i, of doSomething() function cannot be accessed here
//                    //it will give a compile time error.
//                    //since the class is different.
//                    System.out.println("i within anonymous class === "+i);
//
//                    /************
//                    the reason is simply this that the local variable belongs to the class in which the parent
//                    function resides. i.e its variable scope will define where it will and can be called and accessed
//
//                    i is in Anotherclass Inside doSomething Method.
//
//                    IN OTHER WORDS :
//
//                    ANONYMOUS CLASS CANNOT CHANGE INSTANCE CLASS FUNCTIONS LOCAL VARIABLES , because
//                    if the instance of the objects change, and the anonymous class object changes the value
//                    there will be no way to keep track of these changes , and this is a serious code flaw design.
//
//                    so these variables should be declared as final.
//                     ***********/
//
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//
//
//
//            System.out.println("The AnotherClass class name is : " + getClass().getSimpleName());
//
//           //ONCE we make changes to i variable to be final, we cannot change its value
//            //so comment this
//            //i++;//this nested block can use the local scope variables of doSomething method.
//            System.out.println("i = "+i);
//
//            return Main.doStringConcatenation(uc,"Call Of Duty\t","\tNeed For Speed");
//        }
//
//        /*
//        INSIDE AN ANONYMOUS CLASS we want to use a /
//        if we want to reference local variable defined outside an anonymous class
//        we have to declare local variable as final.
//
//         */



        int i = 0;
        UpperConcat uc = (s1,s2) -> {
            System.out.println("The Lambda Expression class name is - " +getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;

        };
        System.out.println("The AnotherClass class name is : " + getClass().getSimpleName());
        return Main.doStringConcatenation(uc,"Lamborghini Aventador\t","vs Bugatti Veyron");




        /**************************** USING LAMBDA EXPRESSIONS WITH ANONYMOUS CLASSES *******************************/



    }
}
