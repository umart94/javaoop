package com.umartariq;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Locations.java created by umartariq on 21/06/2020
 * 1:42 PM inside the package - com.umartariq
 */
public class Locations implements Map<Integer,Location> {


    private static Map<Integer,Location> locations = new HashMap<Integer, Location>();



    //for any number of instances of locations class, there will only be 1 static locations HashMap
    static {
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



    }


    public static void main(String[] args) {
        FileWriter locationsFile = null;
        try {

            locationsFile = new FileWriter("locations.txt");



            //locationsFile = null;//finally exception is catched
            /*
            in finally block
            Exception in thread "main" java.lang.NullPointerException
	at com.umartariq.Locations.main(Locations.java:85)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)
             */


            for (Location location : locations.values()) {
                //this will create a locations.txt file, in the project root folder
                locationsFile.write(location.getLocationID() + "," + location.getDescription()+"\n");

            }
            //always close the fileWriter outside a loop
            //if there is an error in the loop, then code jumps to the close filewriter method and then exception is raised


        }catch(IOException e){
            //checked and unchecked exceptions
            //IOException is a checked exception
            //a checked exception cannot be ignored.
            //we need to catch the IOException
            System.out.println("Cannot read the File Supplied.");
            //this ioexception is raised when the file has improper permissions
            //i.e it can't be read by current user account
            //or the file does not exist
            //or the partition has no access
            //or we can't overwrite the file
            //or it is owned by some other usergroup

            //to catch it, we made a folder named exactly locations.txt

            //it gives FileNotFoundException (subclass of IOException )
            /*
            Cannot read the File Supplied.
java.io.FileNotFoundException: locations.txt (Access is denied)
	at java.base/java.io.FileOutputStream.open0(Native Method)
	at java.base/java.io.FileOutputStream.open(FileOutputStream.java:291)
	at java.base/java.io.FileOutputStream.<init>(FileOutputStream.java:234)
	at java.base/java.io.FileOutputStream.<init>(FileOutputStream.java:123)
	at java.base/java.io.FileWriter.<init>(FileWriter.java:66)
	at com.umartariq.Locations.main(Locations.java:81)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)
in finally block
             */


            e.printStackTrace();//this prints
        } finally{
            System.out.println("in finally block");
            //finally block will run after catch block
            //so we check if locations file object is null, if not null then we close it, and we catch the same ioexception here

            //if this code was in the first try block, it would abruptly end
            try {
                if(locationsFile!=null) {
                    System.out.println("Attempting to close FileWriter");
                    locationsFile.close();
                }
            }catch(IOException e){
                    e.printStackTrace();//this will print if the FileWriterObject is null
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
