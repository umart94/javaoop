package com.umartariq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    //HeavenlyBody can be either A Planet OR A Moon
    //A moon is considered a natural satellite because it orbits around a planet
    //A Solar System consists of a Set Of Planets and it's natural satellites i.e moons
    //orbital period is in days
    //private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        //HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        HeavenlyBody temp = new Planet("Mercury", 88);//subclass
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);



        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        /*planets.add(temp);
        planets.add(temp);
        planets.add(temp);
        planets.add(temp);
        planets.add(temp); WILL ADD ONLY ONCE !
        planets.add(temp);
        planets.add(temp);
*/
        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter",HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        HeavenlyBody body2 = solarSystem.get(HeavenlyBody.makeKey("Mars",HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body2.getKey());
        for(HeavenlyBody jupiterMoon: body2.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        //Union of two sets moons and planets - is a set containing all elements of the two sets
        //each element in union will only appear once
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());//SET UNION
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        //HeavenlyBody pluto = new Planet("Pluto",842);

        //HeavenlyBody pluto = new DwarfPlanet("Pluto",842);
        HeavenlyBody pluto = new Planet("Pluto",842);


        /*HeavenlyBody pluto = new HeavenlyBody("Pluto", 842) {
        };*/
       /* planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        planets.add(pluto);
        */
        for(HeavenlyBody planet : planets) {

            //System.out.println(planet.getKey() + " : " + planet.getOrbitalPeriod());
            System.out.println(planet);//overriden toString in Planet Class
        }
        //pluto appears twice.. while they are not equal w.r.t orbital period
        //Set cant contain equal objects. its a condition
        //equals method in java by default, from base object class defines referential equality
        //i.e if both references point to the same object they are equal , otherwise they are not
        //you can test it by adding pluto twice above
        //i.e
        //planets.add(temp);
        //planets.add(temp);
        //on any 1 same planet object..

        //Override equals method here
        Object obj = new Object();
        obj.equals(obj);
        "pluto".equals("");//Ctrl+Click on function to see actual method definition in java sdk
       /* public boolean equals(Object obj){
            return (this == obj);
        }*/

       /*
       String class equals
       if heavenlybody is subclassed... the equals will return true if it's subclass objects are used
       //we will need to check for subclass objects as well while implementing overriding equals

       //IF two objects are equal.. their HashCode must also be same
       //so we need to override hashCode method as well

       public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (!COMPACT_STRINGS || this.coder == aString.coder) {
                return StringLatin1.equals(value, aString.value);
            }
        }
        return false;
    }
        */


       /*
       Add 6 objects to collection
       Each Object Has a hashCode
       if Object 1 hashCode is equal to Object 2 hashCode then they are both equal objects. AND WILL GO IN THE SAME BUCKET

        if hashCode for new object is not the same as [[OBJECTS INSIDE THE BUCKET]].. WE WONT ADD IT INSIDE BUCKET

        New Object == object 6 or not ?
        hashCode of new Object indicates to Bucket 2
        every hashCode of every object in bucket 2 will be compared with hashCode of New Object to be entered

        if hashCode is different . then object will not be added and it will be deemed as a duplicate
        While removing object there is a potential error of deleting some other object with the same hashCode

        so in summary - Two Objects Are Equal If They Have The Same HashCode


        */

        /*
       HeavenlyBody Sirius = new HeavenlyBody("Sirius",100);
       HeavenlyBody Sirius2 = new HeavenlyBody("Sirius",200);
       HeavenlyBody Sirius3 = new HeavenlyBody("Siriu33s",200);
        DwarfStars YellowDwarf = new DwarfStars("Sun",300);
       DwarfStars BlueGiant = new DwarfStars("PistolStar",400);

       if(Sirius.equals(Sirius2)){
           System.out.println("These two objects are equal");
       } else if(!Sirius.equals(Sirius2)){
           System.out.println("Objects Not Equal");
       }

        if(Sirius.equals(Sirius3)){
            System.out.println("These two objects are equal");
        } else if(!Sirius.equals(Sirius3)){
            System.out.println("Objects Not Equal");
        }
        //subclass
       if(Sirius.equals(YellowDwarf)){
           System.out.println("TRUE");
       } else if(!Sirius.equals(YellowDwarf)){
           System.out.println("FALSE");
       }

       //subclass
        if(Sirius2.equals(BlueGiant)){
            System.out.println("TRUE");
        } else if(!Sirius2.equals(BlueGiant)){
            System.out.println("FALSE");
        }

        //subclass with itself

        if(YellowDwarf.equals(BlueGiant)){
            System.out.println("TRUE");
        } else if(!YellowDwarf.equals(BlueGiant)){
            System.out.println("FALSE");
        }

*/

        HeavenlyBody earth1 = new Planet("Earth",365);
        HeavenlyBody earth2 = new Planet("Earth",365);
        HeavenlyBody earth3 = new Planet("12345",67890);
        System.out.println("Equality Check");
        System.out.println( (earth1.equals(earth2)) ? "Earth1EqualToEarth2"+earth1.toString(): " Nope --" );
        System.out.println(earth2.equals(earth1) ? "Earth2EqualToEarth1"+earth2.toString() : " Nope --");
        System.out.println(earth1.equals(earth3) ? "Earth1EqualToEarth3"+earth3.toString() : " Nope --");
        System.out.println(earth3.equals(earth3) ? "Earth3EqualToEarth3"+earth3.toString() : " Nope --");

        solarSystem.put(pluto.getKey(),pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto",HeavenlyBody.BodyTypes.PLANET)));
        //since you removed the dwarf planet code line.. this println should return null
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto",HeavenlyBody.BodyTypes.DWARF_PLANET)));
        System.out.println("==================================== Solar System ================================================");
        //HashMaps are intrinsically unordered and cannot be sorted
        for(HeavenlyBody object : solarSystem.values()){
            System.out.println(object);
        }

        System.out.println("==================================== Solar System ================================================");
    }
}















//A collection that contains no duplicate elements. NO ORDERING
// More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), and at most one null element.
// As implied by its name, this interface models the mathematical set abstraction.

//keys In a Map (keySet)
//Items in a set

//HashSet class implements the Set interface,
// backed by a hash table (actually a HashMap instance).
// It makes no guarantees as to the iteration order of the set; in particular,
// it does not guarantee that the order will remain constant over time. This class permits the null element.

        /*
        More On HashSet
        This class offers constant time performance for the basic operations (add, remove, contains and size), assuming the hash function disperses the elements properly among the buckets. Iterating over this set requires time proportional to the sum of the HashSet instance's size (the number of elements) plus the "capacity" of the backing HashMap instance (the number of buckets). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

Note that this implementation is not synchronized. If multiple threads access a hash set concurrently, and at least one of the threads modifies the set, it must be synchronized externally. This is typically accomplished by synchronizing on some object that naturally encapsulates the set. If no such object exists, the set should be "wrapped" using the Collections.synchronizedSet method. This is best done at creation time, to prevent accidental unsynchronized access to the set:

   Set s = Collections.synchronizedSet(new HashSet(...));
The iterators returned by this class's iterator method are fail-fast: if the set is modified at any time after the iterator is created, in any way except through the iterator's own remove method, the Iterator throws a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.

This class is a member of the Java Collections Framework.
         */

//HashSet is better performance wise
