package com.umartariq;

public class Main {

    public static void main(String[] args) {

            Account umarsAccount = new Account("umar");
            umarsAccount.deposit(1000.0);
            umarsAccount.deposit(1000.0);

            System.out.println("balance through getter" + umarsAccount.getBalance());
            umarsAccount.calculateBalance();


            umarsAccount.deposit(-9468.9876554321); //should not work
            umarsAccount.withdraw(-8649.98767689856421);//should not work

            System.out.println("balance through getter" + umarsAccount.getBalance());
            umarsAccount.calculateBalance();


            umarsAccount.deposit(2000.0);//2500
            umarsAccount.withdraw(3000.0);//1000
            umarsAccount.withdraw(1000.0);//For testing, this returns 0 balance.
            System.out.println("balance through getter" + umarsAccount.getBalance());//0
            umarsAccount.calculateBalance();//0
            umarsAccount.deposit(123.45678);
        System.out.println("balance through getter" + umarsAccount.getBalance());//0
        umarsAccount.calculateBalance();//0
        //umarsAccount.balance = 400;//has private access, error

    }
}
