package com.umartariq;

/**
 * FinalKeywordTest.java created by umartariq on 20/06/2020
 * 5:52 PM inside the package - com.umartariq
 */
//public class FinalKeywordTest extends Math{ error
public class FinalKeywordTest{

    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public FinalKeywordTest(String name){
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + "created, instance is "+ instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
