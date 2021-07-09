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

        //in windows , we use backslash to seperate a path segment.
        //in linux we use forward slash
        //when using paths and using regular expressions or globs
        //we assume that we are on a single OS
        //so we can use file seperators
        //getDefaultSeperator Method of the current OS.
        //to keep consistency.

        //instead of using hardcode seperator, use the File.seperator that will get the OS default file seperator
        Path directory = FileSystems.getDefault().getPath("Examples"+File.separator+"Dir2");
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


            for(Path file : contents){
                System.out.println(file.getFileName());
            }
            //pipe exception - bitwise inclusive or.
        }catch(IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        //file seperators
        String seperator = File.separator;
        System.out.println(seperator);
        seperator = FileSystems.getDefault().getSeparator();
        System.out.println(seperator);

       // try{
          //  Path tempFile = Files.createTempFile("myapp",".appext");
           // System.out.println("temp file path == "+tempFile.toAbsolutePath());
       // }catch (IOException e){

      //  }

        //Filestores - drives
        //on unix system, each mounted system is a file store
        //on windows each drive is a file store.


            Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
            for(FileStore store : stores){
                //System.out.println("file store== " + store.name());//work on unix systems
                System.out.println("volume name / drive letter==  "+store);//works on windows
            }

            Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
            for(Path path : rootPaths){
                System.out.println(path);//only drive letters printed on windows
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
