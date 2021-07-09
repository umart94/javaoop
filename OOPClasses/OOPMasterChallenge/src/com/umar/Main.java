package com.umar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        BaseBurger baseBurger = new BaseBurger("Basic Burger","Sausage",250,"White");
        double priceofBaseBurger = baseBurger.itemizeBaseBurger();
        System.out.println("Before price base burger adding items"+priceofBaseBurger);
        baseBurger.addBaseBurgerAddition1("Nuggers",90);
        baseBurger.addBaseBurgerAddition2("Chimkin Pieces",100);
        baseBurger.addBaseBurgerAddition3("Cheese",120);
        baseBurger.addBaseBurgerAddition4("Olives",50);
        baseBurger.itemizeBaseBurger();

        double finalPriceOfBaseBurger = baseBurger.itemizeBaseBurger();

        System.out.println("After Total Burgaa Price"+finalPriceOfBaseBurger);
        System.out.println("End Base burger");
        System.out.println();
        System.out.println();

        HealthyBurger abcd = new HealthyBurger("Healthy Chicken Burger",250);
        double priceOfHealthyBurger = abcd.itemizeBaseBurger();
        System.out.println("Before Price of healthy "+priceOfHealthyBurger);
        abcd.addHealthAddition1("egg",20);
                abcd.addHealthAddition2("Olives",40);
        abcd.itemizeBaseBurger();
                double finalpriceOfHealthyBurger = abcd.itemizeBaseBurger();
        System.out.println("After price of healthy  "+finalpriceOfHealthyBurger);

        DeluxeZingerBurger db = new DeluxeZingerBurger();
        System.out.println("Price of Deluxe Package"+db.itemizeBaseBurger());
    }
}
