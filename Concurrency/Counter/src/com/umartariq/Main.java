package com.umartariq;

public class Main {

    public static void main(String[] args) {
        //Multiple Threads Program


        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

//default - accessible only within the same package
class Countdown {
    private int i;
    //this i is a thread variable
    //heap is shared by all threads - it belongs to process
    //threadStack is owned by thread - only that thread can access it.. thread 1 cant access thread 2 stack.. but both can access the heap
    //Each thread has its own copy of the thread variable i - the local variable
    //memory required to stored instance value is allocated on the heap
    //countdown object has 1 same instance .. that is passed to both the seperate threads t1 and t2

    //first we used i variable as a local variable inside for loop
    //then we made it a class level instance variable

    //when i was local,jvm allocated space.. and used threadStack.. each thread had a SEPERATE copy of i on their own stack

    //since threads share the heap... they dont have their own copy of i when we made i an instance variable
    //thread 1 suspended.. and thread 2 sees the same value of i ... it does not have thread 2 instance... in other words.. variable i is being shared through the HEAP of JVM Application Process

    //

    //maps thread name with its color
    public void doCountdown(){
        String color;
        //string in switch statement.. my jdk is 13...works 7 and onwards
        switch(Thread.currentThread().getName()){
            case "Thread 1" :
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2" :
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;

        };

        for (i = 10; i >0 ; i--) {//int i here, will duplicate each loop counter variable twice ... now make it private so its printed once only
            System.out.println(color+Thread.currentThread().getName()+ ": i = "+i);
            //Thread can be suspended at any step of the loop initialize;step;counter

            //Suspension Points
            //Thread can be suspended before decrement
            //Thread can be suspended before condition
            //or Thread can be suspended before printing out the value

            /*
Thread 1: i = 10
Thread 2: i = 10
Thread 1: i = 9
Thread 2: i = 8
Thread 1: i = 7
Thread 2: i = 6
Thread 1: i = 5
Thread 2: i = 4
Thread 1: i = 3
Thread 2: i = 2
Thread 1: i = 1

thread 1 was suspended when i=9
and thread 2 decremented the value of i to 8

this is Called Thread Interference
Also Called a Race Condition - Two Or More Threads are writing to / updating a shared resource

https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
             */

        }
        //we can't predict the order in which the loop statement is executed, for the 2 threads

    }

}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
            threadCountdown = countdown;
    }

    public void run(){
        threadCountdown.doCountdown();
    }
}