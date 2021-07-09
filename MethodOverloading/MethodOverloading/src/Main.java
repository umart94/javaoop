import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "invalid value";
    public static double calcFeetAndInchesToCentimeters(double feet,double inches){
        double feetAndInchesToCentimeters = 0;

        if((feet<0) || (inches<0) || (inches>12)){
            System.out.println("invalid");
           return -1;
        }
        feetAndInchesToCentimeters = (feet*12*2.54)+(inches*2.54);
        System.out.println(feet+"feet"+inches+"inches"+" = "+feetAndInchesToCentimeters+"cm");
        return feetAndInchesToCentimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        double feetInInches = 0;
        if(inches<0)
            return -1;
        feetInInches = (int)inches/12;
        double remainingInches = (int)inches%12;
        System.out.println(inches +"inches is equal to"+feetInInches +"feet and"+remainingInches+"inches");
        return calcFeetAndInchesToCentimeters(feetInInches,remainingInches);

    }

    public static String getDurationString(double minutes,double seconds){
        double hours = 0;
        double finalMinutes = 0;
        double finalSeconds = 0;
        if(minutes<0 || seconds <0 || seconds >59){
            //System.out.println("invalid value");
            return INVALID_VALUE_MESSAGE;
        }
        hours = (int) minutes/60;
        finalMinutes = minutes%60;
        finalSeconds = seconds;
        String hoursString = hours+"H";
        if(hours<10)
        {
            hoursString = "0"+hoursString;
        }
        String minutesString = minutes+"M";
        if(minutes<10)
        {
            minutesString = "0"+minutesString;
        }
        String secondsString = seconds+"S";
        if(seconds<10)
        {
            secondsString = "0"+secondsString;
        }
        String durationString = hoursString+" "+minutesString+" "+secondsString+" ";
        return durationString;

    }

    public static String getDurationString(double seconds){
        if(seconds<0)
        {
            return INVALID_VALUE_MESSAGE;
        }

        double finalMinutes= 0;
        finalMinutes = (int) seconds / 60;
        double finalseconds = seconds%60;
        return getDurationString(finalMinutes,finalseconds);
    }

    public static void printDayOfTheWeek(int day){
        switch(day){
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Day");
                break;
        }
    }

    public static double calculateInterest(double amount,double interestRate){

        return amount*(interestRate/100);
    }
    public static boolean isPrime(int n){
       if(n==1)
       {
           return false;
       }
       for(int i=2;i<=(long)Math.sqrt(n);i++)
       {
           System.out.println("looping"+i);
           if(n%i==0)
           {
               return false;
           }
       }
       return true;
    }

    public static boolean isEvenNumber(int number){
        if((number%2)==0){
            return true;
        } else{
            return false;
        }

    }

public static double sumDigits(int number){
        if(number<10)
            return -1;
        int sum=0;
        //step-1 is to extract least significant digit
        //125 -> 125 / 10 = 12 -> 12 * 10 = 120 -> 125 - 120 = 5
        while(number>0) {
            int leastSignificantDigit = number % 10;
            sum += leastSignificantDigit;
            //drop least significant digit
            number /= 10;
        }
        return sum;

}
    public static void main(String[] args){

        Scanner minmax = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean first=true;

       while(true){
           boolean isAnInt = minmax.hasNextInt();
           if(isAnInt){
                int number = minmax.nextInt();

               /* if(first){
                    first = false;
                    min = number;
                    max = number;

                }*/
                if(number>max){
                    max = number;
                }
                if(number<min){
                    min = number;
                }

           }else
           {
               break;
           }
           minmax.nextLine(); // handle Input
       }
        System.out.println("Min=="+min);
        System.out.println("Max=="+max);
/*
        //calcFeetAndInchesToCentimeters(5,4);
        System.out.println(getDurationString(65,9));
        System.out.println(getDurationString(9));
        int a=4;
        switch(a){
            case 1:
                break;
            case 2: case 3: case 4:
                break;
            default:
                break;


        }
        for(int i=2;i<=5;i++)
            System.out.println(calculateInterest(10000,i));

            if(isPrime(6)){
                System.out.println("47 is prime");
            }

            int countOfNumbersDivisibleBy3And5=0;
            int sumOfNumbersDivisibleBy3And5 = 0;
            for(int j=1;j<=1000;j++)
            {
                if((j%3)==0 && (j%5)==0)
                {
                    System.out.println(j);
                    sumOfNumbersDivisibleBy3And5+=j;
                    countOfNumbersDivisibleBy3And5++;
                }
                if(countOfNumbersDivisibleBy3And5==5)
                    break;
            }

        System.out.println("Sum Of 5 Numbers Divisible By 3 and 5 is"+sumOfNumbersDivisibleBy3And5);

            int count=1;
            while(count!=5){
                System.out.println("count value is "+count);
                count++;
            }
            for(int i=1;i<7;i++)
            {
                System.out.println(i);

            }
        for(count=1;count!=6;count++)
        {
            System.out.println(count);

        }

        count=1;
        while(true){
            if(count==6){
                break;
            }
            System.out.println("count value is"+count);
            count++;

        }

        int number=1;
        int finishNumber = 20;
        int evenNumbersFound = 0;
        while(number<=finishNumber)
        {
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            evenNumbersFound++;
            System.out.println("Even Number"+number);
        }

        System.out.println("Total"+evenNumbersFound+"Even Numbers Found");
        System.out.println(sumDigits(543));

        String numberAsString = "2019";
        System.out.println("numberAsString"+numberAsString);
        int stringToNumber = Integer.parseInt(numberAsString);

        Scanner scanner = new Scanner(System.in);
        boolean hasNextInt =scanner.hasNextInt();
        if(hasNextInt){
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Your Name");
            String name = scanner.nextLine();
            int age = 2019 - yearOfBirth;
            if(age>=0 && age <=100)
            {
                System.out.println("your name is "+name+" and uyour age is"+age);
            } else{
                System.out.println("invalid year of birth");
            }
        }

        scanner.close();


*/
    }
}
