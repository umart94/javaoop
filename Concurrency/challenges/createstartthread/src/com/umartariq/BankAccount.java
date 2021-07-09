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

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber,double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposit(double amount){
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount){
//        balance -= amount;
//    }

    public  void deposit(double amount){
//        synchronized(this) {
//            balance += amount;
//        }

        //using reentrant lock
//        lock.lock();
//        try{
//            balance += amount;
//        }finally{
//            lock.unlock();
//        }

        //using tryLock method
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance += amount;
                } finally{
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock. ");
            }
        }
        catch (InterruptedException e){

        }


    }

    public  void withdraw(double amount){
//        synchronized(this) {
//            balance -= amount;
//        }


        //using reentrant lock
//        lock.lock();
//        try{
//            balance -= amount;
//        }finally{
//            lock.unlock();
//        }

        //using tryLock method
        //using tryLock method
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance -= amount;
                } finally{
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock. ");
            }
        }
        catch (InterruptedException e){

        }


    }

    //since these two methods are not modifying any fields of the class, they are just reading and printing out
    // accountNumber , so we would not synchronize these methods, as it would negatively impact performance.

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("account number = "+ accountNumber);
    }


}
