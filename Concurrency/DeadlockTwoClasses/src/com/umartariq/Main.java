package com.umartariq;

/**
 * Main.java created by umartariq on 13/09/2020
 * 7:14 PM inside the package - com.umartariq
 * in the java project DeadlockTwoClasses using IDE IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {

        //firstly, we create the objects using same thread.
        //it runs fine
        //if the objects use these methods from a different thread
        //then deadlock will occur.

        final PolitePerson tom = new PolitePerson("tom");
        final PolitePerson jerry = new PolitePerson("jerry");
        new Thread(new Runnable() {
            @Override
            public void run() {
                tom.sayHello(jerry);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                jerry.sayHello(tom);
            }
        }).start();
        /*
        tom: jerry has said hello to me - first method !
jerry: tom has said hello to me - first method !
deadlock.

         */

        /*
        // 1. Thread1 acquires the lock on the jane object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 2. Thread2 acquires the lock on the john object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 3. Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method
    // using the john object that was passed into the sayHello() method,
    // but Thread2 is holding the john lock, so Thread1 suspends.
    // 4. Thread2 runs again and wants to say hello back to the jane object. It tries to call the sayHelloBack() method
    // using the jane object that was passed into the sayHello() method,
    // but Thread1 is holding the jane lock, so Thread2 suspends.

         */

    }

    static class PolitePerson{
        private final String name;
        private PolitePerson(String name){
            this.name = name;
        }

        public String getName(){
            return name;

        }

        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s" + " has said hello to me - first method ! %n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me  - second method ! %n", this.name,
                    person.getName());
        }
    }
}
