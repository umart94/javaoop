package com.umartariq;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main.java created by umartariq on 24/09/2020
 * 7:42 PM inside the package - com.umartariq
 * in the java project filesystem using IDE IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {

        //we will extend java.nio path interface
        //in linux filesystem we have / , ~ , home directories etc. and other file systems
        //in windows we have drive letters, e.g C:\ , D:\ , these are root node in a full path.
        //each folder is also a node in a path
        //then there is a path for a file
        /*
        absolute path is C:\downloads\file.txt , because it starts at a root node
        relative path is for e.g files\photos\1234.jpg
        because it doesnt specify a root node
        it does not contain enough information to identify the file
        it would have to be combined with another path that does contain a root node.

        //in using relative paths , we have to use pwd - working directory that we can combine with relative paths.

        when running an app from intellij idea , the current user directory is the idea project directory
        so that is the working directory for filesystem object
        the working directory is then combined with path we passed to getpath call

        file will be created in idea project directory.

        e.g
        Path dataPath = FileSystems.getDefault().getPath("data.txt"); //relative path
        Path dataPath = Paths.get("C:\\MyProjects\\Project1\\data.txt"); //absolute path


*/
        //Path path = FileSystems.getDefault().getPath("workingdirectory.txt");//working
        //Path filepath = FileSystems.getDefault().getPath("files","subdirectory.txt");//subdirectory
       Path filepath = Paths.get("D:\\",
               "github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\filesystem\\files\\","subdirectory.txt");
       //subdirectory
        //current directory , files directory , file name
        //working dir,+ subdir+  filename
      //  printFile(filepath);








        Path filepath2 =Paths.get("\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\outsideproject.txt");
        //outside project
        Path filepath4 = Paths.get("D:\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\filesystem" +
                "\\workingdirectory.txt");
       // printFile(filepath4);

//printFile(Paths.get("D:\\github\\programming\\javaoop\\InputOutput\\NIOFilesystem\\filesystem\\workingdirectory
// .txt"));

        Path currentWorkingDirectory = Paths.get(".");
        System.out.println(currentWorkingDirectory.toAbsolutePath());

       // Path path2 = FileSystems.getDefault().getPath(".","files","..","files","subdirectory.txt");
       // printFile(path2);
       // System.out.println(path2.normalize().toAbsolutePath());
       // printFile(path2.normalize());


        //until we actually access the file, the path is abstract.
        //when we read the file and file does not exist then the exception is thrown.
        //to create a file the directory has to exist.
        Path path3 = FileSystems.getDefault().getPath("notexists.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = FileSystems.getDefault().getPath("D:\\","abcdef","notexists.txt");
        System.out.println(path4.toAbsolutePath());

        Path path5 = FileSystems.getDefault().getPath("files");
        System.out.println("exists = "+ Files.exists(path5));
        System.out.println("exists = "+ Files.exists(path4));
        System.out.println("exists = "+ Files.exists(path3));

        try{
            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples","file1copied.txt");
            Files.copy(sourceFile,copyFile);

        }catch(IOException e){
            e.printStackTrace();
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
