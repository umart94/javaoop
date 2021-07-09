package com.umartariq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main.java created by umartariq on 25/06/2020
 * 4:32 PM inside the package - com.umartariq
 */
public class Main {


    private static Locations locations = new Locations();

    //startByte = (n-1) * 30;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");



        Location currentLocation = locations.getLocation(1);
        while (true) {
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationID() == 0) {
                break;
            }


            Map<String, Integer> exits = currentLocation.getExits();
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
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction));
            } else {
                System.out.println("you cannot go in that direction ");
            }
        }
        locations.close();
    }
}

/*when accessing a file in a random access method
FilePointer is an offset in the file. where the next read or write will start from.
if we set it to 100 then the next time we call the read or write method.
the read or write will start at byte position 100
in the file
if we read an int
bytes from 100,101,102, until 103 will be read since

if int = 32 bits then
1 byte = 8 bits and 8*4 = 32.
the byte position is 0 based.

whenever we read or write the file
FilePointer is advanced by the number of bytes we read or write

if FP=100 and we read 5 bytes then filepointer=105

we also use an offset.
offset is a byte location in the file.
if value has offset of a 100
that means that byte is located 100 in the file. and read/write will start at
EXACTLY 100th Position.


this value can occupy more than 1 byte.
the offset is where the value's first bytes are located. we have to follow from
100 sequentially.


when using Random Access Files a set of related data is a Record.
locationID, description and exits make up the record. for a Location

when user moves to a location, which bytes to read from a file.?

if all locations occupy the same length then, in same order then.
we can figure out offset0-29 and location length(30 bytes) and then
sequentially traverse.

startByte = (n-1) * 30;

this is when the offsets and lengths are same.
when the length differs and offset we need an index.

The index stores the offset and record length for each location, include locationID as well

first , get index record for the location
use index values, and read the location data values.

each index record has to be same length.

Index contains:
a unique identifier, for each data record

the offset of the record and the length of the record=12bytes.

Index contains:
location id, location offset, record length which matches the typical case.

location record will always be longer than 12 bytes.
so index will be smaller than location's data.

read index from a file when user moves to a new location
or load entire index into memory when the application starts.

ideally, we want to load index into memory.
accessing memory is much faster than accessing files on disk.
this provides better performance.

size of index record is smaller than size of data records.
if index is large, then don't load index into memory.
in case the files are random access.

*/






