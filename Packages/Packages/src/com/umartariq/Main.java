package com.umartariq;

//replace invalid chars like - in domain names with underscore
//domain name components starting with a number should instead start with an underscore_
//domain name components that are java keywords should have that component start with an underscore

//Switch.supplier.com -> com.supplier._switch
//1world.com -> com._1world
//experts-exchange.com -> com.experts_exchange

//classnames in CamelCase
//ArrayList
//LinkedList
//ConnectToDatabase


//method names in mixedCase
// printTableOf2();
// displayNameOfPerson();

//variable names mixedCase
// int numberOfPlayers = 0;

//search type parameters Element , key , type ,value ,S U V 2nd - 3rd - 4th types


public class Main {

    //Class or interface name conflicts are inevitable
    //Mechanism is needed to fully specify class
    //allow use of classes with the same name in the same project or even the same class
    public static void main(String[] args) {
	// write your code here
        MyWindow windowObj = new MyWindow("JAVA WINDOW");
        windowObj.setVisible(true);

        //make project
        //or build artifacts
    }
}
