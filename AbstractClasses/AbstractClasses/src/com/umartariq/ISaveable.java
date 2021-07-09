package com.umartariq;



import java.util.List;

//write method that returns a list of items
//using ArrayList is again concrete
//use List for abstraction so the classes can use any type of List

    public interface ISaveable {
        List<String> write();
        void read(List<String> savedValues);
    }



