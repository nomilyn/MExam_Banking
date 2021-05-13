package midterm_banking;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(int accountNumber, Customer customer, double balance) {
        super(accountNumber, customer, balance, "Savings");
    }
    
    @Override
    public void AccountDetails() {
        System.out.println("***********************************************************");
        System.out.println("\nName : " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Balance : " + balance);
        System.out.println("Account Type : " + type);
    }
    
    @Override
    public double withdraw(double amountToWithdraw) {
        if(amountToWithdraw > 0) {
            if(amountToWithdraw <= this.balance) {
                this.balance -= amountToWithdraw;
            }
            else {
                System.out.println("==================================================================");
                System.out.println("The amount you are trying to withdraw exceeds your current balance");
                System.out.println("==================================================================\n");
            }
        }
        else {
            System.out.println("You entered an invalid amount!");
        }
        return this.balance;
    }
}
