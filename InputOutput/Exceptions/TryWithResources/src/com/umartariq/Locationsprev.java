package com.umartariq;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Locations.java created by umartariq on 21/06/2020
 * 3:08 PM inside the package - com.umartariq
 */



public class Locationsprev implements Map<Integer,Location> {
    private static Map<Integer,Location> locations = new HashMap<Integer, Location>();
    static {
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
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

    }

    /*
   catch or specify - checked exceptions
    */

    //we are specifying that main method throws IOException , the caller must catch this IOException
    //so we delete the catch block , as well as all other catch blocks
    public static void main(String[] args) throws IOException{
        FileWriter locationsFile = null;
        try {
            locationsFile = new FileWriter("locations.txt");
            for (Location location : locations.values()) {

                locationsFile.write(location.getLocationID() + "," + location.getDescription()+"\n");
                //throw new IOException("Test Exception thrown while writing");
                /*
                in finally block
Attempting to close FileWriter
Exception in thread "main" java.io.IOException: Test Exception thrown while writing
	at com.umartariq.Locations.main(Locations.java:58)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)
                 */
            }
        }/*catch(IOException e){
            System.out.println("Cannot read the File Supplied.");
            e.printStackTrace();
        } */finally{
            //we could have deleted the finally block, since we used throws on the main method
            //but we want to do some additional processing, (e.g checking the filewriter or any other objects are null or not and closing them
            //so we keep try block with finally block directly, and pass the throws method to the main method
            //so the main method will deal with catching the IOException
            System.out.println("in finally block");
            //try {
            if(locationsFile!=null) {
                System.out.println("Attempting to close FileWriter");
                locationsFile.close();
            }
            // }/*catch(IOException e){
            //   e.printStackTrace();
            // }*/
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
