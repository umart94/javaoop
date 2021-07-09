package com.umartariq;

/**
 * ExtendedPassword.java created by umartariq on 20/06/2020
 * 6:31 PM inside the package - com.umartariq
 */
public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password; //So this is the mistake
        //the extended password class does not perform the xor operation that has functionality for password encryption
        //we should not extend default cryptographic classes, or make modifications inside an already existing cryptographic algo implementation class

    }

    @Override
    public void storePassword() {
        System.out.println("Saving Password As "+ this.decryptedPassword);
    }
}
