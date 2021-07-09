package com.umartariq;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " Is eating ");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " Breathe in, breathe out , repeat ");
    }
}
