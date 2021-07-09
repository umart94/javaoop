package com.umartariq;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Main.java created by umartariq on 24/09/2020
 * 7:42 PM inside the package - com.umartariq
 * in the java project filesystem using IDE IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {


        Path directory = FileSystems.getDefault().getPath("Examples\\Dir2");



//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                //if it is a regular directory, it will show all files in the path
//                //else if it is some other file type .. like a file instead of a directory
//                //it will cause error
//               return (Files.isRegularFile(entry));
//            }
//        };

        //DirectoryStream.Filter with a Lambda Expression
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);






        //try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,"*.dat")){
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)){
            //returns directory stream of paths, its an interface that implements iterable interface.
            //we can add filters
            //glob
            //similiar to regular expression , but geared more towards paths.

            // * -   character matches any strings
            // *.dat -    matches any path with the .dat extension
            // *.{dat,txt} -   match any path that has extension .dat or .txt
            // ? - matches exactly one character for e.g glob ??? would match any path that contains exactly three
            // characters.

            //myfile* matches any paths that begin with myfile
            //b?*.txt matches any paths that are atleast two characters long and begin with the character b ( the ?
            // forces a second character , and the * matches 0 or more characters)


            for(Path file : contents){
                System.out.println(file.getFileName());
            }

            //pipe exception - bitwise inclusive or.
        }catch(IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }
    }
    private static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while((line = fileReader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
