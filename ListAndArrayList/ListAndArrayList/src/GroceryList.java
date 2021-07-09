import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers;
    private ArrayList<String> myGroceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        myGroceryList.add(item);
    }

    public ArrayList<String> getMyGroceryList() {
        return myGroceryList;
    }

    public void printGroceryList(){
        System.out.println("You Have this many items in the list == "+myGroceryList.size());
        System.out.println("they are:: ");
        for (int i = 0; i < myGroceryList.size(); i++) {
            System.out.println((i+1)+". "+myGroceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem,String newItem){
                int position = findItem(currentItem);
                if(position>=0){
                    modifyGroceryItem(position,newItem);
                } else{
                    System.out.println("Item"+currentItem+"does not exist in the grocery list... enter again");
                }
    }


    private void modifyGroceryItem(int position,String newItem){
        myGroceryList.set(position,newItem);
        System.out.println("Grocery Item " + (position+1)+" has been modified");
        System.out.println("new value is"+ myGroceryList.get(position));
    }

    public void removeGroceryItem(String searchItem){
        int position = findItem(searchItem);
        if(position>=0 && position<=myGroceryList.size()){
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position){
        String theItem = myGroceryList.get(position);
        myGroceryList.remove(position);
    }

    private int findItem(String searchItem){
        return myGroceryList.indexOf(searchItem);
    }


    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position>=0){
            return true;
        }

        return false;
    }

    /*public String findItem(String searchItem){
        if(myGroceryList.contains(searchItem)){
            return "String"+searchItem+"Found At "+myGroceryList.indexOf(searchItem);
        }
        int i = myGroceryList.indexOf(searchItem);
        if(i>=0){
            return myGroceryList.get(i);
        }
        return null;
    }*/
}
