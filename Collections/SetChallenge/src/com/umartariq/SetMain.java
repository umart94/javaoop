package com.umartariq;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        //sets Symmetry and Asymmetry
        //Bulk Operations
        /*
s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
s1.addAll(s2) — transforms s1 into the union of s1 and s2. (The union of two sets is the set containing all of the elements contained in either set.)
s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. (The intersection of two sets is the set containing only the elements common to both sets.)
s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)


         */
        //perform intersection , difference , check if 1 set is subset of another etc.

        Set<Integer> squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for (int i = 1; i <=100 ; i++) {
                squares.add(i*i);
        }
        for (int j = 1; j <=100 ; j++) {
            cubes.add(j*j*j);
        }
        System.out.println("There are  " + squares.size() + "  squares and   "+  cubes.size() +  " cubes . ");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union of SQUARES AND CUBES ==== (SET CALLED union) contains  "+ union.size() + " elements. ");
        System.out.println(union);
        System.out.println("*********************************");
        System.out.println(cubes);
        System.out.println("*********************************");
        System.out.println(squares);

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);//RetainAll for Intersection......  addAll for Union
        System.out.println("Intersection of SQUARES AND CUBES ==== (SET CALLED Intersection) contains  "+ intersection.size() + " elements. ");
        System.out.println(intersection);
        for (int i: intersection) {
            System.out.println("  integer   "+i+"   is the square of  "+ Math.sqrt(i) + "   And the Cube of  "+Math.cbrt(i));

        }


        Set<String> words = new HashSet<>();
        String sentence = "One Day in the year 2020";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for(String s : words){
            System.out.println(s);//returns words of the String sentence without order

        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        String[]  sentence1 = {"my","name","is","umar","i","am","programming","in","java"};
        set1.addAll(Arrays.asList(sentence1));
        String[]  sentence2 = {"i","am","developing","a","project","in","java"};
        set2.addAll(Arrays.asList(sentence2));

        System.out.println("set1  -   set2");//ITEMS IN SET1 BUT NOT IN COMMON AND NOT IN SET2
        Set<String> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);
        printSet(diff1);


        System.out.println("set2  -   set1");//ITEMS IN SET2 BUT NOT IN COMMON AND NOT IN SET1
        Set<String> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);
        printSet(diff2);

        Set<String> unionOfSet1AndSet2 = new HashSet<>(set1);
        unionOfSet1AndSet2.addAll(set2);
        Set<String> InterSectionOfSet1AndSet2 = new HashSet<>(set1);
        System.out.println("InterSectionOfSet1AndSet2 I.E Items in the middle.. common  ");//COMMON Intersection
        InterSectionOfSet1AndSet2.retainAll(set2);
        printSet(InterSectionOfSet1AndSet2);


        System.out.println("Symmetric Difference  ");
        unionOfSet1AndSet2.removeAll(InterSectionOfSet1AndSet2);//Union - Intersection = Symmetric Difference ... All the Left.. and all the right... but not the common elements
        printSet(unionOfSet1AndSet2);

        if( (set1).containsAll(set2)){
            System.out.println("set2 is a subset of set1");
        }

        if( (set1).containsAll(InterSectionOfSet1AndSet2)){
            System.out.println("InterSectionOfSet1AndSet2 is a subset of set1");
        }

        if( (set2).containsAll(InterSectionOfSet1AndSet2)){
            System.out.println("InterSectionOfSet1AndSet2 is a subset of set2");
        }



    }
    private static void printSet(Set<String> set){
        System.out.println("\t");
        for(String s: set){
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
