package com.umartariq;

import java.util.Scanner;

/**
 * X.java created by umartariq on 20/06/2020
 * 4:38 PM inside the package - com.umartariq
 */
public class X {
    private int x;

    public X(Scanner x){
        System.out.println("Enter a number");
        this.x = x.nextInt();
    }

    public void x(){
        for(int x=1;x<15;x++){
            System.out.println(x + " times " + this.x + " equals " + x * this.x);
        }
    }

}
