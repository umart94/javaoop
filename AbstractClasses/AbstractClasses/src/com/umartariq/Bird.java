package com.umartariq;

public abstract class Bird extends Animal implements ICanFly{


    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking ");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing ");
    }

    @Override
    public void fly() {
        System.out.println(getName() + "flapp flapp flapp uh wings");
    }
}
