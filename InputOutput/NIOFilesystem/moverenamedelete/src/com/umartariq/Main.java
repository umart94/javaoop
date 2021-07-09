package com.umartariq;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

/**
 * Main.java created by umartariq on 24/09/2020
 * 7:42 PM inside the package - com.umartariq
 * in the java project filesystem using IDE IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        try{
//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples","file1copied.txt");
//            //Files.copy(sourceFile,copyFile);
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            //way to copy directory.
//            Path sourceDirectory = FileSystems.getDefault().getPath("Examples","Dir1");
//            Path copyDirectory = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceDirectory,copyDirectory, StandardCopyOption.REPLACE_EXISTING);
            //this will not copy the files inside the directory.
            //we will have to traverse the file tree.


//            //move files
//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1copied.txt");
//            Path fileMovedTo = FileSystems.getDefault().getPath("Examples","Dir1","file1moved.txt");
//            Files.move(sourceFile,fileMovedTo);

//                        //rename files
//            Path fileToRename = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.move(fileToRename,destination);

            //delete file


            Path fileToDelete = FileSystems.getDefault().getPath("Examples","file2.txt");

            Files.delete(fileToDelete);



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
