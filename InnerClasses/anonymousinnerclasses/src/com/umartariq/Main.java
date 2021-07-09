package com.umartariq;

/**
 * Main.java created by umartariq on 24/09/2020
 * 7:29 PM inside the package - com.umartariq
 * in the java project anonymousinnerclasses using IDE IntelliJ IDEA
 */

class Machine{

    public void start(){
        System.out.println("Starting Machine ...");
    }
}

interface Computer {
    public void execute();
}

public class Main {

    public static void main(String[] args) {
       // Machine machine = new Machine();
       // machine.start();

        //now we will override start method in machine
        //we can do this by extending the machine class in another class OR

        //Machine machine1 = new Machine(){};
        //this is syntax for anonymous inner class
        //we can now override the start method in this class , by suplying new implementation

        Machine machine1 = new Machine(){
            @Override
            public void start() {
                System.out.println("machine starting");
                //this is not the machine class
                //this is an object inside the main class, and inside that there is an anonymous inner class object.
                //the type of this object is a child class of the machine class, that does not actually have a name
                // assigned to the class.

            }
        };
        machine1.start();

        //if we implement an interface or extend a class, we have to explicitly define a class file / interface file
        // with a name and use implements / extends keyword.

        //what we could do is use anonymous classes /

        //Computer computer = new Computer(); //this wont work , as we cannot instantiate an object of interface.
        Computer computer = new Computer() {
            @Override
            public void execute() {
                System.out.println("Computer executing function");
            }
        };

        computer.execute();

    }
}
