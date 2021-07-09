package com.umartariq;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main.java created by umartariq on 26/09/2020
 * 10:40 AM inside the package - com.umartariq
 * in the java project walkfiletree using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {

/***************Traverse and Print File Tree*****************/
            //FileVisitor Interface.

            /*  System.out.println("Walking tree for Examples dir");
            Path examplesDirPath = FileSystems.getDefault().getPath("Examples");
            try{
                Files.walkFileTree(examplesDirPath,new PrintNames());
            }catch (IOException e){
                System.out.println(e.getMessage());
            }*/
        /***************Traverse and Print File Tree*****************/




        /***************Copy Entire File Tree*****************/
//        System.out.println("in examples dir -- copy dir2 to dir4/dir2copy");
//        Path source = FileSystems.getDefault().getPath("Examples"+File.separator+"Dir2");
//        Path destination = FileSystems.getDefault().getPath("Examples"+File.separator+"DIR4"+File.separator+"dir2copy");
//        try{
//            Files.walkFileTree(source,new CopyFileTree(source,destination));
//        }
//        catch(IOException e){
//            System.out.println(e.getMessage());
//        }


        /***************Copy Entire File Tree*****************/


        /****************** Mapping Java File Methods to NIO methods ************/
            File file = new File("D:\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\walkfiletree" +
                    "\\Examples\\fileCreated.txt");
            Path convertedPath = file.toPath();
        System.out.println("convertedPath == "+convertedPath);

        File parent = new File("D:\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\walkfiletree\\Examples");
        File resolvedFile = new File(parent,"Dir1\\file1.txt");
        System.out.println(resolvedFile.toPath());//mapping file path to a nio path class toPath method..

        Path parentPath = Paths.get("D:\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\walkfiletree\\Examples");
        Path childRelativePath = Paths.get("Dir1\\file1.txt");
        System.out.println(parentPath.resolve(childRelativePath));


        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("working dir "+workingDirectory.getAbsolutePath());

        File dir2File = new File(workingDirectory,"\\Examples\\Dir1");
        //using file.list method

//        String[] dir2Contents = dir2File.list();
//        for (int i=0;i<dir2Contents.length;i++){
//            System.out.println(dir2Contents[i]);
//        }

        //using file.listFiles method, returns file array.

                File[] dir2Contents = dir2File.listFiles();
        for (int i=0;i<dir2Contents.length;i++){
            System.out.println(dir2Contents[i].getName()+dir2Contents[i].getAbsolutePath());
        }

        /****************** Mapping Java File Methods to NIO methods ************/



    }
}
