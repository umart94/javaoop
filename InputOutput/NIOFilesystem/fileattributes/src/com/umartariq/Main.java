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
        try{

            //creating files and directories.
            //creating files because we want to write something to it.. create a stream / channel.
               // Path fileToCreate = FileSystems.getDefault().getPath("Examples","fileCreated.txt");
               // Files.createFile(fileToCreate);

                //directory to create
           // Path directoryToCreate = FileSystems.getDefault().getPath("Examples","DIR4");
           // Files.createDirectory(directoryToCreate);

            //directories to create with hierarchy
             Path directoryStructureToCreate = FileSystems.getDefault().getPath("Examples","Dir2\\Dir3\\Dir4\\Dir5" +
                     "\\Dir6");
             Files.createDirectories(directoryStructureToCreate);

             //get a file's attributes
            //file metadata
            Path fileMetadataretrieval = FileSystems.getDefault().getPath("Examples","Dir1/file1.txt");
            long size = Files.size(fileMetadataretrieval);
            //System.out.println("Size = " + size);
            //System.out.println("Last Modified = "+ Files.getLastModifiedTime(fileMetadataretrieval));

            //get all the attributes of a file in a single line of code.

            BasicFileAttributes attrs = Files.readAttributes(fileMetadataretrieval,BasicFileAttributes.class);
            System.out.println("size==   "+attrs.size());
            System.out.println("creationTime==  "+attrs.creationTime());
            System.out.println("lastAccessTime==  "+attrs.lastAccessTime());
            System.out.println("lastModifiedTime== "+attrs.lastModifiedTime());
            System.out.println("isDirectory==   "+attrs.isDirectory());
            System.out.println("isRegularFile==  "+attrs.isRegularFile());


        }catch(IOException e){
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
