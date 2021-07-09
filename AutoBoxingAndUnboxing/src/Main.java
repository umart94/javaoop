import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {

    Bank bank = new Bank("Meezan Islamic Bank");

    bank.addBranch("Bait-ul-Mukarram");

    bank.addCustomer("Bait-ul-Mukarram","Umar",10000);
    bank.addCustomer("Bait-ul-Mukarram","Tariq",20000);
    bank.addCustomer("Bait-ul-Mukarram","Talha",30000);

    bank.addBranch("Gulshan");
    bank.addCustomer("Gulshan","Ambreen",12345);

    bank.addCustomerTransactions("Bait-ul-Mukarram","Umar",1500);
    bank.addCustomerTransactions("Bait-ul-Mukarram","Umar",1500);
    bank.addCustomerTransactions("Bait-ul-Mukarram","Tariq",4000);

    bank.listCustomers("Bait-ul-Mukarram",true);
    bank.listCustomers("Gulshan",true);

   if( bank.addBranch("TariqRoad")){
            System.out.println("TariqRoad Branch Created");
        }
    if(bank.addCustomer("TariqRoad","Brian",132.3)){
        System.out.println("Branch TariqRoad Does exist");
    } else {
        System.out.println("Branch TariqRoad Does Not Exist");
    }
        bank.listCustomers("TariqRoad",true);

        if(!bank.addBranch("TariqRoad")){
            System.out.println("Branch TariqRoad already exists");
        }

        if(!bank.addCustomerTransactions("TariqRoad","Daniyal",1234.5)){
            System.out.println("Customer Does Not Exist At Branch");
        }

        if(!bank.addCustomer("TariqRoad","Brian",12.2)){
            System.out.println("Customer Brian Already Exists");
        }
    }

}
