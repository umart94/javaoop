package com.umartariq;

public class Main {

    public static void main(String[] args) {
        //Multiple Threads Program

        //To Demonstrate the Concept Of Race Condition / Thread Interference... we will now pass two seperate Countdown Objects to the threads

        //Countdown countdown1 = new Countdown();
        //Countdown countdown2 = new Countdown();
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
        /*

Thread 2: i = 10
Thread 2: i = 9
Thread 2: i = 8
Thread 2: i = 7
Thread 2: i = 6
Thread 2: i = 5
Thread 2: i = 4
Thread 2: i = 3
Thread 2: i = 2
Thread 2: i = 1
Thread 1: i = 10
Thread 1: i = 9
Thread 1: i = 8
Thread 1: i = 7
Thread 1: i = 6
Thread 1: i = 5
Thread 1: i = 4
Thread 1: i = 3
Thread 1: i = 2
Thread 1: i = 1





         */


        //We get no interference since we are using two countdown objects
        //But this is not practical
        //because in a real world scenario for e.g a Bank.. we cannot provide 2 different objects to Threads
        //or if employee data has to be changed... we must provide the same employee object

        //we need to allow multiple threads to change 1 single object while avoiding thread interference / race condition
        //The Solution To This Problem is Synchronization

        //When a thread is executing a synchronized method inside the class .. that thread will be suspended until 1 thread has completely written / updated a heap object
        //this synchronized methods will prevent race condition... but then the method has to be synchronized
        //other methods that are not synchronized will generate race condition / thread interference


/*
When we used two objects - thread 2 executed first
but when we use synchronized function... thread 1 executed completely before thread 2 and we will get the same output every time program runs

Thread 1: i = 10
Thread 1: i = 9
Thread 1: i = 8
Thread 1: i = 7
Thread 1: i = 6
Thread 1: i = 5
Thread 1: i = 4
Thread 1: i = 3
Thread 1: i = 2
Thread 1: i = 1
Thread 2: i = 10
Thread 2: i = 9
Thread 2: i = 8
Thread 2: i = 7
Thread 2: i = 6
Thread 2: i = 5
Thread 2: i = 4
Thread 2: i = 3
Thread 2: i = 2
Thread 2: i = 1





 */


/*
We cannot synchronize Constructors - because

a constructor initializes object values with different values - and its purpose is to initialize an object..
until the constructor runs... the object has not been initialized.. and so it does not make sense to syncrhonize a constructor

but we can synchronize any other method
 */



/*
We can also synchronize an entire block of java statements - this is 2nd approach for solution of thread interference

Every java object has intrinsic lock
it is a monitor

we can synchronize a block of statements that work with an object by forcing threads to acquire the object's lock before they execute the statement block

Only 1 Thread Can "Hold"" / Access an Object's Lock At a Time so
other threads that want the lock will be suspended until the running thread releases it

then one and only 1 waiting thread can get the lock and execute it

the only code that we have to synchronize here is the for loop in our case
 */
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
    //public synchronized void doCountdown(){ -APPROACH 1 - synchronized doCountdown function with SAME COUNTDOWN INSTANCE
    public  void doCountdown(){ //APPROACH 2 synchronized block with color object... and for loop within it
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

        //synchronized(color){ error..
        synchronized(this){//changed color to this
            //we still get thread interference
            //the problem is we are using local variable color -- this color local variable reference is stored in thread stack,values stored in heap
            //each stack creates copy of local object and seperate lock and seperate references
            //when we want to synchronize.. we NEED TO USE 1 SAME OBJECT BEING USED BY THREADS SO THAT THE SAME INTRINSIC LOCK IS BEING ACCESSED




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

        //end synchronized block |
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