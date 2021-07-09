package com.umartariq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    //map is declared using generics... integer key and location


    //if location class is extended, instances of new class can also be used ( in place of values for the key Integer)

    //if we used location type for key instead of value i.e Map<Location,Integer>
    //and we want completely immutable objects as keys
    // then we have to prevent subclasses over which we dont have control
    // use composition which call location class methods from instance of location

    //bankaccount class where balance does not change is not useful - immutability will not be useful in such scenario


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<String, Integer>();

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
        //immutable locations class with tempExit instance passed inside constructor

        //main class instance of tempExit.. that will not affect the tempExit instance passed in the locations constructor
        //https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
        /*
        Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
Make all fields final and private.
Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
If the instance fields include references to mutable objects, don't allow those objects to be changed:
Don't provide methods that modify the mutable objects.
Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.






         */
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are Standing At the end of a road Infront Of A Small Brick Building", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are At the Top of a Hill", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are In a Forest", tempExit));


        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            //if we remove south here.. it will affect all the other locations and program as well
            //this affects location 5, but in turn affects the other locations as well
            //so we will create new instance of exits hashmap inside the locations class
            //even though we have removed an exit inside main class
            //since we created instance inside location class constructor.... that remains same throughout the program
            //and the other instances do not affect immutability
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are : ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("you cannot go in that direction ");
            }

            /*loc = scanner.nextInt();
            if(!locations.containsKey(loc)){
                System.out.println("You cannot go in that direction");
            }*/
        }
    }
}
