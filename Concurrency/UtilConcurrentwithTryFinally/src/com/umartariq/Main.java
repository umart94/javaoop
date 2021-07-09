package com.umartariq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.umartariq.Main.EOF;










//Producer Consumer Problem using java.util.List as the buffer
public class Main {

    /*
    lock and unlock calls are scattered throughout code
    code can be error prone and difficult to maintain

    locks should be used in recommended way
    enclose critical sections in try finally block

    we would then only need to call unlock once.
    we also catch any exception that occurs
     */




    //Reentrant locks do not have limitations of the Synchronized Blocks
    /*
    A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor lock accessed using synchronized methods and statements, but with extended capabilities.
A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread. The method will return immediately if the current thread already owns the lock. This can be checked using methods isHeldByCurrentThread(), and getHoldCount().

The constructor for this class accepts an optional fairness parameter. When set true, under contention, locks favor granting access to the longest-waiting thread. Otherwise this lock does not guarantee any particular access order. Programs using fair locks accessed by many threads may display lower overall throughput (i.e., are slower; often much slower) than those using the default setting, but have smaller variances in times to obtain locks and guarantee lack of starvation. Note however, that fairness of locks does not guarantee fairness of thread scheduling. Thus, one of many threads using a fair lock may obtain it multiple times in succession while other active threads are not progressing and not currently holding the lock. Also note that the untimed tryLock method does not honor the fairness setting. It will succeed if the lock is available even if other threads are waiting.

     */
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();
        //if thread holds this ReentrantLock lock.. and code enters portion that requires this same lock - the code can continue execution - without a exception
        //code does not have to obtain the lock again
        //not all implementations are reentrant !
        //we are going to share this lock with producer and consumer... all threads have to compete with same lock to prevent thread interference
        //pass the lock to producer and consumer instances

        MyProducer producer = new MyProducer(buffer,ThreadColor.YELLOW,bufferLock);//pass buffer to all three instances
        MyConsumer consumer1 = new MyConsumer(buffer,ThreadColor.GREEN,bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer,ThreadColor.BLACK,bufferLock);

        new Thread(producer).start();//Exception in thread "Thread-1" java.lang.Error: Maximum lock count exceeded
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        //ArrayList is not synchronized
        //methods have to finish otherwise there will be thread interference - 3 threads sharing same buffer



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

                /*synchronized (buffer) {
                    buffer.add(num);
                }

                 */
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
        /*synchronized (buffer) {
            buffer.add("EOF");
        }*/
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

    /*
    thread can test to see whether a lock is available using
    tryLock method, if lock is available the thread will acquire the lock
    and continue executing, if its not available, the thread wont block
    and alternatively can execute some other code.



     */

    public void run(){
        int counter = 0;
        while(true){
           //synchronized (buffer) {}
            //bufferLock.lock();
            if(bufferLock.tryLock()){
                //lock is available, we get lock automatically
                //execute critical section of the code.


                try{
                    if(buffer.isEmpty()){//arraylist isempty method
                    //if the buffer is empty, loop exits and starts again
                        continue;

                    }
                    //calculate how many times trylock returns false
                    //when there is finally data inside buffer
                    //we return true. and reset counter.
                    //after this isEmpty check , we know that we have data in buffer.
                    System.out.println(color+ " the counter = " + counter);
                    //now reset counter to 0
                    //outside the block, if trylock returns false, just increment counter using else.

                    counter = 0;

                    if(buffer.get(0).equals(EOF)){//loop until EOF is reached.

                        System.out.println(color + "Exiting");

                        break;
                    } else {
                        //this can be suspended - if isempty returns false
                        System.out.println(color + "Removed"+buffer.remove(0));//EOF will not be removed, otherwise other consumer threads would loop indefinitely
                        //the condition buffer.get(0).equals(EOF) would never be true otherwise

                    }
                }finally{
                    bufferLock.unlock();
                    //unlock method will not release count until the max lock count reaches 0

                    //in consumer code, we hit the lock method so many times that the max lock count is reached
                    //and the unlock method needs lock count to be 0

                    //Exception in thread "Thread-1" java.lang.IllegalMonitorStateException

                    //buffer.unlock() is being called each time
                    //but when using try finally we only need to call unlock once.
                    //this is because the call to lock is outside the try finally
                    // and unlock calls are now in try finally
                    //so we need to call unlock only once, and not all the times , since we already called lock outside try.

                }




            } else {
                counter++;
            }
            /*
            we can also set a timeout period
            if the thread is still waiting for lock when timeout expires
            its interrupted and continues executing

            pass the timeout period and unit to the method.


            how many threads are waiting to acquire the lock
            synchronized blocks are not first come first serve
            reentrant lock accepts a fairness parameter
            by giving lock to whichever thread waited the longest.
            

             */




        }


    }
}
