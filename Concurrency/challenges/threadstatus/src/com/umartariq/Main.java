package com.umartariq;

/**
 * Main.java created by umartariq on 24/09/2020
 * 10:50 AM inside the package - com.umartariq
 * in the java project createstartthread using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {


    final BankAccount account = new BankAccount("1234-5678",1000.00);
    
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(200.00);
                account.withdraw(100.00);
            }
        });
    thread1.start();
    thread2.start();
    }
}
