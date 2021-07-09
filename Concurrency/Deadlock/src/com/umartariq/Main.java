package com.umartariq;

/**
 * Main.java created by umartariq on 13/09/2020
 * 6:58 PM inside the package - com.umartariq
 * in the java project Deadlock using IDE IntelliJ IDEA
 */

/*
Deadlock occurs when two or more threads are blocked on locks
every thread that is blocked is holding a lock, that another blocked thread wants
for example,

thread 1 is holding lock 1 and waiting to acquire lock 2

thread 2 is holding lock 2 and waiting to acquire lock 1

because the threads are blocked
they will never release the locks they are holding
and so none of the threads will actually ever run




 */
public class Main{

    //create two objects that we are going to be using for our locks. - these will be static variables.

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread = new Thread1();
        Thread2 thread2 = new Thread2();
        thread.start();
        thread2.start();
        /*
        Thread1 : Has LOCK1
        Thread2 : Has LOCK2
        Thread1: Waiting for LOCK2
        Thread2: Waiting for LOCK1

        if the threads obtain the locks in different order, we get a deadlock
        if they obtain the locks in same order, we do not get a deadlock.

         */

    }
    private static class Thread1 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread1 : Has LOCK1");
                try{
                    Thread.sleep(100);

                }catch(InterruptedException e){

                }
                System.out.println("Thread1: Waiting for LOCK2");
                synchronized (lock2){
                    System.out.println("Thread1: Has LOCK1 and LOCK2");
                }
                System.out.println("Thread 1: Released LOCK2");
            }
            System.out.println("Thread1: Released LOCK1. Exiting");
        }
    }

   /* private static class Thread2 extends Thread {
        public void run(){
            synchronized (lock2){
                System.out.println("Thread2 : Has LOCK2");
                try{
                    Thread.sleep(100);

                }catch(InterruptedException e){

                }
                System.out.println("Thread2: Waiting for LOCK1");
                synchronized (lock1){
                    System.out.println("Thread2: Has LOCK2 and LOCK1");
                }
                System.out.println("Thread 2: Released LOCK1");
            }
            System.out.println("Thread2: Released LOCK2. Exiting");
        }
    }*/

    private static class Thread2 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread2 : Has LOCK1");
                try{
                    Thread.sleep(100);

                }catch(InterruptedException e){

                }
                System.out.println("Thread2: Waiting for LOCK2");
                synchronized (lock2){
                    System.out.println("Thread2: Has LOCK1 and LOCK2");
                }
                System.out.println("Thread 2: Released LOCK2");
            }
            System.out.println("Thread2: Released LOCK1. Exiting");
        }
    }

}

