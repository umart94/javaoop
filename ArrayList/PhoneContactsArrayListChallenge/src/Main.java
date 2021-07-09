import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("03318302835");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("\nShutting Down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                addNewContact();
                break;
                case 3:
                updateContact();
                break;
                case 4:
                removeContact();
                break;
                case 5:
                queryContacts();
                break;
                case 6:
                printActions();
                break;

            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting Galaxy J7");
    }
    private static void addNewContact(){
        System.out.println("Enter New Contact Name");
        String name = scanner.nextLine();
        System.out.println("Enter The Phone Number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact Added "+ name + " , phone ="+ phoneNumber);
        } else {
            System.out.println("Cannot Add the number "+name  +" already on file ");
        }
    }
    private static void updateContact(){
        System.out.println("Enter Existing Contact Name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord==null){
            System.out.println("Contact Not Found");
            return;
        }

        System.out.println("Enter Updated Contact Name ");
        String newName = scanner.nextLine();
        System.out.println("Enter The Phone Number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existingContactRecord,newContact)){
            System.out.println("Successfully updated Contact");
        } else {
            System.out.println(" Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter Existing Contact Name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully Deleted Contact");
        } else {
            System.out.println(" Error Deleting Contact");
        }
    }


    private static void queryContacts() {
        System.out.println("Enter Existing Contact Name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        System.out.println("Name "+ existingContactRecord.getName() + " phone Number is "+ existingContactRecord.getPhoneNumber());
    }
    private static void printActions(){
        System.out.println("\nAvailable Actions : \npress");
        System.out.println("0 to shutdown\n");
        System.out.println("1 to print Contacts\n");
        System.out.println("2 to Add a New Contact\n");
        System.out.println("3 to update an existing contact \n");
        System.out.println("4 to remove an existing contact\n");
        System.out.println("5 query if existing contact exists\n");
        System.out.println("6 print a list of existing ACTIONS\n");
        System.out.println("CHOOSE YOUR ACTION");
    }


}
