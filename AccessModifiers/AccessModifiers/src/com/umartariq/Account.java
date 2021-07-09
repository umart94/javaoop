package com.umartariq;

import java.util.ArrayList;

/**
 * Account.java created by umartariq on 20/06/2020
 * 4:48 PM inside the package - com.umartariq
 */
public class Account {
    //There are four types of Java access modifiers:

    //Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
    //Default/No Modifier/Package-Private: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
    //Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
    //Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.


    private String accountName;
    private double balance=0.0;
    private ArrayList<Double> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        transactions = new ArrayList<Double>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount+" deposited, Balance is now "+ this.balance);
        } else {
            System.out.println("Cannot deposit a negative sum");
        }
    }

    public void withdraw(double amount){
        double withdrawal = -amount;//negative sign here
        if(withdrawal < 0){
            this.transactions.add(withdrawal);
            this.balance += withdrawal;//positive sign here
            System.out.println(amount +"  withdrawn, Balance is now, "+this.balance);
        } else{
            System.out.println("cannot withdraw negative sums");
        }
    }

    public void calculateBalance(){
            this.balance = 0;
            for(double i : this.transactions){
                this.balance += i;

            }
        System.out.println("calculated balance is "+this.balance);
    }
}
