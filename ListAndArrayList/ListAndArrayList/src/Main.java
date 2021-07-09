import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static Scanner input = new Scanner(System.in);
    private static GroceryList groceryObject = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter Your Choice ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){

                case 0:
                    printInstructions();
                    break;
                case 1:
                    printGroceryList();
                    break;
                case 2:
                    addGroceryItem();


                    break;
                case 3:
                    modifyGroceryItem();
                    break;
                case 4:
                    removeGroceryItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;

                default:
                    break;




            }
        }


    }

    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("\n0 - To Print Choice Options.");
        System.out.println("\n1 - Print Grocery List.");
        System.out.println("\n2 - Add Grocery Item");
        System.out.println("\n3 - Modify Grocery Item");
        System.out.println("\n4 - Remove Grocery Item.");
        System.out.println("\n5 - To search For Item.");
        System.out.println("\n6 - To Quit.");

    }

    public static void addGroceryItem(){
        System.out.println("Please Enter Grocery Item");
        groceryObject.addGroceryItem(input.nextLine());
    }

    public static void modifyGroceryItem(){
        System.out.println("Enter Grocery Item: ");
        String item = input.nextLine();
        //input.nextLine();
        System.out.println("Enter Replacement Item: ");
        String newItem = input.nextLine();
        groceryObject.modifyGroceryItem(item,newItem);
    }

    public static void removeGroceryItem(){
        System.out.println("Enter item number : ");
        String item = input.nextLine();
        input.nextLine();
        groceryObject.removeGroceryItem(item);
    }

    public static void searchForItem(){
        System.out.println("Enter Item to Search For: ");
        String searchItem = input.nextLine();
        if(groceryObject.onFile(searchItem)){
            System.out.println("Found "+searchItem+"in our grocery list");
        } else {
            System.out.println(searchItem+" Is Not In The Shopping List");
        }
    }
    public static void printGroceryList(){
        groceryObject.printGroceryList();
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryObject.getMyGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryObject.getMyGroceryList());

        String[] myArray = new String[groceryObject.getMyGroceryList().size()];
        myArray = groceryObject.getMyGroceryList().toArray(myArray);
       }

}
