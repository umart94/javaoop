package com.umar;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(){
        this(1234,500.0,"umar","umar@gmail.com","03318302835");
        //initialize with default values all variables
        //call to this must be first line in constructor body
        System.out.println("empty constructor called");
    }
    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(int accountNumber, double balance) {
        this(accountNumber,balance,"tariq","t@c.com","0345");
        //initialize only remaining
        //but the first two are passed as it is (new values) through constructor

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount){
        this.balance+=depositAmount;
        System.out.println("Deposit of"+depositAmount+"processed. Remaining Balance = "+this.balance);

    }
    public void deductFunds(double withdrawalAmount){
        if(balance -withdrawalAmount<0){
            System.out.println("Only"+this.balance+"available withdrawal not processed");
        }else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of"+withdrawalAmount+"processed. Remaining Balance = "+this.balance);
            }
    }


}
