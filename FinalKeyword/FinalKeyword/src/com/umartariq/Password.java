package com.umartariq;

/**
 * Password.java created by umartariq on 20/06/2020
 * 6:15 PM inside the package - com.umartariq
 */
public class Password {

    private static final int key = 2345;
    //private static final int key = 123456; // if password is also same as key i.e password=123456 and key=123456, 0==0 and we get a welcome

    private final int encryptedPassword;

    public Password(int password){
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password){
        System.out.println(password^key);
        return password ^ key;

        //password is decimal
        //key is decimal
        //returned value is also decimal

        //so suppose we have password 123456
        //key is 215845
        //xor result is 174437
        //which is what we get
        // saving password as 174437

        //^ is operator for Bitwise XOR



        //TRUE == 1
                //FALSE == 0
        //anything that is not 0 is true.
        //anything that is 0 is false.

        //So, if you XOR a number onto itself, you always get 0
        //this code also works when we set the same password and key
        //since Xor of number with itself is 0 (DON'T CONFUSE IT WITH THE JAVA RETURN CODE OF TRUE AND FALSE)
        //what we did was match in the if condition.. thus 0 matches with 0 and we get a welcome.




        /*
        The definition of the XOR (exclusive OR) operator, over bits, is that:

0 XOR 0 = 0
0 XOR 1 = 1
1 XOR 0 = 1
1 XOR 1 = 0
One of the ways to imagine it, is to say that the "1" on the right side changes the bit from the left side, and 0 on the right side doesn't change the bit on the left side. However, XOR is commutative, so the same is true if the sides are reversed. As any number can be represented in binary form, any two numbers can be XOR-ed together.

To prove it being commutative, you can simply look at its definition, and see that for every combination of bits on either side, the result is the same if the sides are changed. To prove it being associative, you can simply run through all possible combinations of having 3 bits being XOR-ed to each other, and the result will stay the same no matter what the order is.

Now, as we proved the above, let's see what happens if we XOR the same number at itself. Since the operation works on individual bits, we can test it on just two numbers: 0 and 1.

0 XOR 0 = 0
1 XOR 1 = 0
So, if you XOR a number onto itself, you always get 0 (believe it or not, but that property of XOR has been used by compilers, when a 0 needs to be loaded into a CPU register. It's faster to perform a bit operation than to explicitly push 0 into a register. The compiler will just produce assembly code to XOR a register onto itself).

Now, if X XOR X is 0, and XOR is associative, and you need to find out what number hasn't repeated in a sequence of numbers where all other numbers have been repeated two (or any other odd number of times). If we had the repeating numbers together, they will XOR to 0. Anything that is XOR-ed with 0 will remain itself. So, out of XOR-ing such a sequence, you will end up being left with a number that doesn't repeat (or repeats an even number of times).
         */












        /*
        It is the Bitwise xor operator in java which results 1 for different value of bit (ie 1 ^ 0 = 1) and 0 for same value of bit (ie 0 ^ 0 = 0) when a number is written in binary form.

ex :-

To use your example:

The binary representation of 5 is 0101. The binary representation of 4 is 0100.

A simple way to define Bitwise XOR is to say the result has a 1 in every place where the two input numbers differ.

0101 ^ 0100 = 0001 (5 ^ 4 = 1) .
         */
    }







    //currently Password class is not final
    //so anyone can implement a subclass of password class
    //and then override storePassword functionality.

    //to stop this




    public void storePassword(){
        System.out.println("saving password as "+ this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(encryptDecrypt(password)==this.encryptedPassword){
            System.out.println("welcome");
            return true;
        }
        else {
            System.out.println("nope, you cannot get in");
            return false;
        }
    }

}
