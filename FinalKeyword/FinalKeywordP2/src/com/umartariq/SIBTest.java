package com.umartariq;

/**
 * SIBTest.java created by umartariq on 20/06/2020
 * 7:02 PM inside the package - com.umartariq
 */
public class SIBTest {
   // type psfs
            //and psvm etc. then press tab for code completion
    public static final String owner;


    //declared using static keyword
    //these can be of any number
    //called in the order declared in the class



    static{
        owner = "umar";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest(){
        System.out.println("SIB Constructor called");
    }



    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod(){
        System.out.println("Some Method called");
    }
}
