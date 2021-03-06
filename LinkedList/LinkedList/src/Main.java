
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit,"Abbotabad");
        addInOrder(placesToVisit,"Baltistan");

        addInOrder(placesToVisit,"Careemabad");
        addInOrder(placesToVisit,"Dehra Ghazi Khan");
        //addInOrder(placesToVisit,"Dehra Ghazi Khan");





       // printList(placesToVisit);

       // addInOrder(placesToVisit,"Baa");
        //printList(placesToVisit);
        visit(placesToVisit);

    }

    public static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now Visiting " + i.next());
        }
        System.out.println("====================");
    }

    public static boolean addInOrder(LinkedList<String> linkedList,String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()){
            int comparision = stringListIterator.next().compareTo(newCity);
            if(comparision == 0){
                //equal .. do not add
                System.out.println(newCity+ " Already In Database " );
                return false;
            } else if(comparision > 0){
                //newCity should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparision < 0){
                //move on to next city

            }

        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities){

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itenerary");
        } else {
            System.out.println("Now Visiting " + listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vacation Over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());

                    } else {
                        System.out.println("Reached End Of The List");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Visiting " + listIterator.previous());
                    } else {
                        System.out.println("We Are At the start of the list");
                    }
                case 3:
                    printMenu();
                    break;


            }
            }

    }

    private static void printMenu(){
        System.out.println("0 to quit");
        System.out.println("1 to go to next city");
        System.out.println("2 to go to previous city");
        System.out.println("3 print menu options");
    }



}
