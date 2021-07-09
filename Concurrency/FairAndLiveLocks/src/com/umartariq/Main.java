package com.umartariq;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Main.java created by umartariq on 21/09/2020
 * 10:11 AM inside the package - com.umartariq
 * in the java project FairAndLiveLocks using IDE IntelliJ IDEA
 */

public class Main {
    /*
        fair locks are first come first serve.
        reentrant lock implementation allows us to create fair locks.


        first, make the static object for lock as reentrant lock.


     */
    private static ReentrantLock lock = new ReentrantLock(true);
    //true means that we're setting the lock up using first come first serve logic. ( so it will be a fair lock )
    //only fairness in acquiring the lock is guaranteed , not fairness in thread scheduling.
    //if task on a thread takes a long time , threads still wait for a long time to run using fair locks

    //try lock method will not be firstcomefirst serve

    //performance is impacted due to extra layer that manages which thread gets the lock.


    




    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

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
                lock.lock();
                try{
                    System.out.format(threadColor+"%s : runCount = %d\n", Thread.currentThread().getName(),runCount++);
                    //EXECUTE critical section of the code.
                    //we are going to create a worker object for each thread
                    //so there is no interference

                }finally {

                    lock.unlock();
                }


            }
        }
    }
}
