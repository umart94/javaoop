package com.umartariq;

import static com.umartariq.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {

        System.out.println(ANSI_BLUE+"Hello from "+currentThread().getName());
        try{
            Thread.sleep(10000);//1 second has 1000 milliseconds . 3 seconds have 3000 ms
            //Thread.sleep(3000,5);//1 second has 1000 milliseconds . 3 seconds have 3000 ms
        }catch(InterruptedException e){
            System.out.println(ANSI_BLUE+"Another Thread Interrupted");
            return;//this return statement Terminates AnotherThread.
        }
        //There is no guarantee that the Thread will completely sleep for the amount of time we have specified
        //This is because it maybe interrupted by another Thread currently executing while this thread was executing and thus delays the time further
        //We Interrupt A Thread When we want to Terminate and Stop it
        //for e.g a Thread is monitoring a Buffer for data that another thread is fetching
        //when another thread determines that there is no more data to fetch
        //we can interupt the monitoring thread and terminate it

        //A Thread can be interrupted By Sleep method inside the Run method OR
        //call an Interrupted method to check if it was interrupted.. WITH return; with nothing inside the thread

        //There need to be 2 Reference Objects of Threads and an Interrupt method inside a thread
        //and 1 thread will call the interrupt method inside another Thread.
        //it wont access it's memory, just call it's interrupt method

        System.out.println(ANSI_BLUE+"10 seconds have passed and i'm awake");
        //if you comment return; and run interrupt.. this line would still execute.. because it is the return statement that terminates and interrupts this thread in combo with the interrupt method
        //if you interrupt.. the code in catch will run
        //if you dont interrupt .. the try will run and then this code afterwards



        //Join thread
        //1 thread cannot execute until a 2nd thread has completely executed and finished ..
        //there won't be any data to process or fetch for the 1st thread until that 2nd thread has completed executing and fetching data
        //in this case we join 2 threads
        //when 1 and 2 threads are joined .. the 1st thread will wait for the 2nd thread to execute and terminate.. and then 1st thread will continue its execution

    }
}
