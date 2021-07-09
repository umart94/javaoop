package com.umar;

public class Main {

    public static void main(String[] args) {
        // an object has state and behaviour
        Car a=new Car();
        a.setModel("HC");
        Car lamborghini = new Car();
        lamborghini.setModel("Lamborghini");
        System.out.println("model is "+lamborghini.getModel());
        System.out.println("model is "+a.getModel());

        BankAccount umarAccount = new BankAccount();
        umarAccount.setAccountNumber(12345);
        umarAccount.setBalance(0.00);
        umarAccount.setCustomerName("Muhammad Umar Tariq");
        umarAccount.setEmail("umartariqx94@gmail.com");
        umarAccount.setPhoneNumber("021-34825386");
        umarAccount.depositFunds(101);
        umarAccount.deductFunds(100.0);

        BankAccount ab = new BankAccount(1,200.0);
        System.out.println(ab.getCustomerName());

        VipCustomer p = new VipCustomer();
        System.out.println(p.getName());
        VipCustomer q = new VipCustomer("falooda man",45.7);
        System.out.println(q.getEmailAddress());
        VipCustomer r = new VipCustomer();
        r = new VipCustomer("tim",100.0,"umar");

         }
}
