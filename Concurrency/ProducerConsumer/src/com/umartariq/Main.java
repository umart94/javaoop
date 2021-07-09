package com.umartariq;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        We Can also synchronize static objects and static methods
        when we do this - the lock is owned by class object associated with object's class
        Synchronization is Reentrant ..

        if a thread acquires an object's lock and within the synchronzied code it calls a method that uses same object to synchronize some code

        the thread will keep on executing because it already has the objects lock

        IN OTHER WORDS THE THREAD CAN ACQUIRE A LOCK IT ALREADY OWNS

        critical section -> threads and synchronization

        it refers to the code that is referencing A Shared Resource Like a Variable
        Only 1 Thread at a time should be able to execute the Critical Section

        Thread Safe
        when a class or method is thread safe .. it means that the developers have synchronized all the critical sections within the code
        so we don't have to worry about race conditions / thread interference

        So in documentation if a class or method is Not Thread Safe That Means this Critical Section Syncrhonization Has Not Been Implemented :D

        we need to add synchronization to that class or method if in our code.. we want MULTIPLE THREADS TO ACCESS THAT class/method

         NONE OF THE UI COMPONENTS ARE THREAD SAFE in JavaFX
        rather than forcing developers to add synchronization To code that modifies the UI

        the JavaFX Developers force all such (Unsafe Multiple thread code) to run on the JavaFX Runtime Thread

        Since only 1 thread i.e JavaFX Runtime Thread can modify UI components
        there will not be any thread interference

        when we synchronize code... it should synchronize only code that needs to be synchronize... not every statement of the code

        we also dont want to synchronize the setting of color variable
        because it will suspend threads a lot

                */
        //make sure you remove imports for java reader and writer.. if theres a name conflict

        Message message = new Message();
        (new Thread(new Writer(message))).start();//producer
        (new Thread(new Reader(message))).start();//consumer

        //
        //thread can suspended WHILE EXECUTING A SINGLE LINE OF CODE
        //SINGLE LOC can call 1 method that contains 1000s of lines of code
        // thread can be suspended before or after performing any operation ( println , loops , huge network retrieval etc.)

        //THREAD CANT BE SUSPENDED WHILE
        //reading writing reference variables - ATOMIC
        //reading writing primitive variables ATOMIC ---- (except longs and doubles can be suspended ((wrapper classes)))
        //volatile variables

        //Collections
        //some collections are not thread safe - not synchronized
        //ArrayList implementation is not synchronized
        //multiple threads accessing that arraylist
        //we have to synchronize that arraylist
        //after creating arraylist we have to call collections.synchronizelist and pass it to array list
        //we still would have to synchronize the iteration over the arraylist (for while loop etc)





    }
}

class Message{
    private String message;
    private boolean empty = true;

    //PRODUCER CONSUMER PROBLEM
    //1 FINITE SIZED BUFFER
    //2 CLASSES OF THREADS
    //PRODUCER PUTS ITEMS INTO THE BUFFER
    //CONSUMER TAKES ITEMS OUT OF THE BUFFER

    // and a consumer must wait until something is in the buffer before it can take something out.
    public synchronized String read(){
        while(empty){

                //wait until something is in the buffer


            //When a thread calls a wait method
            //the wait method suspends execution
            //and releases whatever lock its holding until another thread releases a notification
            //other thread does this using notify() or notifyAll();
            //notifyAll() after empty value is changed

            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        empty = true;//no message to read
        //Every single time this variable upon which the switching is made and its value is changed (After Read or Write... Consuming or producing
        //we need to notifyAll other threads that its value was changed
        //otherwise Deadlock will occur and we would never unblock / exit out
        notifyAll();

        return message;
    }

    //A producer must wait until the buffer has space before it can put something in,
    public synchronized void write(String message){
        while(!empty){
                //wait until buffer is completely emptied

            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
        notifyAll();//do this at the end.. after the message has been produced / written to the buffer so that Reader knows empty was changed
        //since we are still looping
        //we need to call wait inside a loop
        //so that when it returns after notification .. we go back to the beginning of the loop and then we call wait again after a condition has been checked
        //in this case empty or !empty

        //notify Thread does not accept parameters
        //we don't want to wake up every thread in case there are lots and lots of threads in a loop
        //that would cause a major performance issue in the program
        //so we call only notify method


    }

    //both read and write methods are synchronized.. because we do not want 2 threads ..
    //1 using read 2 using write or
    //2 using write 1 using read
    //AT THE SAME TIME

}

//producer
class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        String messages[] = {
                    "Humpty Dumpty sat on a wall",
                    "Humpty Dumpty had a great fall",
                    "All the King's Horses and all the king's men",
                    "Couldn't Put Humpty Together Again"

        };

        Random random = new Random();
        for(int i=0;i<messages.length;i++){
            //once we reach this loop.. Writer class keeps on looping and gets stuck in the write method
            //The value of empty is never changed
            //The Thread is blocked
            //This is called deadlock
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){

            }
        }
        message.write("Finished");

    }
}

//consumer
class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        //initialize - test - counter
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read() ){
            System.out.println(latestMessage);
            //Writer executed and wrote to the message variable
            //this loop prints out the message
            //currently Thread 1 is sleeping
            //after the try block below - this Reader Thread will also sleep
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){

            }
        }

    }
}

