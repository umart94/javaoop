package com.umartariq;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Locations.java created by umartariq on 25/06/2020
 * 4:32 PM inside the package - com.umartariq
 */
public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer,IndexRecord> index = new LinkedHashMap<Integer,IndexRecord>();
    private static RandomAccessFile readRandomAccessFileObject;
    /*
    File Format:
    1. The first four bytes will contain the number of locations. (bytes 0-3)
    2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    3. The next section of the file will contain the index ( the index is 1692 bytes long. It will start at byte 8 and end at 1699
    4. The final section of the file will contain the location records ( the data). It will start at byte 1700.
    */

    static {
        try{
            readRandomAccessFileObject = new RandomAccessFile("locations_rand.dat","rwd");
            int numLocations = readRandomAccessFileObject.readInt();
            long locationStartPoint = readRandomAccessFileObject.readInt();

            while(readRandomAccessFileObject.getFilePointer() < locationStartPoint){
                int locationId = readRandomAccessFileObject.readInt();
                int locationStart = readRandomAccessFileObject.readInt();
                int locationLength = readRandomAccessFileObject.readInt();

                IndexRecord record = new IndexRecord(locationStart,locationLength);
                index.put(locationId,record);
            }
        }catch (IOException e){
            System.out.println("IOException in Static Initializer Block : "+e.getMessage());
        }
    }










    public static void main(String[] args) throws IOException {
        //when a file is first created or opened, the filepointer is at 0
        //we don't have to call seek method, initially.


        //rwd mode indicates that we want to open the file for reading and writing
        //and we want the read write to occur synchronously.
        //if we don't do this, multiple threads can access the file
        //we will be responsible to handle the thread synchronization.

         try(RandomAccessFile writeLocationsToFileObject = new RandomAccessFile("locations_rand.dat","rwd")){
             writeLocationsToFileObject.writeInt(locations.size());
             //each index Record will contain 3 integers.
             //the locationID, offset for the location , and the size or length of location record.

             int indexSize = locations.size() * 3 * Integer.BYTES;
             int locationStart = (int) (indexSize + writeLocationsToFileObject.getFilePointer() + Integer.BYTES);//gives offset
             writeLocationsToFileObject.writeInt(locationStart);
             long indexStart = writeLocationsToFileObject.getFilePointer();

             int startPointer = locationStart;
             writeLocationsToFileObject.seek(startPointer);

             for(Location location : locations.values()){
                 writeLocationsToFileObject.writeInt(location.getLocationID());
                 writeLocationsToFileObject.writeUTF(location.getDescription());
                 StringBuilder builder = new StringBuilder();
                 for(String direction : location.getExits().keySet()){
                     if(!direction.equalsIgnoreCase("Q")){
                         builder.append(direction);
                         builder.append(",");
                         builder.append(location.getExits().get(direction));
                         builder.append(",");

                     }
                 }
                 writeLocationsToFileObject.writeUTF(builder.toString());
                    IndexRecord indexRecord = new IndexRecord(startPointer,(int)(writeLocationsToFileObject.getFilePointer() - startPointer));
                    index.put(location.getLocationID(),indexRecord);
                    startPointer = (int) writeLocationsToFileObject.getFilePointer();

             }

             writeLocationsToFileObject.seek(indexStart);

             for(Integer locationID : index.keySet()){
                 writeLocationsToFileObject.writeInt(locationID);
                 writeLocationsToFileObject.writeInt(index.get(locationID).getStartByte());
                 writeLocationsToFileObject.writeInt(index.get(locationID).getLength());

             }

         }

    }//end main

    public Location getLocation(int locationId) throws IOException{
        IndexRecord record = index.get(locationId);
        readRandomAccessFileObject.seek(record.getStartByte());
        int id = readRandomAccessFileObject.readInt();
        String description = readRandomAccessFileObject.readUTF();
        String exits = readRandomAccessFileObject.readUTF();
        String[] exitPart = exits.split(",");
        //create a new location
        Location location = new Location(locationId,description,null);
        if(locationId != 0){
            for(int i=0;i<exitPart.length;i++){
                System.out.println("exitPart = "+exitPart[i]);
                System.out.println("exitPart[+1] "+ exitPart[+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction,destination);
            }
        }
        return location;
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

    public void close() throws IOException{
        readRandomAccessFileObject.close();
    }
}

