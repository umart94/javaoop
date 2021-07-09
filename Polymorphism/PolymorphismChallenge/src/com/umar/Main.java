package com.umar;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine=true;
        this.wheels=4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        return "Car -> startEngine()";
    }

    public String accelerate(){
        return "Car -> accelerate()";
    }

    public String brake(){
        return "Car -> brake()";
    }
    public String brak2e(){
        return "Car -> brake()";
    }
}

class Mitsubishi extends Car{

    public Mitsubishi(int cylinders,String name){
        super(cylinders,name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> brake()";
    }

    public String mitsubishiNitro(){ return "Mitsubishi -> nitro()";}
}
class Lamborghini extends Car{

    public Lamborghini(int cylinders,String name){
        super(cylinders,name);
    }

    @Override
    public String startEngine() {
        return "Lamborghini -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Lamborghini -> accelerate()";
    }

    @Override
    public String brake() {
        return "Lamborghini -> brake()";
    }
}

class Audi extends Car{

    public Audi(int cylinders,String name){
        super(cylinders,name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName()+"-> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName()+" -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName()+" -> brake()";
    }
}
public class Main {

    public static void main(String[] args) {

      /* Car car = new Car(8,"Lancer Evo");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6,"Lancer Evo 9");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Lamborghini lambo = new Lamborghini(12,"Aventador");
        System.out.println(lambo.startEngine());
        System.out.println(lambo.accelerate());
        System.out.println(lambo.brake());

        Audi audi = new Audi(12,"R8");
        System.out.println(audi.startEngine());
        System.out.println(audi.accelerate());
        System.out.println(audi.brake()); */


      Car carobj1 = new Car(8,"vroom");
        ((Mitsubishi)carobj1).mitsubishiNitro();

    }
}
