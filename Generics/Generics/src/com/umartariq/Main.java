package com.umartariq;

import java.util.ArrayList;

public class Main {

    //this code is reminiscent of prior to java 1.5 versions
    //the way of coding was to not explicitly define data types at start in arraylist declaration
    //after 1.5 v generics were introduced
    public static void main(String[] args) {
        //ArrayList<> items = new ArrayList<>();
	ArrayList<Integer> items = new ArrayList<Integer>();
	items.add(1);
	items.add(2);
	//items.add("tim");//wont work... list must have same data types added to it
	items.add(4);
	items.add(5);
	printDoubled(items);

    }

    public static void printDoubled(ArrayList<Integer> items){
        /*for (Object item: items) {
            System.out.println("Number : "+ (Integer)item*2);

        }*/
        for (int item: items) {
            System.out.println("Number : "+ item*2); // no need of data cast

        }

    }
}
