package com.umartariq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Locations.java created by umartariq on 21/06/2020
 * 4:10 PM inside the package - com.umartariq
 */
public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations = new HashMap<Integer, Location>();

    static {

        //Same problem of reading a text file
        //now we use bufferedreader
        //BufferedReader reads text from input stream and buffers character into a character array
        //we create a filereader, and use filereader as input stream for bufferedreader

        //when we read files from Hard disk the seek time increases
        //overhead of seeking to correct sector on diskdrive
        //we have to find correct place to read from
        //seek time increase on filereaders and streams
        //bufferedreader creates a buffer, and reads data

        /*
        Reading of data depends on the format of data
        we have UTF-8 format of data

        Primitive Data Types
A primitive data type specifies the size and type of variable values, and it has no additional methods.

There are eight primitive data types in Java:

Data Type	Size	Description
byte	1 byte	Stores whole numbers from -128 to 127
short	2 bytes	Stores whole numbers from -32,768 to 32,767
int	4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float	4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double	8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits
boolean	1 bit	Stores true or false values
char	2 bytes	Stores a single character/letter or ASCII values



        1 byte = 8 bits.
        a byte is 1 byte = 8 bits in java
        a char is 2 bytes = 16 bits in java
        an int is 4 bytes = 32 bits in java

        FileInputStream reads 1 byte at a time
        FileReader Reads 2 bytes or 4 bytes (depending on the charset)
        BufferedReader default buffersize is 8192 characters. with linesize of 80

        DEFAULT BEHAVIOUR OF BUFFEREDREADER IS THAT IT READS "CHARACTER" DATA
        IT WILL NOT READ BYTE DATA. IT CONVERTS IT TO CHARACTER DATA

        So In Short:
        Instead of reading 1byte=8bits or 2bytes=16bits from I/O again and again as in FileInputStream or FileReader
        BufferedReader reads 8192 characters of data inside a char array, so that harddisk seek operations are not used excessively.



        http://www.docjar.com/html/api/java/io/BufferedReader.java.html

As per this java documentation, default buffer size is 8192 characters capacity. Line size is considered as 80 chars capacity.

8192 buffer size is sufficient for smaller file sizes. But again this is growable. if file contains more than 8192 characters, then fill method of bufferedreader will increase the buffer size before reading content from file. For bigger content files preferably set your own max size to buffer while creating buffered reader through constructor, so that you can avoid recreating memory and copying the old array into newly created array.



         */


        /*
        Improvement of BufferedReader Over Streams and FileReader :
        First, You should understand "streaming" in Java because all "readers" in Java are built on this concept.






File Streaming
File streaming is carried out by the FileInputStream object in Java.

// it reads a byte at a time and stores into the 'byt' variable
int byt;
while((byt = fileInputStream.read()) != -1) {
    fileOutputStream.write(byt);
}
This objects actually reads a byte(8-bits) at a time and writes it to the given file.

A practical useful application of it would be to work with raw binary/data files, such as images or audio files (use AudioInputStream instead of FileInputStream for audio files). On the other hand for text files, it is very inconvenient and slower, because of looping through a byte at a time, then do some processing and store the processed byte back is tedious and time-consuming.

You also need to provide the character-set of the text file, i.e if the characters are in Latin or Chinese, etc. Otherwise, the program would decode and encode 8-bits at a time and you'd see weird chars printed on the screen or written in the output file (if a char is more then 1 byte long).





File Reading
This is just a fancy way of saying "File streaming" with inclusive charset support (i.e no need to define the charset, like earlier).

The FileReader class is specifically designed to deal with text files. As you've seen earlier, the file Streaming is best to deal with raw binary data, but for the sake of text, it is not that efficient.

So the Java-dudes added the FileReader class, to deal specifically with the text files. It reads 2 bytes (or 4 bytes, depends on the charset) at a time. A remarkably huge improvement over the preceding FileInputStream!!

so the streaming operation is like this,

int c;
while ( (c = fileReader.read()) != -1) { // some logic }
Please note, Both classes use an integer variable to store the value retrieved from the input file (so every char is converted into an integer while fetching and back to the char while storing).

The only advantage here is that since this class deals with the text files, so you don't have to specify the text file's charset and a few other properties. It basically provides an out-of-the-box solution, for most of the text files processing cases. It also supports internationalization and localization.

But again it's still too slow (Imaging reading 2 bytes at a time and looping through it!).





Buffering streams
To tackle the problem of continuous looping over a byte or 2. The Java-dudes added another spectacular functionality. "To create a buffer of data, before processing."

The concept is pretty much alike when a user streams a video on YouTube. A video is buffered before playing, in order to provide a flawless video watching experience. (Tho, the browser keeps buffering until the whole video is buffered ahead of time.) The same technique is used by the BufferedReader class.

The BufferedReader object takes a FileReader object as an input which contains all the necessary information about the text file that needs to be read. (such as the file path and charset.)

BufferedReader br = new BufferedReader( new FileReader("example.txt") );
When the "read" instruction is given to the BufferedReader object, it uses the FileReader object to read the data from the file. When an instruction is given, the FileReader object reads 2 (or 4) bytes at a time and returns the data to the BufferedReader and the reader keeps doing that until it hits '\n' or '\r\n' (The end of the line symbol). Once a line is buffered, the reader waits patiently, until the instruction to buffer the next line is given.

Meanwhile, The BufferReader object creates a special memory place (On the RAM), called "Buffer", and stores all the fetched data from the FileReader object.

// this variable points to the buffered line
String line;

// Keep buffering the lines and print it.
while ((line = br.readLine()) != null) {
    printWriter.println(line);
}
Now here, instead of reading 2 bytes at a time, a whole line is fetched and stored in the RAM somewhere, and when you are done with processing the data, you can store the whole line back to the hard disk. So it makes the process run way faster than doing 2 bytes a time.

But again, why do we need to pass FileReader object to the BufferReader? Can't we just say "buffer this file" and the BufferReader would take care of the rest? wouldn't that be sweet?

Well, the BufferReader class is created in a way that it only knows how to create a buffer and to store incoming data. It doesn't matter the to object where the data is coming from.

So being said that, When you provide the FileReader object as an input, it buffers the file, the same way if you provide the InputStreamReader as an object, it buffers the Terminal/Console input data until it hits a new line symbol. such as,

// Object that reads console inputs
InputStreamReader console = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(console);
System.out.println(br.readLine());
This way, you can read (or buffer) multiple streams with the same BufferReader class, such as text files, consoles, printers, networking data etc, and all you have to remember is,

 bufferedReader.readLine();
to print whatever you've buffered.

         */


        /*
        When even BufferedReader is slow

        The only thing BufferedReader does is read from the underlying Reader into an internal char[] buffer with a default size of 8K, and all methods work on that buffer until it's exhausted, at which point another 8K (or whatever) is read from the underlying Reader. The readLine() is sort of tacked on.

Correct use of BufferedReader should definitely not result in the running time rising from 40sec at 1.8m lines to 30 minutes at 3m lines. There must be something wrong with your code. Show it to us.

Another possibility is that your JVM does not have enough heap memory and spends most of the 30 minutes doing garbage collection because its heap is 99% full and you'd eventually get an OutOfMemoryError with larger input. What are you doing with the lines you have processed? Are they kept in memory? Does running the program with the -Xmx 1024M command line option make a difference?
         */
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int location = scanner.nextInt();
                scanner.skip(scanner.delimiter());//skip over the comma, we don't want comma in the variables, that would crash program.
                String description = scanner.nextLine();
                System.out.println("Imported location: " + location + ": "+ description);
                Map<String,Integer> tempExit = new HashMap<String, Integer>();
                locations.put(location,new Location(location,description,tempExit));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(scanner!=null){
                scanner.close();
            }
        }

        //now read exits
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){

                /* int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());//skip over the comma, we don't want comma in the variables, that would crash program.
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());//skip over the comma, we don't want comma in the variables, that would crash program.
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);*/

                //instead of doing this with seperate variables
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": "+ direction + ": "+destination);
                //Map<String,Integer> tempExit = new HashMap<String, Integer>();
                //locations.put(location,new Location(location,dest,tempExit));

                Location location = locations.get(loc);
                location.addExit(direction,destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            /*
            close method of BufferedReader
            private Reader in;
            private char cb[];
            private static int defaultCharBufferSize = 8192;
    private static int defaultExpectedLineLength = 80;

            public BufferedReader(Reader in, int sz) {
        super(in);
        if (sz <= 0)
            throw new IllegalArgumentException("Buffer size <= 0");
        this.in = in;
        cb = new char[sz];
        nextChar = nChars = 0;
    }

            public void close() throws IOException {
        synchronized (lock) {
            if (in == null)
                return;
            try {
                in.close();
            } finally {
                in = null;
                cb = null;
            }
        }
    }

             */


            if(scanner!=null){
                scanner.close();
            }
        }




        //multi line comment, Ctrl+Shift+ForwardSlash
   /*     Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
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
*/
    }



    public static void main(String[] args) throws IOException {

        /*try(FileWriter locationsFile = new FileWriter("locations.txt"); //java 7 syntax
            FileWriter directionsFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locationsFile.write(location.getLocationID() + "," + location.getDescription()+"\n");
                for(String direction : location.getExits().keySet()){
                    directionsFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }

        }
        */




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
        return locations.put(key,value);
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
