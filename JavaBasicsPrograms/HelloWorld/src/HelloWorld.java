import java.math.RoundingMode;
import java.util.Scanner;
import java.text.DecimalFormat;
public class HelloWorld {

    public static int calculateScore(boolean gameOver,int score, int levelCompleted, int bonus){
        if(gameOver)
        {
            int finalscore = score + (levelCompleted * bonus);
            finalscore +=2000;
            return finalscore;
        }
        else{
            return -1;
        }


    }
    public static int calculateHighscorePosition(int highScore){
        int position=4;
        if(highScore>=1000) {
            position= 1;
        }else if(highScore>=500 && highScore<1000){
            position= 2;
        }else if(highScore>=100 && highScore<500){
            position= 3;
        }else{
            position= 4;
        }
    return position;
    }
    public static void displayHighscorePosition(String playerName,int highScorePosition){
        System.out.println(playerName+"managed to get"+highScorePosition);
    }
    public static void main(String[] args)
    {
        /*
        Scanner x = new Scanner(System.in);
        double miles=0.0;
        double kms=0.0;
        double mileToKm=1.609;
        System.out.println("enter the distance in miles");
        miles = x.nextDouble();
        kms = miles*mileToKm;
        System.out.println(miles +" miles"+ "to km is "+(kms) );

        //answer of kms variable is in 15-16 decimal places
        //to round off use
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Number nKms = kms;
        Double d = nKms.doubleValue();
        System.out.println("rounded off kilometre value is"+df.format(d));
        */

        /*****CP Ex 2 start *****/

       int highscore = calculateScore(true,800,5,100);
        System.out.println(highscore);

        int highscorepos = calculateHighscorePosition(1500);
        displayHighscorePosition("Umar",highscorepos);

        highscorepos = calculateHighscorePosition(900);
        displayHighscorePosition("Usman",highscorepos);

        highscorepos = calculateHighscorePosition(400);
        displayHighscorePosition("Ali",highscorepos);

        highscorepos = calculateHighscorePosition(50);
        displayHighscorePosition("Abubakar",highscorepos);

        highscorepos = calculateHighscorePosition(1000);
        displayHighscorePosition("Abubakar",highscorepos);
    }






}
