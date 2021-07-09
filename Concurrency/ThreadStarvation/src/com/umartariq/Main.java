package com.umartariq;

/**
 * Main.java created by umartariq on 13/09/2020
 * 7:31 PM inside the package - com.umartariq
 * in the java project ThreadStarvation using IDE IntelliJ IDEA
 */
public class Main {
    //starvation means that threads do not have the oppurtunity to run and progress.
    //this occurs due to thread priority.
    //when we assign a high priority to a thread
    //try and run a thread before other waiting threads.

    //when there is more than one thread waiting for a lock
    //threads can block on a lock first
    //its possible that thread wont be  able to run first.

    //add a lock object
    private static Object lock = new Object();
    //add a worker class as an inner class of the main class




    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

       /* t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2); */

       /* t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start(); */

        t3.start();
        t2.start();
        t5.start();
        t4.start();
        t1.start();

        //we are passing different worker thread objects.
        //but the lock object is static
        //there is only 1 instance of lock object.
        //all the threads will be competing for one instance of that lock.

        //for deadlocks - the order in which the locks are held and released is important
        //for thread starvation - the order in which they are executed is important.
        //we cant guarantee a first come first serve.

        




    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor){
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            //count from 1 to 100
            for(int i=0;i<100;i++){
                synchronized (lock){
                    System.out.format(threadColor+"%s : runCount = %d\n", Thread.currentThread().getName(),runCount++);
                    //EXECUTE critical section of the code.
                    //we are going to create a worker object for each thread
                    //so there is no interference

                }
            }
        }
    }
}
