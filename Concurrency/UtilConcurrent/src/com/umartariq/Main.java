package com.umartariq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.umartariq.Main.EOF;


//Producer Consumer Problem using java.util.List as the buffer
public class Main {

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
                buffer.add(num);
                bufferLock.unlock();

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
        buffer.add("EOF");
        bufferLock.unlock();
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
        while(true){
           //synchronized (buffer) {}
            bufferLock.lock();
                if(buffer.isEmpty()){//arraylist isempty method
                    bufferLock.unlock();////so that max lock count is not reached
                    continue;
                }

                if(buffer.get(0).equals(EOF)){//loop until EOF is reached.

                    System.out.println(color + "Exiting");
                    bufferLock.unlock();//so that max lock count is not reached
                    break;
                } else {
                    //this can be suspended - if isempty returns false
                    System.out.println(color + "Removed"+buffer.remove(0));//EOF will not be removed, otherwise other consumer threads would loop indefinitely
                    //the condition buffer.get(0).equals(EOF) would never be true otherwise

            }
            bufferLock.unlock();

        }

        //unlock method will not release count until the max lock count reaches 0

        //in consumer code, we hit the lock method so many times that the max lock count is reached
        //and the unlock method needs lock count to be 0
    }
}
