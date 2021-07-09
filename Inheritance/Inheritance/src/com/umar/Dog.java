package com.umar;



public class Dog extends Animal {
    //if animal does not have a constructor there is an error on extends
        private int eyes;
        private int legs;
        private int tail;
        private int teeth;
        private String coat;


    public Dog(String name, int size, int weight,int eyes,
               int legs, int tail, int teeth, String coat) {

        //super(name, brain, body, size, weight);
        super(name, 1, 1, size, weight);
        //since all dogs inherit from Animal class
        //brain and body have been given 1
        //to suggest that all living dogs have brain and a body
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void chew(){
        System.out.println("Dog.chew() called");
    }

    //only instance methods can be overridden
    @Override
    public void eat() {
        //call this own classes methods inside overridden methods
        chew();
        super.eat();
        //return type can be a subclass of the return type in parent class
        //only inherited methods can be overridden
        //constructors and private methods cannot be overridden
        //methods that are final cannot be overridden
        //a subclass can use super.methodName() to call superclass version
        //of an overridden method
    }

    public void walk(){
        System.out.println("Dog.walk() called");
        super.move(5); //note here super.move() is called
    }
    public void run(){
        System.out.println("Dog.run() called");
        move(10); // note here only current dog.move() is called
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }
}
