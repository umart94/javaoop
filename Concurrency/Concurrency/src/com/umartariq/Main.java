package com.umartariq;

import static com.umartariq.ThreadColor.*;


public class Main {

    public static void main(String[] args) {

        /******** PROCESS  ***/
        //A process is a unit of execution
        //process has it's own memory space (heap)
        //each instance of jvm runs as a process
        //each console app is a process
        //each javaFX app is a process
        /******** PROCESS    ***/

        /******** HEAP***/
        //process / application same word
        //as each process has its own heap (memory space)
        //one java application cannot access another java applications heap
        /******** HEAP***/



        /******* THREAD *****/
        //Thread is a unit of execution inside a process
        //Each Process Can Have Multiple Threads
        //Every Process or Application in java has atleast 1 thread
        //This 1 Main Thread for UI Applications is called JavaFX application Thread

        //Every Java Process has multiple system threads
        //these handle tasks like memory management and I/O
        //We Don't Explicitly Code Those Threads
        //Our Code Runs On The Main Thread
        //Or In Other Threads That We Explicitly Create
        /******* THREAD *****/

        /*********CREATION OF THREAD (SIDE NOTE)****/
        //creating threads does not require as much resources as creating a process
        //a thread created by a process shares the process's memory and files
        //This CAN CREATE A LOT OF PROBLEMS


        /****** THREAD STACK ****/

        //In addition to a process's memory or heap
        //Each Thread Also Has What's Called a Thread Stack
        //This Thread Stack Is the memory that only the thread can access


        /***** SUMMARY ****/
        /* Each Java Application Runs as a Single Process
        Each Process Can Have Multiple Threads
        Every Process Has a Heap
        Every Thread Has a Thread Stack
         */


        /** Why Use Multiple Threads In An Application ? **/

        /*
        1. A Task That Will Take a Lot Of Time ( Database call, website data scraping)
        Code within each thread executes in a linear fashion
        so that thread wont be able to do anything else while it's waiting for data
        i.e EXECUTION OF MAIN THREAD WILL BE SUSPENDED
        Instead of working on main thread
        we can create another thread
        and execute the long running task on that thread
        this would free up the main thread
        2. 2ND REASON is that an API requires us to provide a thread
        sometimes we have to provide code that will run when a method we have called
        reaches a certain point in it's execution
        in this instance we usually dont create the tread
        we pass in the code that we want to run on the thread
         */

        /*** CONCURRENCY WHAT IS IT ? ****/

        /*
        CONCURRENCY Refers to An Application Doing more than 1 thing at a time
        example ( application wants to download data and draw a shape on the screen)
        If it's a concurrent application, it can download a bit of data
        then switch to drawing a part of shape
        then switch back to downloading more data
        switch back to drawing more of shape
        concurrency means that one task doesnt have to complete before
        another can start
        Java provides Thread Related classes so we can create concurrent applications
         */

        System.out.println(ANSI_PURPLE+"Hello from the main thread");
        //Method 1 - Create a thread instance
        //Method 2 - Create instance of Thread Subclass

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        // will run the run method from thread
        //use the run / start method only once
        //anotherThread.run();//it will display Hello from main !
        anotherThread.start();//it will display Hello from == Another Thread == with the currentThread Name
        //anotherThread.start();//will throw illegalthreadstateexception















        //for executing the thread again.. we have to create a new instance of this class again and run start again

        /*Thread thirdThread = new AnotherThread();
        thirdThread.start();//returns Hello from Thread-1

        Thread fourthThread = new AnotherThread();
        fourthThread.start();//returns Hello from Thread-2
*/
        //we can never be sure about the order in which threads execute .. unless we give them priority
        //System.out.println(ANSI_PURPLE+"Hello from the main thread");

        //we can also use an anonymous class if we want to execute a thread only once

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from anonymous class thread");


            }
        }.start();

        //Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread( new MyRunnable() {
            @Override
            public void run(){
                System.out.println(ANSI_RED+"Hello from Anonymous Class MyRunnable's implementation of run()");
                //it's overriding the run method in MyRunnable

                try{
                    //MyRunnable thread cannot execute until anotherThread has completely executed and finished ..
                   // anotherThread.join(5000);//5000 ms = 5 second timeout.. to indicate that thread is taking a lot of time
                    //since thread timed out we have to indicate this to the user
                    //error downloading etc.
                    //setPriority() is dependent on JDK..
                    anotherThread.join();//Since MyRunnable can also get interrupted, we wrap this in a try catch with interrupted exception
                    //anotherThread will sleep, then run statement at its end
                    //anotherThreadTerminatedHere.. and MyRunnable Continues After The Join
                    System.out.println(ANSI_RED+"Another Thread Terminated OR TIMED OUT !, So Now MyRunnable is Running Again");
                }catch(InterruptedException e){
                    System.out.println(ANSI_RED+"I WAS INTERRUPTED");
                }
            }
        });
        myRunnableThread.start();
        //myRunnableThread.interrupt();
        //anotherThread.interrupt();//This Interrupts Thread
        System.out.println(ANSI_PURPLE+"Hello again from the main thread");


        //mainThread uses ANSI_PURPLE
        //anotherThread uses ANSI_BLUE
        // anonymousThread uses ANSI_GREEN
        //MyRunnable uses ANSI_RED

        //a thread is terminated as soon as the run method ends.. ..
        // implement run method.. and do not call it directly
        //java jdk calls the run method
        //if you execute run method, app will not crash but instead of running code in run method in new thread, it will run it on the same previous thread

        //instead use the start method, and only once


    }
}
