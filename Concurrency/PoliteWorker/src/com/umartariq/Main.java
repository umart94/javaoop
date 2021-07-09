package com.umartariq;

/**
 * Main.java created by umartariq on 21/09/2020
 * 10:59 AM inside the package - com.umartariq
 * in the java project PoliteWorker using IDE IntelliJ IDEA
 */
public class Main {

    /*
    live lock is similiar to deadlock
    instead of thread being blocked they are active and wait for others to complete the task
    thread a will loop until b completes it task and b will loop until a completes its task
    this is a live lock condition
    waiting but blocked.

    thread is going to see whether it has a shared resource.
    if it does not, it will wait for 10 seconds
    loop back
    and then check again whether it acquired the resource.

    complete when threads have used the shared resource
    and the other thread is not active.


livelock  - none of the threads can run
     */

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource,worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource,worker1);
            }
        }).start();

    }

    /*
    slipped condition
    race condition
    thread interference

    thread can be suspended between reading a condition and acting upon that condition
   1. check the status
   2. if it is ok read data from buffer
   3. if data is EOF, it sets status to EOF and terminates, if data isnt EOF it sets the status to ok.


   if we havent synchronized the code properly the following can happen :
   1. thread1 checks the status and gets ok. it suspends.
   2. thread2 checks the status and gets ok. it reads eof from buffer and sets status to eof then terminates.
   3. thread1 runs again it tries to read data from buffer but theres no data. it throws exception or crashes.


     */



}
