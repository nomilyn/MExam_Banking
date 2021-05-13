package midterm_banking;

public class CheckingAccount extends Account {
    double overdraft;

    public CheckingAccount(int accountNumber, Customer customer, double balance, double overdraft) {
        super(accountNumber, customer, balance, "Checking");
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
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
            double allowedAmountToWithdraw = this.balance + this.overdraft;
            if(amountToWithdraw <= allowedAmountToWithdraw) {
                this.balance -= amountToWithdraw;
            }
            else {
                System.out.println("=================================================================================");
                System.out.println("The amount you are trying to withdraw exceeds your current balance plus overdraft");
                System.out.println("=================================================================================\n");
            }
        }
        else {
            System.out.println("You entered an invalid amount!");
        }
        return this.balance;
    }
}
