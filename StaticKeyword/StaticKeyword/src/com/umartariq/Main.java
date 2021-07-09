package com.umartariq;

public class Main {


    //instance variables, wont work until we create an instance of Main Class
    public int instancemultiplier = 7;

    //instance methods, wont work until we create an instance of Main Class
    public int instancemultiply(int number){
        return number*multiplier;
    }

    //static variable, use by Main.multiplier
    public static int multiplier = 7;

        //static method, use Main.multiply(int)
        public static int multiply(int number){
        return number*multiplier;
    }
    public static void main(String[] args) {
	// write your code here

        //static variables belong to the class
        //static methods belong to the class

        //instance variables belong to the instance
        //instance methods belong to the instance

        StaticTest firstInstance = new StaticTest("1st instance");
        System.out.println(firstInstance.getName() + " is instance Number " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance Number " + secondInstance.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd instance");
        System.out.println(thirdInstance.getName() + " is instance Number " + thirdInstance.getNumInstances());

        //no matter which instance method we use,
        // if the class has a static variable the instance methods will and must return same value for static variable
        //for example.

        System.out.println("current value of static variable is"+firstInstance.getNumInstances());
        System.out.println("current value of static variable is"+secondInstance.getNumInstances());
        System.out.println("current value of static variable is"+thirdInstance.getNumInstances());

        //the better and correct approach is to use a static method to access the static variable
        //so we do not make any instance
        System.out.println(" | | | | | | | | | | | | | | | | | | | ");
        StaticMethodTest firstSInstance = new StaticMethodTest("1st instance");
        System.out.println(firstInstance.getName() + " is instance Number " + StaticMethodTest.getNumInstances());

        StaticMethodTest secondSInstance = new StaticMethodTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance Number " + StaticMethodTest.getNumInstances());

        StaticMethodTest thirdSInstance = new StaticMethodTest("3rd instance");
        System.out.println(thirdInstance.getName() + " is instance Number " + StaticMethodTest.getNumInstances());

        //Our main Method is static. and case sensitive
        /*
        keyword static allows main to be called without creating an object of the class in which the main method is defined.
         If we omit static keyword before main Java program will successfully compile but it won't execute.

            since no instance exists of the Main Class, in our public static void main method
            we cannot use multiplier and multiply method yet !

            so we have to use the class accessor method
            i.e type name of class and then access fields/methods.
         */


            Main abc = new Main();

        int answer2 = abc.instancemultiply(6);//Non-static method multiply(int) cannot be accessed from static context.
        System.out.println("Answer is "+answer2);
        System.out.println("Multiplier is "+abc.instancemultiplier);//Non-static field multiplier cannot be accessed from static context.


        int answer = Main.multiply(6);//Non-static method multiply(int) cannot be accessed from static context.
        System.out.println("Answer is "+answer);
        System.out.println("Multiplier is "+Main.multiplier);//Non-static field multiplier cannot be accessed from static context.


    }



}
