package com.umartariq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /*
    Get Data into and out of program is input output

    input is reading data from source
    output is writing it to some location

    network connections , pipes, keyboard
    we are reading from System.in not from the keyboard.!

    creating a report file to import into spreadsheet - choose character stream (xml,json data)
    binary format - variables and classes.

    serial sequential files
    stream of data that arrives /sent out of program with each piece of data in sequence


    random access files
    retrieve or overwrite any piece of data from anywhere in the file
    how database reads with e.g indexes , we won't read sequentially , but only from where we want to select / retrieve

     */

    //private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
        //map is declared using generics... integer key and location

        //if location class is extended, instances of new class can also be used ( in place of values for the key Integer)

        //if we used location type for key instead of value i.e Map<Location,Integer>
        //and we want completely immutable objects as keys
        // then we have to prevent subclasses over which we dont have control
        // use composition which call location class methods from instance of location

        //bankaccount class where balance does not change is not useful - immutability will not be useful in such scenario


    private static Locations locations = new Locations();

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Map<String, String> vocabulary = new HashMap<String, String>();
            vocabulary.put("QUIT", "Q");
            vocabulary.put("NORTH", "N");
            vocabulary.put("SOUTH", "S");
            vocabulary.put("WEST", "W");
            vocabulary.put("EAST", "E");


            int loc = 1;
            while (true) {
                System.out.println(locations.get(loc).getDescription());
             //   tempExit.remove("S"); REMOVE THIS WHEN YOU TEST THE EXTENDED LOCATIONS CLASS
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
