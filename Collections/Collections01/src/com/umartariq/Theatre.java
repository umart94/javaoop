package com.umartariq;


import java.util.*;

//Collection is Base Class
//Set->SortedSet,List,Queue and Dequeue all extend the Collection Interface





public class Theatre {
    private final String theatreName;
    private int counterBinarySearch=0;
    //private Collection<Seat> seats = new LinkedList<>();
    public List<Seat> seats = new ArrayList<>();//WILL WORK

    static final Comparator<Seat> PRICE_ORDER; //remember a semicolon is expected here
//standard static final declaration of PRICE_ORDER COMPARATOR
    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }
    //THE PROBLEM with this method is
    /*
            THE PRICES WITH THE SEATCODES WILL DISPLAY
            THEY WILL BE IN ASCENDING ORDER (AS PER THE SORT METHOD WITH THE COMPARATOR)
            WE ADDED B00 BEFORE A00 THATS WHY IT COMES IN SORT METHOD FIRST...
            SINCE THE PRICES ARE EQUAL... BUT THE B00 WAS ADDED BEFORE A00 SO IT DIDNT SORT ALPHABETICALLY BUT IN THE ORDER IN WHICH YOU ADDED THEM
            ALSO NOTE THE PRICE IS ALSO LESSER THAN OTHERS


     */


    //private Collection<Seat> seats = new HashSet<>();//WILL WORK
    //private Collection<Seat> seats = new TreeSet<>();//WILL NOT WORK
    //private Collection<Seat> seats = new LinkedHashSet<>();//WILL WORK
    /*
    Exception in thread "main" java.lang.ClassCastException: class com.umartariq.Theatre$Seat
    cannot be cast to class java.lang.Comparable (com.umartariq.Theatre$Seat is in unnamed module of loader 'app';
     java.lang.Comparable is in module java.base of loader 'bootstrap')

TreeSet is below SortedSet you cant use that
     */
   // private Collection<Seat> seats = new LinkedHashSet<>();//WILL WORK

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                //Seat seat = new Seat(row + String.format("%02d", seatNum));
                double price = 1200.00;
                if( (row<'D') && (seatNum>=4 && seatNum<=9)){
                    price = 1500.00;

                }
                else if((row > 'F') || (seatNum<4 || seatNum>9))
                {
                    price = 800.00;

                }
                Seat seat = new Seat(row + String.format("%02d", seatNum),price);
                seats.add(seat);
            }
        }
    }


    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {

        int low = 0;

        int high = seats.size()-1;
        while(low<=high){
            System.out.println(".");
            counterBinarySearch=counterBinarySearch+1;
            int mid = (low+high)/2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if(cmp<0){
                low = mid+1;
            }else if(cmp>0){
                high = mid-1;
            }else {
                System.out.println("Seat Found after "+this.counterBinarySearch+" times");
                this.counterBinarySearch=0;

                return seats.get(mid).reserve();

            }
        }
        System.out.println("There is no seat with the number you have provided.."+seatNumber+" please enter seat code again");
        return false;
    }
    public boolean reserveSeatPreviousCode(String seatNumber){
        //Seat requestedSeat = null;
        Seat requestedSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat with the number you have provided.. please enter seat code again" + seatNumber);
            return false;
        }

    }
        /*
        //Seat requestedSeat = null;
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat with the number you have provided.. please enter seat code again" + seatNumber);
            return false;
        }
*/
        /*for (Seat seat : seats) {
            //System.out.println(".");//see how many seats it had to check to find our seat [BRUTE FORCE SEARCH]
            //Binary Search method is built in to collections framework of java
            //we need to change definition of class seat... which is a collection and make it implement Comparable
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("There's No Seat  " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();*/


    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public Collection<Seat> getSeatsPrevious() {
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        //override compareTo Method
        //return a number less than 0
        // >0 if greater than object
        //equal objects -> return 0
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber,double Price) {
            this.seatNumber = seatNumber;
            this.price  = Price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());//BINARY SEARCH !
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved ");
                return true;
            }else{
                return false;
            }

        }
        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled ");
                return true;
            } else {
                return false;
            }
        }


        public String getSeatNumber() {
            return this.seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }


}
