package com.umartariq;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Example.java created by umartariq on 20/06/2020
 * 8:56 PM inside the package - com.umartariq
 */
public class Example {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide(){
        int x,y;
        try {
            x = getInt();
            y = getInt();
        } catch(NoSuchElementException e){
            //x =  getInt();//undeclared here, declare x outside the try catch block , will throw exception

            //we can use constructors in exceptions with string message to make it easier to understand what is the error being thrown
            //in cases of longer lines of code
            throw new ArithmeticException("No Suitable Input");
        }
        System.out.println("x is " + x + " , y is "+y);
        try {
            return x/y;
        }catch (ArithmeticException e){
            throw new ArithmeticException("Attempt to Divide By Zero");
        }

    }










       /*
       Exceptions are subclasses of exception class
       instances of throwable
       throwable
       code goes from nextInt, to next, to throwFor, where at line 939 we have

          private void throwFor() {
        skipped = false;
        if ((sourceClosed) && (position == buf.limit()))
            throw new NoSuchElementException();
        else
            throw new InputMismatchException();
    }

        this is called propagation

        Stack Pushed and Popped
        we go from downwards to upwards direction and when the function that handles the exception is reached
        //it is thrown

        //in this case, since we did not handle exception ourselves the jdk classes have these built in error detection mechanisms.
        //we need to handle in our code.

         public InputMismatchException() {
        super();
    }

     public NoSuchElementException() {
        super();
    }

    and so on, Ctrl+click on the super methods

        */

        /*
        Call stack is a list of all method calls at a particular point in a program ( e.g when program crashed)
        when a method is called, its pushed onto the stack
        when a method returns it's popped off from the stack
         */

        //Divide By Zero - ArithmeticException - Stack Trace
        /*
        x is 100 , y is 0
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.umartariq.Example.divide(Example.java:20)
	at com.umartariq.Example.main(Example.java:12)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)
         */



        //InputMismatchException StackTrace
        /*
        Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212) --These are java default files. , to move around inside do Ctrl+Click instead of default click
	at com.umartariq.Example.getInt(Example.java:49) --END HERE
	at com.umartariq.Example.divide(Example.java:17)
	at com.umartariq.Example.main(Example.java:12) --START HERE
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)
         */


        //NoSuchElementException
        /*
        Please enter an integer:
^D - sends the ascii end of transmission character that abruptly terminates input

Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.Scanner.throwFor(Scanner.java:937)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at com.umartariq.Example.getInt(Example.java:102)
	at com.umartariq.Example.divide(Example.java:17)
	at com.umartariq.Example.main(Example.java:12)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)

 public RuntimeException() {
        super();
    }

     public Exception() {
        super();
    }

    public Throwable() {
        fillInStackTrace();
    }


         */



    //no more input available or
    //no valid integer supplied
    //checked or unchecked exceptions
    //here we discuss unchecked exceptions


    //incorrect version of getInt()
    //if you send the Ctrl+D ^D EOT with this method, it will not catch the NoSuchElementException

    //we can handle exceptions in caller method, or the called method
    //getInt() was called by divide was called by main
    //main() is caller for divide()
    //divide() is caller for getInt()
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        while(true){
            //continue executing until we break out explicitly
            try{
                return s.nextInt();
            }catch(InputMismatchException e){
                //go around input, Read past the end of the line in the input first
                s.nextLine();
                System.out.println("Please enter a number using digits 0 t0 9");
            }
        }
    }
}
