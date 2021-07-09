package com.umartariq;

public class Main {

    public static void main(String[] args) {

        /*
        In the Java programming language, the final keyword is used in several contexts to define an entity that can only be assigned once.
         Once a final variable has been assigned, it always contains the same value
         */

        FinalKeywordTest finalKeywordTestclassObjectone = new FinalKeywordTest("one");
        FinalKeywordTest finalKeywordTestclassObjecttwo = new FinalKeywordTest("two");
        FinalKeywordTest finalKeywordTestclassObjectthree = new FinalKeywordTest("three");

        System.out.println(finalKeywordTestclassObjectone.getInstanceNumber());
        System.out.println(finalKeywordTestclassObjecttwo.getInstanceNumber());
        System.out.println(finalKeywordTestclassObjectthree.getInstanceNumber());

        // finalKeywordTestclassObjectthree.instanceNumber = 1000;
        // since we set instanceNumber in constructor
        // Cannot assign a value to final variable 'instanceNumber'

        //Private constructors in Java
        // Math mathObj = new Math();// Math() has private access in java.lang.Math


        System.out.println(Math.PI);
        System.out.println(" | | | | | | | | | | | | | | | | |");
        //PI in Math class as well as every method, every variable in Math class is Static
        //public static final double PI = 3.14
        //public static double method(double num){
                //return double;
        // }

        //if all methods and all variables in a class are static, we can make a private constructor and make the class final

        //public final class Math

        //and

        //private Math() {}

        //so we can never instantiate this class, and it cannot be modified ( internal contents ) by public code.

        //the final keyword with a class means that we cannot inherit from this class
        //so we cannot make a subclass of math class

        //Purpose of a final class
        /*

        A final class is a class that can't be extended. Also methods could be declared as final to indicate that cannot be overridden by subclasses.

Preventing the class from being subclassed could be particularly useful if you write APIs or libraries and want to avoid being extended to alter base behaviour.

         */


        /*
        The use of private constructor is to serve singleton classes.
        A singleton class is one which limits the number of objects creation to one.
        Using private constructor we can ensure that no more than one object can be created at a time.
        By providing a private constructor you prevent class instances from being created in any place other than this very class.
        We will see in the below example how to use private constructor for limiting the number of objects for a singleton class.


public class SingleTonClass {
   //Static Class Reference
   private static SingleTonClass obj=null;
   private SingleTonClass(){
     // Private Constructor will prevent
      // the instantiation of this class directly
    }
    public static SingleTonClass objectCreationMethod(){
        //This logic will ensure that no more than
         // one object can be created at a time
        if(obj==null){
            obj= new SingleTonClass();
        }
        return obj;
    }
    public void display(){
        System.out.println("Singleton class Example");
    }
    public static void main(String args[]){
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
        SingleTonClass myobject= SingleTonClass.objectCreationMethod();
        myobject.display();
    }
}



There are various scenarios where we can use private constructors. The major ones are

Internal Constructor chaining
Singleton class design pattern
What is a Singleton class?

As the name implies, a class is said to be singleton if it limits the number of objects of that class to one.

We can’t have more than a single object for such classes.

Singleton classes are employed extensively in concepts like Networking and Database Connectivity.

Design Pattern of Singleton classes:

The constructor of singleton class would be private so there must be another way to get the instance of that class. This problem is resolved using a class member instance and a factory method to return the class member.



// Java program to demonstrate implementation of Singleton
// pattern using private constructors.
import java.io.*;

class MySingleton
{
    static MySingleton instance = null;
    public int x = 10;

    // private constructor can't be accessed outside the class
    private MySingleton() {  }

    // Factory method to provide the users with instances
    static public MySingleton getInstance()
    {
        if (instance == null)
             instance = new MySingleton();

        return instance;
    }
}

// Driver Class
class Main
{
   public static void main(String args[])
   {
       MySingleton a = MySingleton.getInstance();
       MySingleton b = MySingleton.getInstance();
       a.x = a.x + 10;
       System.out.println("Value of a.x = " + a.x);
       System.out.println("Value of b.x = " + b.x);
   }
}


Output:

Value of a.x = 20
Value of b.x = 20
We changed value of a.x, value of b.x also got updated because both ‘a’ and ‘b’ refer to same object, i.e., they are objects of a singleton class.






Yes, a constructor can be private. There are different uses of this. One such use is for the singleton design anti-pattern, which I would advise against you using. Another, more legitimate use, is in delegating constructors; you can have one constructor that takes lots of different options that is really an implementation detail, so you make it private, but then your remaining constructors delegate to it.

As an example of delegating constructors, the following class allows you to save a value and a type, but it only lets you do it for a subset of types, so making the general constructor private is needed to ensure that only the permitted types are used. The common private constructor helps code reuse.

public class MyClass {
     private final String value;
     private final String type;

     public MyClass(int x){
         this(Integer.toString(x), "int");
     }

     public MyClass(boolean x){
         this(Boolean.toString(x), "boolean");
     }

     public String toString(){
         return value;
     }

     public String getType(){
         return type;
     }

     private MyClass(String value, String type){
         this.value = value;
         this.type = type;
     }
}
Edit
Looking at this answer from several years later, I would like to note that this answer is both incomplete and also a little bit extreme. Singletons are indeed an anti-pattern and should generally be avoided where possible; however, there are many uses of private constructors besides singletons, and my answer names only one.

To give a couple more cases where private constructors are used:

To create an uninstantiable class that is just a collection of related static functions (this is basically a singleton, but if it is stateless and the static functions operate strictly on the parameters rather than on class state, this is not as unreasonable an approach as my earlier self would seem to suggest, though using an interface that is dependency injected often makes it easier to maintain the API when the implementation requires larger numbers of dependencies or other forms of context).

When there are multiple different ways to create the object, a private constructor may make it easier to understand the different ways of constructing it (e.g., which is more readable to you new ArrayList(5) or ArrayList.createWithCapacity(5), ArrayList.createWithContents(5), ArrayList.createWithInitialSize(5)). In other words, a private constructor allows you to provide factory function's whose names are more understandable, and then making the constructor private ensures that people use only the more self-evident names. This is also commonly used with the builder pattern. For example:

MyClass myVar = MyClass
    .newBuilder()
    .setOption1(option1)
    .setOption2(option2)
    .build();




















         */



            /*
            One more example of where we can use the final keywords and variables
            suppose we have a default implementation of cryptographic cipher / algorithm implementation
            //with its own encrypt and decrypt and keymodifier methods
            (math operators xor, gates etc.)

            //we don't want any user to modify the class
            //and we don't want to modify or change it with our own implementation

            //in case of standard implementations
            //so we use final variables
             */
            int pw = 7534;
           // Password password = new Password(pw); //MISTAKE, CHANGED PASSWORD TO EXTENDED PASSWORD

        Password password = new Password(pw);//Revert this back.
            password.storePassword();

            password.letMeIn(1);
            password.letMeIn(1243);
            password.letMeIn(2345);
            password.letMeIn(0);
            password.letMeIn(-1);
            password.letMeIn(-999);
            password.letMeIn(7534);




    }
}
