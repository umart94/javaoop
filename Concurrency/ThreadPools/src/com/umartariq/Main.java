package com.umartariq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import static com.umartariq.Main.EOF;
/**
 * Main.java created by umartariq on 13/09/2020
 * 10:38 AM inside the package - com.umartariq
 * in the java project ThreadPools using IDE IntelliJ IDEA
 */

/*
ExecutorService Interface
this is also found in utilconcurrent package
used so that we dont have to explicitly create and start threads
it also manages thread scheduling, and also optimizes the creation of threads
which can generally be expensive in terms of performance and memory
we still have to provide runnable methods, because we have to actually code the tasks we want to create
BUT
WE DO NOT MANAGE ANY THREADS BY OURSELVES
ExecutorService Implementations allow us to focus on the code we want to run, without managing threads and their
lifecycles.


we create an implementation of ExecutorService
give it the task we want to run
without worrying about details about how the tasks will be run

this will use Thread Pools

A Thread pool is a managed set of threads
it reduces the overhead of thread creation especially in applications that use a large number of threads

a thread pool may also limit the number of threads that are active, running in blocked at any particular time.
when using certain types of thread pools , an application can create excessive number of threads.

in java we use threadpools using ExecutorService Implementations.
we can implement our own thread pool by implementing a class that implements one of the thread pool interfaces.

by doing so , we can then configure how underlying thread pool is managed

its recommended that we use the implementations provided by JVM

since thread pools can limit the number of active threads, its possible that when we ask the server to run a task
it wont be able to run it straight away

e.g if MAXTHREADS = 20, there maybe 20 active threads when we submit the task.
in that case the task would have to wait on the services queue, until one of the active threads actually terminates.

ExecutorService extends Executor Interface which only has one method, execute.

the execute method is replacement of this code:

 (new Thread(runnable)).start();

 WITH THIS CODE

        ex.execute(runnable);

Sub interfaces offer more functionalities than the base interface.
we have to use factory methods when implementing executorservice in a class.

A Fixed ThreadPool means that - there is only ever going to be a specific number of threads available to process
tasks at any one time. if all threads are busy , and tasks are being submitted, those will have to wait in queue until
the threads in fixed thread pool have finished executing.








Thread Pools
Most of the executor implementations in java.util.concurrent use thread pools, which consist of worker threads. This kind of thread exists separately from the Runnable and Callable tasks it executes and is often used to execute multiple tasks.

Using worker threads minimizes the overhead due to thread creation. Thread objects use a significant amount of memory, and in a large-scale application, allocating and deallocating many thread objects creates a significant memory management overhead.

One common type of thread pool is the fixed thread pool. This type of pool always has a specified number of threads running; if a thread is somehow terminated while it is still in use, it is automatically replaced with a new thread. Tasks are submitted to the pool via an internal queue, which holds extra tasks whenever there are more active tasks than threads.

An important advantage of the fixed thread pool is that applications using it degrade gracefully. To understand this, consider a web server application where each HTTP request is handled by a separate thread. If the application simply creates a new thread for every new HTTP request, and the system receives more requests than it can handle immediately, the application will suddenly stop responding to all requests when the overhead of all those threads exceed the capacity of the system. With a limit on the number of the threads that can be created, the application will not be servicing HTTP requests as quickly as they come in, but it will be servicing them as quickly as the system can sustain.

A simple way to create an executor that uses a fixed thread pool is to invoke the newFixedThreadPool factory method in java.util.concurrent.Executors This class also provides the following factory methods:

The newCachedThreadPool method creates an executor with an expandable thread pool. This executor is suitable for applications that launch many short-lived tasks.
The newSingleThreadExecutor method creates an executor that executes a single task at a time.
Several factory methods are ScheduledExecutorService versions of the above executors.
If none of the executors provided by the above factory methods meet your needs, constructing instances of java.util.concurrent.ThreadPoolExecutor or java.util.concurrent.ScheduledThreadPoolExecutor will give you additional options.



 */




public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();

        //ExecutorService
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        MyProducer producer = new MyProducer(buffer,ThreadColor.YELLOW,bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer,ThreadColor.GREEN,bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer,ThreadColor.BLACK,bufferLock);

        /******change this********/
       // new Thread(producer).start();
       // new Thread(consumer1).start();
       // new Thread(consumer2).start();
        /******change this********/



        /********to this code************/
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        //we have to terminate the application manually
        //the two consumer threads report that they are exiting and also producer thread exited

            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(ThreadColor.GREEN_BOLD + "i'm being printed for the callable class");
                    return "this is the callable result";
                    //callable has to wait until other threads are finished.

                    //our application will be frozen until the result is available. , dont use in UI app
                    //use javafx concurrent package, use util.concurrent package for ui apps.


                }
            });

            try {
                System.out.println(future.get());
        }catch(ExecutionException e){
                System.out.println("something went wrong");
            }catch(InterruptedException e){
                System.out.println("thread running the task was interrupted");
            }






        //executor service did not shut down
        // we need to call the executor service shut down method.



        executorService.shutdown();
        //the service waits for executing tasks to terminate
        //we can also NOT ACCEPT ANY NEW TASKS
        //this is called an orderly shutdown
        //better to execute orderly shutdown.


        //if we call shutdownNow
        //this will throw away any tasks in the queue and halt all currently executing tasks.

        //we receive a value back from a thread that we are executing in background
        //we can use the submit method
        //this method accepts a callable object, that can return a value
        //of type future.

        //we cant use it in this class
        //we can create an anonymous class to show how this works.

        //this will be done before shutdown and after execution of tasks.




        /********to this code************/

    }
}

class MyProducer implements Runnable{

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for(String num : nums){
            try{
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try{
                    buffer.add(num);
                } finally{
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color+"Adding EOF and exiting...");
        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally{
            bufferLock.unlock();
        }
    }
}
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer,String color,ReentrantLock bufferLock){
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;

    }
    public void run(){
        int counter = 0;
        while(true){

            if(bufferLock.tryLock()){
                try{
                    if(buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color+ " the counter = " + counter);
                    counter = 0;
                    if(buffer.get(0).equals(EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed"+buffer.remove(0));
                    }
                }finally{
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }


    }
}
