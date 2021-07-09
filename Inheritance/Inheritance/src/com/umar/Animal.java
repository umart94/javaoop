package com.umar;

public class Animal {
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    //Instance Methods can access instance methods and instance variables directly
    //Instance Methods can also access static methods and static variables directly

    //static variables are seen throughout the class anywhere
    //we can declare scanner as static so that it wont be declared everytime
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //eat function is common to all animals
    public void eat(){
        System.out.println("Animal.eat() called");
    }

    //move method is common to all animals
    public void move(int speed){
        System.out.println("Animal is moving at speed"+speed);
    }
}
