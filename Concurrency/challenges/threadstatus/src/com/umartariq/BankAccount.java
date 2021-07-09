package com.umartariq;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BankAccount.java created by umartariq on 24/09/2020
 * 10:50 AM inside the package - com.umartariq
 * in the java project createstartthread using IDE IntelliJ IDEA
 */
public class BankAccount {
    //to make a class threadsafe, synchronize any method that is updating a field.
    //update code so that status variable is threadsafe.
    //since status variable is a local variable, stored on thread stack , each thread has its own copy
    //so status variable is already threadsafe.


    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber,double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }


    public  void deposit(double amount){
        boolean status = false;

        //using tryLock method
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance += amount;
                    status = true;
                } finally{
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock. ");
            }
        }
        catch (InterruptedException e){

        }
        System.out.println("transaction status = "+status);


    }

    public  void withdraw(double amount){
        boolean status = false;

        //using tryLock method
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance -= amount;
                    status = true;
                } finally{
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock. ");
            }
        }
        catch (InterruptedException e){

        }
        System.out.println("transaction status = "+ status);


    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("account number = "+ accountNumber);
    }


}
