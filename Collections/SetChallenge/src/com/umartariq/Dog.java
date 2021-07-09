package com.umartariq;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        //you have to make only 1 equals overriden function and that too, in the base class
        //if you make it in the subclass as well.. it won't work.. as rover2 was an instance of dog and not labrador and vice versa
        //so make equals method final and define it in the base class only..
        if(this==obj){
            return  true;
        }
        if(obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
