package com.umartariq;

import com.sun.source.tree.Scope;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck(){
        System.out.println("ScopeCheck Constructor , publicVAR = "+ publicVar+"privateVAR = "+ privateVar);
    }

    public int getPrivateVar(){
        return privateVar;
    }

    public void timesTwo(){
        int privateVar = 2;
        System.out.println("**********************************************************");
        for (int i=0;i<10;i++){
            System.out.println(i + " times two is " + i * privateVar);
        }


    }


    public ScopeCheck getOuter() {
        return ScopeCheck.this;
    }


    public class InnerClass {



        public int privateVar = 40;

        public InnerClass(){

            System.out.println("InnerCLass created , privateVar is  "+ privateVar);
        }

        public void timesTwo(){
            //int privateVar = 2; //havent uncommented yet, project was to comment this and test the class level variables
            System.out.println("**********************************************************");
            for (int i=0;i<10;i++){
                System.out.println(i + " times two is " + i * privateVar);
            }
            System.out.println("**********************************************************");
            //NOW we will print timesTwo loop with the Outer Class Class Level privatVar Variable
            for (int i=0;i<10;i++){
                System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
            }


            ScopeCheck.this.timesTwo();//calls outer class method

        }
    }







}
