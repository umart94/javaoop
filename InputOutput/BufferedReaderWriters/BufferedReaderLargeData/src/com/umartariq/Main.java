package com.umartariq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main.java created by umartariq on 24/06/2020
 * 2:43 PM inside the package - com.umartariq
 */
public class Main {

    //https://jerz.setonhill.edu/intfic/colossal-cave-adventure-source-code/
    //FORTRAN COLOSSAL CAVE ADVENTURE GAME
    // the consoles of earlier times could only display Capital Characters.

    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        //int loc = 1;
        int loc = 64;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
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
        }
    }
}
