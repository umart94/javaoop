package com.umartariq;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        if(languages.containsKey("Java")){
            System.out.println("Java is already in the Map");
        } else {
            languages.put("Java","a compiled , High Level, Object Oriented, Platform-Independent Language");
            System.out.println("java added successfully");

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        languages.put("C","C is a general-purpose, procedural computer programming language supporting structured programming");
        languages.put("Python","Python is an interpreted, high-level, general-purpose programming language.");
        languages.put("Kotlin","Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference.");
        languages.put("C#","C# is a general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming");
        languages.put("Dart","Dart is a client-optimized[8] programming language for apps on multiple platforms. It is developed by Google and is used to build mobile, desktop, server, and web applications.[9]\n" +
                "\n" +
                "Dart is an object-oriented, class-based, garbage-collected language with C-style syntax.[10] Dart can compile to either native code or JavaScript. It supports interfaces, mixins, abstract classes, reified generics, and type inference.[11]");
        languages.put("Go","Go (incorrectly known as Golang,[14]) is a statically typed, compiled programming language designed at Google[15] by Robert Griesemer, Rob Pike, and Ken Thompson.[12] Go is syntactically similar to C, but with memory safety, garbage collection, structural typing,[6] and CSP-style concurrency.[16]\n" +
                "\n" +
                "There are two major implementations:\n" +
                "\n" +
                "Google's self-hosting[17] compiler toolchain targeting multiple operating systems, mobile devices,[18] and WebAssembly.[19]\n" +
                "gccgo, a GCC frontend.[20][21]\n" +
                "A third-party transpiler GopherJS[22] compiles Go to JavaScript for front-end web development.");

        System.out.println(languages.get("Go"));
        languages.put("Go","A programming language developed by Google");
        System.out.println(languages.get("Go"));

        System.out.println(languages.put("Go","abcd"));
        System.out.println(languages.get("Go"));
        if(languages.containsKey("Go")){
            System.out.println("Go is already in the Map");
        } else {
            languages.put("Go","this course is about Go Language");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("===============================");


        languages.remove("Python");
        /*if(languages.remove("C#","C# ki key ki wrong value")){
            System.out.println("C# removed");
        } else{
            System.out.println("C# not removed, key/value pair not found");
        }
*/

            /*for(String key: languages.keySet()){
            System.out.println(key+"  :  "+languages.get(key));
        }*/

        //System.out.println(languages.replace("C#","Azure Apps, Windows Phone Apps Etc."));//THIS WILL NOT RUN
        if(languages.replace("C#","C# is a general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming","azure")){
            System.out.println("C# Value Replaced.. New Value Is "+languages.get("C#"));
        } else{
            System.out.println("C# not REPLACED, old key/value pair DOES NOT MATCH NEW key/value pair");
        }
    }
}
