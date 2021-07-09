package com.umartariq;

public class Main {

    public static void main(String[] args) {
        /*Interfaces
        methods that (class that implements an interface) must implement

        Interface only has methods
        actual method definitions are inside the classes

         */

        ITelephone umarPhone;
        umarPhone = new DeskPhone(123456);
        ITelephone lanadelreyPhone;
        lanadelreyPhone = new DeskPhone(765432);
        umarPhone.powerOn();
        lanadelreyPhone.powerOn();
        umarPhone.dial(765432);
        umarPhone.callPhone(765432);
        lanadelreyPhone.answer((DeskPhone) umarPhone);



    }
}
