package com.umartariq;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    public static void main(String[] args) {


//inner class or second method is anonymous inner class

           /*
            class ClickListener implements Button.OnClickListener{
                public ClickListener(){
                    System.out.println("Listener Attached");
                }

                @Override
                public void onClick(String title) {
                    System.out.println(title + " was clicked");
                }
            }
*/
           // btnPrint.setOnClickListener(new ClickListener());//listener attached to button which is an innerclass that implements Button ClickListener Interface

        //anonymous inner class
                btnPrint.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(String title) {
                        System.out.println(title + " was clicked ");
                    }
                });

            listen();//will keep on listening for a click on the button... if you dont add this method here it will only run once
    }

        public static void listen(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }




	// write your code here

        //OuterClass obj = new OuterClass();
        //OuterClass.InnerClass obj = outerclassobj.new InnerClass();


        Gearbox Mehran = new Gearbox(6);
       // Gearbox.Gear first = McLaren.new Gear(1,5.3);

        Mehran.operateClutch(true);
        Mehran.changeGear(1);
        Mehran.operateClutch(false);
        System.out.println(Mehran.wheelSpeed(1000));
        Mehran.changeGear(2);
        System.out.println(Mehran.wheelSpeed(3000));
        Mehran.operateClutch(true);
        Mehran.changeGear(3);
        Mehran.operateClutch(false);
        System.out.println(Mehran.wheelSpeed(6000));

    }
}
