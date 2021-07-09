package com.umartariq;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Location.java created by umartariq on 25/06/2020
 * 4:32 PM inside the package - com.umartariq
 */
public class Location implements Serializable {
    //since LinkedHashMap Implements Serializable , we dont need to override read and write methods.
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //if we comment this serialVersionUID program will throw an IOexception
    //this is because when it starts reading, it generates a id for compiled classes
    //and uses that.. but we want to use this serialVersionUID.

    //we also have to add InvalidClassException, when we comment this.

    private long serialVersionUID = 1L;


    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        if (exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>();
        }

        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);

    }

    //addExit method as protected
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }


}
