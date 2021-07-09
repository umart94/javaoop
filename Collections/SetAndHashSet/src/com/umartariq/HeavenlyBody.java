package com.umartariq;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

   public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
   }

   public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
   }
   //we need to override equals and hashCode methods
    /*
    hashCode
    public int hashCode()
Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap.
The general contract of hashCode is:

Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers for distinct objects. (This is typically implemented by converting the internal address of the object into an integer, but this implementation technique is not required by the JavaTM programming language.)

Returns:
a hash code value for this object.
     */


    /*
    equals
    public boolean equals(Object obj)
Indicates whether some other object is "equal to" this one.
The equals method implements an equivalence relation on non-null object references:

It is reflexive: for any non-null reference value x, x.equals(x) should return true.
It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
For any non-null reference value x, x.equals(null) should return false.
The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).

Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.

Parameters:
obj - the reference object with which to compare.
Returns:
true if this object is the same as the obj argument; false otherwise.
See Also:
hashCode(), HashMap
     */

/*
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    this is the method that is in java sdk.. for Object class
    we need to override it exactly with Object Class object.. and NOT WITH our custom HeavenlyBody Object.. Otherwise it would be Overloading
*/
    @Override
    public boolean equals(Object obj){
        //check if object is being compared to itself.. will return true
        // obj1 == obj2 in memory (being compared to)
        if(this == obj){
            return true;
        }

        System.out.println("obj.getClass() is  "+obj.getClass());
        System.out.println("this.getClass() is  "+this.getClass());

        //make sure that subclasses do not equal object ( classes extending class.. but the object is of that subclass
        //this should return false.. as object is not equal to subclass object. ( classes are different even though its a subclass)
        if((obj ==null) || (obj.getClass() != this.getClass())){
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        //if the name string property of this object.... is the same string and equal to the name of the object passed in this method..
        //then return boolean true value.. and both objects are equal.
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        //comparision is for only name of the object in this case

        //return super.hashCode();
        //return this.name.hashCode();//not a good practice... object hashCode will be different to hashCode of the string property of object
        System.out.println("** hashCode Called **");
        System.out.println(this.name.hashCode());
        System.out.println(this.name.hashCode()+57);
        return this.name.hashCode()+57;

    }
}
