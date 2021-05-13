package midterm_banking;

import static java.lang.System.exit;
import java.util.Scanner;

public class Midterm_Banking {
    
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        Customer[] customer = new Customer[3];
        
        customer[0] = new Customer("Bruce","Wayne","Brampton","bWayne","12345");
        customer[1] = new Customer("Thanos","Badman","North York","tBadman","56789");
        customer[2] = new Customer("Wonder","Woman","Oakville","wWoman","39087");
        
        Account[] account = new Account[4];
        
        account[0] = new SavingsAccount(1,customer[0],500);
        account[1] = new SavingsAccount(2,customer[1],1000);
        account[2] = new CheckingAccount(3,customer[2],500000.00,1500);
        account[3] = new CheckingAccount(4,customer[0],400000.00,10000);
              
        System.out.print("Enter Username :  ");
        String uName = read.next();
        System.out.print("Enter Password :  ");
        String pWord = read.next();

        char type=0;
        String customerName= "";
        boolean userAccountFound = false;
        boolean foundAccount = false;

        for(int i = 0; i < customer.length; i++) {
            if((uName.contentEquals(customer[i].getUsername())) && (pWord.contentEquals(customer[i].getPassword()))) {
                userAccountFound = true;
                customerName = customer[i].getFirstName() + " " + customer[i].getLastName();
                System.out.println("\nWelcome " + customerName + "!");               
                displayTypes();
                type = read.next().charAt(0);
                break;
            }
        }
        if(!userAccountFound) {
            System.out.println("\nYou entered an incorrect Username or Password!\n");
        }
        else {
            for(int i = 0; i < account.length; i++) {    
                String accountCustomerName = account[i].getCustomer().getFirstName() + " " +account[i].getCustomer().getLastName();
                if((customerName.equals(accountCustomerName)) && (Character.toUpperCase(type) == account[i].getType().charAt(0))) {                
                    foundAccount = true;
                    switch(Character.toUpperCase(type)) {
                        case 'C': 
                            account[i].AccountDetails();
                        break;
                        case 'S':
                            account[i].AccountDetails();
                        break;
                    }
                
                    char operation;
                    do {
                        displayOperations();
                        operation = read.next().charAt(0);
                   
                        switch(Character.toUpperCase(operation)) {
                            case 'D':
                                System.out.print("\nEnter Amount to Deposit : ");
                                double depositAmount = read.nextDouble();
                                System.out.println("***********************************************************");
                                account[i].deposit(depositAmount);
                            break;
                            case 'W':
                                System.out.print("\nEnter Amount to Withdraw: ");
                                double withdrawAmount = read.nextDouble();
                                System.out.println("***********************************************************");
                                account[i].withdraw(withdrawAmount);
                            break;
                            case 'X':
                                System.out.println("\n====================================================================");
                                System.out.println("Your transaction has been finished. Thank you and have a nice day!!!");
                                System.out.println("====================================================================\n");
                                exit(0);
                            break;
                            default:
                                System.out.println("\nYou entered an incorrect type of operation!\n");
                        }
                        account[i].AccountDetails();
                    } while(Character.toUpperCase(operation) != 'X');
                    System.out.println("==================================================");                
                    break; //break the for loop
                } //end of if
            } //end of for loop
            if(!foundAccount) {
                System.out.println("\nThe type of account you have entered does not exist!\n");
            }
        } //end of else
    }
    
    public static void displayTypes() {
        System.out.println("\nAccount Types");  
        System.out.println("[C] - Enter 'C' or 'c' for Checking Account");
        System.out.println("[S] - Enter 'S' or 's' for Savings Account");
        System.out.print("Choose Type of Account [C/S] : ");
    }
    
    public static void displayOperations() {
        System.out.println("\nType of Operations");    
        System.out.println("[D] - Enter 'D' or 'd' to deposit");
        System.out.println("[W] - Enter 'W' or 'w' to withdraw");
        System.out.println("[X] - Enter 'X' or 'x' to exit app");
        System.out.print("Choose Type of Operation [D, W, X] : ");
    }
}
