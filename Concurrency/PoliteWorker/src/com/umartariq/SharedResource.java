package com.umartariq;

/**
 * SharedResource.java created by umartariq on 21/09/2020
 * 11:02 AM inside the package - com.umartariq
 * in the java project PoliteWorker using IDE IntelliJ IDEA
 */
public class SharedResource {

    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    //since we are changing data through this method, it needs to be synchronized.
    //we dont want any thread interference when this method is accessing resource.

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
