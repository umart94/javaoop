package com.umartariq;

import java.util.HashMap;
import java.util.Map;

/**
 * Location.java created by umartariq on 24/06/2020
 * 3:38 PM inside the package - com.umartariq
 */
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;


    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;

        if (exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
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
        return new HashMap<String, Integer>(exits);

    }

    //addExit method as protected
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }


}
