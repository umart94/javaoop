package com.umartariq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Locations.java created by umartariq on 24/06/2020
 * 3:16 PM inside the package - com.umartariq
 */
public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    static {
        //locations_big.txt
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int location = scanner.nextInt();
                scanner.skip(scanner.delimiter());//skip over the comma, we don't want comma in the variables, that would crash program.
                String description = scanner.nextLine();
                System.out.println("Imported location: " + location + ": " + description);
                Map<String, Integer> tempExit = new HashMap<String, Integer>();
                locations.put(location, new Location(location, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //now read exits ... directions_big.txt
        try (BufferedReader directionsFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while (  (input = directionsFile.readLine()) != null ){
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        try(FileWriter locationsFile = new FileWriter("locationsoutput.txt"); //java 7 syntax
            FileWriter directionsFile = new FileWriter("directionsoutput.txt")) {
            for (Location location : locations.values()) {
                locationsFile.write(location.getLocationID() + "," + location.getDescription()+"\n");
                for(String direction : location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")){
                        directionsFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                    }
            }
        }


    }




    @Override
    public int size() {
        //how many locations are inside HashMap
        return locations.size();
    }
    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }
    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }
    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }
    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }
    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }
    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }



    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
