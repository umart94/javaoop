package com.umar;

public class DeluxeZingerBurger extends BaseBurger{

    public DeluxeZingerBurger() {
        super("Deluxe","zingERrR", 280,"Dawn Ka Bun breaD");
        super.addBaseBurgerAddition1("Chips",70);
        super.addBaseBurgerAddition2("Drink",40);
    }

    @Override
    public void addBaseBurgerAddition1(String name, double price) {
        System.out.println("Cannot Add Additional Items In Deluxe Burger");
    }

    @Override
    public void addBaseBurgerAddition2(String name, double price) {
        System.out.println("Cannot Add Additional Items In Deluxe Burger");
    }

    @Override
    public void addBaseBurgerAddition3(String name, double price) {
        System.out.println("Cannot Add Additional Items In Deluxe Burger");
    }

    @Override
    public void addBaseBurgerAddition4(String name, double price) {
        System.out.println("Cannot Add Additional Items In Deluxe Burger");
    }
}
