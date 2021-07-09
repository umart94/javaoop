package com.umartariq;

/**
 * StaticTest.java created by umartariq on 20/06/2020
 * 5:22 PM inside the package - com.umartariq
 */
public class StaticTest {

   // private int numInstances = 0;// instance variable
    private static int numInstances = 0;//^^ changed to static variable
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
