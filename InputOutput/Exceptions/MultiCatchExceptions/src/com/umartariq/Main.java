package com.umartariq;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main.java created by umartariq on 21/06/2020
 * 1:03 PM inside the package - com.umartariq
 */
public class Main {

        public static void main(String[] args) {
            //int x = 98;
            //int y = 0;
            //System.out.println(divideLBYL(x,y));
            //System.out.println(divideEAFP(x,y));
            //System.out.println(divide(x,y));//java.lang.ArithmeticException: / by zero

            //int x = getInt();
            int x = getIntLBYL();
            int y = getIntEAFP();

            System.out.println(" x is " + x);
            System.out.println(" y is " + y);
            System.out.println("Result of dividing x by y is " + divideLBYL(x, y));
            System.out.println("Result of dividing x by y is " + divideEAFP(x, y));
        }

        private static int getInt() {
            Scanner s = new Scanner(System.in);
            return s.nextInt();//Exception in thread "main" java.util.InputMismatchException - enter alphabet instead of integer
        }

        private static int getIntLBYL() {
            Scanner s = new Scanner(System.in);
            boolean isValid = true;
            System.out.println("Please enter an integer ");
            String input = s.next();
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    //for each element of string.. it should be an integer
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return Integer.parseInt(input);
            }
            return 0;

        }

        private static int getIntEAFP() {
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter an integer ");
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                return 0;
            }

        }

        //Look Before You Leap
        private static int divideLBYL(int x, int y) {
            if (y != 0) {
                return x / y;
            } else {
                return 0;
            }
        }

        //Easier to Ask Forgiveness than Permission
        private static int divideEAFP(int x, int y) {
            try {
                return x / y;
            } catch (ArithmeticException e) {
                return 0;
            }
        }

        private static int divide(int x, int y) {
            return x / y;
        }
    }

