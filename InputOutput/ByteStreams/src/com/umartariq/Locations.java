package com.umartariq;

import java.io.*;
import java.util.*;

/**
 * Locations.java created by umartariq on 24/06/2020
 * 3:38 PM inside the package - com.umartariq
 */
public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    static {
/*

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

    */


        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            //while statement must throw exception because of EOF in our stream
            boolean eof = false;
            while(!eof){
                try{
                    Map<String,Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("read location  "+locID + "   :    "+description);
                    System.out.println("Found  "+numExits + "   Exits. ");
                    for(int i=0;i<numExits;i++){
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction,destination);
                        System.out.println("\t\t" + direction +","+destination);
                    }
                    locations.put(locID,new Location(locID,description,exits));
                }catch(EOFException e){
                    eof = true;
                }
            }
        }catch(IOException io){
            System.out.println("IO Exception occured");
            //IOException occures due to EOF.
            //it will cause the program to jump out of while loop we created

        }







//END STATIC BLOCK
    }



























    public static void main(String[] args) throws IOException {

        //this class has a static initialization block
        //this class has to be loaded before its main method can execute
        //static initialization block has to execute before main method
        //we rewrite the main method, to save the data initialized in static block to a binary file.

        //we make a binary file, so that we dont have to deal with data types.
        //byte streams, by using byte streams we can deal with the data in the stream in any java primitive variables.

        //DataInputStream and OutputStream classes, reads 4 bytes from data and builds integer.


        /*
        Bitwise Zero Fill Right Shift Operator (>>>)

        Bitwise Zero Fill Right Shift Operator shifts the bits of the number towards the right a specified n number of positions. The sign bit filled with 0's. The symbol >>> represents the Bitwise Zero Fill Right Shift Operator.

When we apply >>> on a positive number, it gives the same output as that of >>. It gives a positive number when we apply >>> on a negative number. MSB is replaced by a 0.

Observe the above example, after shifting the bits to the right the binary number 00100000 (in decimal 32) becomes 00000100 (in decimal 4). The last three bits shifted out and lost.

Difference between >> and >>> operator
Both >> and >>> are used to shift the bits towards the right. The difference is that the >> preserve the sign bit while the operator >>> does not preserve the sign bit. To preserve the sign bit, you need to add 0 in the MSB.


Example
Let's see the left and right shifting through example:

public class OperatorShifting
{
public static void main(String args[])
{
byte x, y;
x=10;
y=-10;
System.out.println("Bitwise Left Shift: x<<2 = "+(x<<2));
System.out.println("Bitwise Right Shift: x>>2 = "+(x>>2));
System.out.println("Bitwise Zero Fill Right Shift: x>>>2 = "+(x>>>2));
System.out.println("Bitwise Zero Fill Right Shift: y>>>2 = "+(y>>>2));
}
}


Bitwise Left Shift: x<<2 = 40
Bitwise Right Shift: x>>2 = 2
Bitwise Zero Fill Right Shift: x>>>2 = 2
Bitwise Zero Fill Right Shift: y>>>2 = 1073741821


VALUE = 922,342,959

        public final void writeInt(int v) throws IOException {
        out.write((v >>> 24) & 0xFF); //move top 8 bits to lower positions
        out.write((v >>> 16) & 0xFF);
        out.write((v >>>  8) & 0xFF);
        out.write((v >>>  0) & 0xFF);
        incCount(4);
    }
         */




        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){

            for(Location location : locations.values()){
                locFile.writeInt(location.getLocationID()); //write int
                locFile.writeUTF(location.getDescription()); //write string
                System.out.println("writing location    " + location.getLocationID() + "  :   " + location.getDescription());
                System.out.println("writing   " +(location.getExits().size()-1) + "   Exits. ");
                locFile.writeInt(location.getExits().size()-1);
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        System.out.println("\t\t"+direction+","+location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
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

