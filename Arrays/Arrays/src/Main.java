import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntArray = {45,56,78,865,45,67,35,320,394,12};
        //int[] myarray = new int[10];
        //printArray(myIntArray);
        //int[] myInputArray = getIntegers(5);
        //printArray(myInputArray);
        //System.out.println("The Average Is "+getAverage(myInputArray));

        //int[] myInputArray = getIntegers(5);

        //myIntArray = sortIntegers(myIntArray);
        //printArray(myIntArray);

        int[] findMinNumArray = readIntegers(10);
        System.out.println("The Minimum Number In Array Is "+findMin(findMinNumArray));
       // System.out.println("Reversed Array is "+ Arrays.toString(reverseArray(findMinNumArray)));
        System.out.println("Reversed Array is "+ Arrays.toString(reverseArrayWithoutAnotherArrayCreation(findMinNumArray)));
    }

    public static int[] sortIntegers(int[] array){
       /* int[] sortedArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            sortedArray[i] = array[i];
        }
        */
       int[] sortedArray = Arrays.copyOf(array,array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i > sortedArray.length-1; i++) {
                if(sortedArray[i]<sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
            
        }
        return sortedArray;
    }



    public static int[] getIntegers(int number){
        System.out.println("Enter "+number+" integer values.\r");
        int[] values = new int[number];

        for(int i=0;i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }
    public static void printArray(int[] myIntArray){
        for(int i=0;i<myIntArray.length;i++){
            System.out.println("Element "+i+", value is "+myIntArray[i]);
        }

    }
    public static double getAverage(int[] myIntArray){
        int sum=0;
        for (int i = 0; i < myIntArray.length; i++) {
            sum+=myIntArray[i];
        }
        return (double) sum / (double)myIntArray.length;
    }

    public static int[] readIntegers(int count){
        System.out.println("Enter "+count+" integer values.\r");
        int[] values = new int[count];

        for(int i=0;i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static int findMin(int[] arrayParameter){
        int minNumber=arrayParameter[0];
        for (int i = 0; i < arrayParameter.length; i++) {
            if(arrayParameter[i] < minNumber)
            {
                minNumber = arrayParameter[i];
            }
        }
        return minNumber;
    }

    //this is with creating a second array
    public static int[] reverseArray(int[] arrayParam){
        int[] reversedArray = Arrays.copyOf(arrayParam,arrayParam.length);
        int firstVar = 0;
        for (int i = arrayParam.length-1; i >=0 ; i--) {
            reversedArray[i] = arrayParam[firstVar];
            if(firstVar==arrayParam.length-1)
            {
                break;
            }
            else {
                firstVar++;
            }
        }
        return reversedArray;
    }

    //reversal of array without creating second array
    public static int[] reverseArrayWithoutAnotherArrayCreation(int[] array){

        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex -i];
            array[maxIndex - i] = temp;
        }
        return array;
    }

    public static int[] sortArrayOfInts(int[] array){
        int[] a = new int[array.length];
        for(int i=0;i<a.length;i++){
            a[i] = array[i];
        }

        boolean flag = true;
        int temp;
        while(flag){
            flag = false;






        }

    }

}
