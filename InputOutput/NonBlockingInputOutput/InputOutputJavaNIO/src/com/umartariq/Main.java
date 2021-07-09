package com.umartariq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {
	/*java.nio is an improvement to java i/o because the classes in the
	package perform I/O in a non-blocking manner. java.nio was also meant to fix
	some of the problems developers could run into when using java.io classes to work with file system.

	Blocking I/O

Blocking IO wait for the data to be write or read before returning. Java IO's various streams are blocking. It means when the thread invoke a write() or read(), then the thread is blocked until there is some data available for read, or the data is fully written.

Non blocking I/O

Non blocking IO does not wait for the data to be read or write before returning. Java NIO non- blocking mode allows the thread to request writing data to a channel, but not wait for it to be fully written. The thread is allowed to go on and do something else in a mean time.

Stream Oriented

Java IO is stream oriented I/O means we need to read one or more bytes at a time from a stream. It uses streams for transferring the data between a data source/sink and a java program. The I/O operation using this approach is slow.

Let's see the flow of data using an input/output stream in a java program:


Buffer Oriented

Java NIO is buffer oriented I/O approach. Data is read into a buffer from which it is further processed using a channel. In NIO we deal with the channel and buffer for I/O operation.

The major difference between a channel and a stream is:

    A stream can be used for one-way data transfer.
    A channel provides a two-way data transfer facility.

Therefore with the introduction of channel in java NIO, the non-blocking I/O operation can be performed.

Let's see the interaction between channel, buffers, java program, data source and data sink:
	 */

	/*
	we have two buckets:
	1. those that deal with the file system
	2. those that deal with reading and writing data.

	 */


	/*
	when using classes in java.io package , a thread will block while it is waiting to read or write to a stream or buffer.

	threads using java.nio classes will not block. they are free to continue executing, so java.nio was introduced as performance improvement.

	java.io classes work with streams (character or binary)
	data is read one byte or character at a time and sometimes buffered. depending on which classes are used

	when using java.nio data is dealt with in blocks
	and rather than processing one byte or character at a time, one block will be processed at a time.

	to accomplish this we use channels or buffers.

	 */


        //if two object instances that we serialize, point to the same object.
        //serialize foo class, field of bar object.
        //if we serialize two instances of foo class
        //will the file contain 2 bar objects, or just 1.
        //the file will only contain one bar object.
        // a serialized file will only contain 1 copy of the instance.
        //if the number of files increases from 1 to 2
        //then there will be 2 bar objects.
        //the bar objects will increase as number of files increases.



        //startByte = (n-1) * 30;



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






