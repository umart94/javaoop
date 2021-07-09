package com.umartariq;

import java.util.ArrayList;
import java.util.Scanner;

//Interfaces - are purely abstract... actually implementation is left to the classes that implement that interface
//Abstract Classes - define required functionality without the details





public class Main {

    public static void main(String[] args) {
        // write your code here
        Dog dog = new Dog("Shibe");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Hum to Uraingeee");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Stoopidface ... Are you my family ?");
        penguin.breathe();
        penguin.eat();
        penguin.fly();


        Player MasterChief = new Player("MasterChief John",10,15);
        System.out.println(MasterChief.toString());
        saveObject(MasterChief);

        MasterChief.setHitPoints(80);
        System.out.println(MasterChief);
        MasterChief.setWeapon("MA5B");
        saveObject(MasterChief);
        loadObject(MasterChief);
        System.out.println(MasterChief);

        ISaveable Banished = new Monster("Banished",20,40);
        System.out.println(Banished);
        System.out.println("Strength" + ((Monster) Banished).getStrength());
        saveObject(Banished);
        loadObject(MasterChief);

    }


    public static void saveObject(ISaveable objectToSave){
        for(int i=0;i<objectToSave.write().size();i++){
            System.out.println("Saving " + objectToSave.write().get(i));
        }
    }
    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" + "1 to enter a string\n" + "0 to quit");

        while(!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a String: ");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);

                    index++;
                    break;
            }
        }
        return values;
    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}