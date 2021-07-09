package com.umartariq;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String privateVar = "private to main class and main() function";
        ScopeCheck Obj = new ScopeCheck();
        System.out.println("private var in scopecheck is  "+ Obj.getPrivateVar());
        System.out.println(privateVar);
        System.out.println("**********************************************************");
        Obj.timesTwo();
        System.out.println("***************************");
        ScopeCheck.InnerClass innerScopeObj = Obj.new InnerClass();

        /*
        Quick Problem
         OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass();
       // How to get the same outer object which created the inner object back?
        OuterClass anotherOuter = ?? ;

        if(anotherOuter == outer) {
             System.out.println("Was able to reach out to the outer object via inner !!");
        } else {
             System.out.println("No luck :-( ");
        }

        public OuterClass getOuter() {
    return OuterClass.this;
}

         */

        System.out.println("**********************************************************");
            ScopeCheck SecondObjectToTest = new ScopeCheck();
        SecondObjectToTest = Obj.getOuter();
        ScopeCheck.InnerClass innerScopeObj2 = SecondObjectToTest.new InnerClass(); //just for testing ... NOT FOR FUBAR PRODUCTION INCORPORATED
        innerScopeObj2.timesTwo();



    }
}
