package com.umartariq;

/**
 * StaticMethodTest.java created by umartariq on 20/06/2020
 * 5:36 PM inside the package - com.umartariq
 */
public class StaticMethodTest {
    // private int numInstances = 0;// instance variable
    private static int numInstances = 0;//^^ changed to static variable
    private String name;

    public StaticMethodTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
