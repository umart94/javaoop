package com.umartariq;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Theatre theatre = new Theatre("Tom And Jerry,Looney Tunes,We Bare Bears,Ed Edd and Eddy,Samurai Jack,Batman Beyond,Justice League,Batman The Animated Series",8,12);
        System.out.println(theatre.getTheatreName());
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        //List of Seats Class Objects, class was inside theatre, on right we use the instances in current class..
        //theatre object has public List called seats.
        //so we created a copy of a List in another class inside current class
        //now call the newly created printList method


        printList(seatCopy);
        //THIS WAS A SHALLOW COPY


        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please Pay for Seat A02");
        }
        else
        {
            System.out.println("Seat Already Reserved ");
        }


        //theatre.getSeats();



       /* if(theatre.reserveSeat("H12")){
            System.out.println("Please Pay or Else This Seat Will Go To Someone Else");
        } else {
            System.out.println("Sorry, this seat is already taken, try selecting another seat from the chart");
        }

        */

        /*
        if(theatre.reserveSeat("B12")){
            System.out.println("Please Pay or Else This Seat Will Go To Someone Else");
        } else {
            System.out.println("Sorry, this seat is already taken, try selecting another seat from the chart");
        }
        */


        Collections.reverse(seatCopy);
        System.out.println("Printing REVERSED seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);


        Collections.shuffle(seatCopy);
        System.out.println("Printing SHUFFLED seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);


        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Minimum seat Number is "+minSeat.getSeatNumber());
        System.out.println("Maximum seat Number is "+maxSeat.getSeatNumber());


        System.out.println("Printing SHUFFLED seatCopy");
        Collections.shuffle(seatCopy);
        printList(seatCopy);
        System.out.println("Printing reversed seatCopy");
        Collections.reverse(seatCopy);
        printList(seatCopy);
        System.out.println("Printing SHUFFLED seatCopy");
        Collections.shuffle(seatCopy);
        printList(seatCopy);

        //now we call sortList
        sortList(seatCopy);
        System.out.println("Printing Sorted Seatcopy");
        printList(seatCopy);

        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        /*
        Exception in thread "main" java.lang.IndexOutOfBoundsException: Source does not fit in dest
	at java.base/java.util.Collections.copy(Collections.java:561)
	at com.umartariq.Main.main(Main.java:89)
         */

        //THERE NEEDS TO BE N...IN THIS CASE 8*12 = 96 OBJECTS ALREADY PRESENT IN THE NEW LIST FOR THE COLLECTIONS.COPY METHOD TO WORK

        for(int i=0;i<theatre.seats.size();i++) {
            newList.add(theatre.seats.get(i));
        }

        Collections.copy(newList,theatre.seats);

        System.out.println("**********************************************");
        printList(newList);


        System.out.println("**********************************************");
        System.out.println(theatre.getTheatreName());
        if(theatre.reserveSeatPreviousCode("D12")){
            System.out.println("Please Pay For D12");
        } else{
            System.out.println("Seat already Reserved");
        }

        if(theatre.reserveSeatPreviousCode("B12")){
            System.out.println("Please Pay For B12");
        } else{
            System.out.println("Seat already Reserved");
        }
        if(theatre.reserveSeatPreviousCode("B13")){
            System.out.println("Please Pay For B13");
        } else{
            System.out.println("Seat already Reserved");
        }

            List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeatsPrevious());
            Collections.reverse(reverseSeats);
            printList(reverseSeats);

        List<Theatre.Seat> seatsTestPrice = new ArrayList<>(theatre.getSeatsPrevious());
        seatsTestPrice.add(theatre.new Seat("B00",200));
        seatsTestPrice.add(theatre.new Seat("A00",200));
        Collections.sort(seatsTestPrice,Theatre.PRICE_ORDER);//overloaded method with comparator
        printList(seatsTestPrice);








    }
    public static void sortList(List<? extends Theatre.Seat> list){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }

            }
        }
    }
    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat : list){
            System.out.print("SeatCode=="+ seat.getSeatNumber()+"\t Price== "+seat.getPrice()+"\n");
        }
        System.out.println();
        System.out.println("===================================================================================================");
    }
}
