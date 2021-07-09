package com.umartariq;

/**
 * Worker.java created by umartariq on 21/09/2020
 * 11:02 AM inside the package - com.umartariq
 * in the java project PoliteWorker using IDE IntelliJ IDEA
 */
public class Worker {
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker){
        while(active){
            if(sharedResource.getOwner() != this){
                try{
                    wait(10);
                }catch(InterruptedException e){

                }
                continue;
            }

            if(otherWorker.isActive()){
                System.out.println(getName()+" : give the resource to the worker "+ otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }
        }
    }
}
