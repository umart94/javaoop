package com.umartariq;

import java.util.HashMap;
import java.util.Map;

//immutable classes increase encapsulation
//



public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    //this constructor will crash at runtime with NullPointerException. if null is passed instead of a map
    public Location(int locationID, String description,Map<String,Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //this.exits = new HashMap<String,Integer>();

        //whenever you use new keyword to create an instance always check for null first
        //i.e user can pass null value inside the constructor so check for null here
        if(exits!= null){
            this.exits = new HashMap<String,Integer>(exits);
        } else{
            this.exits = new HashMap<String,Integer>();
        }

        this.exits.put("Q",0);
    }


    //UP IS NORTH
    //DOWN IS SOUTH
    //LEFT IS WEST
    //RIGHT IS EAST

   /* public void addExit(String direction,int location){
        exits.put(direction,location);
    }

    */

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);//instead of exits map, pass and create and return a new HashMap that has all the mappings from the previous exits map.. nothing outside the class can change the previous exits map


    }


}
