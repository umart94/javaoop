package com.umartariq;
import com.umartariq.mylibrary.Series;
public class Main {

    public static void main(String[] args) {
	// write your code here

        for(int i=0;i<=10;i++){
            System.out.println(Series.nSum(i));
        }
        for(int i=0;i<=10;i++){
            System.out.println(Series.factorial(i));
        }
        for(int i=0;i<=10;i++){
            System.out.println(Series.fibonacci(i));
        }

    }
}
