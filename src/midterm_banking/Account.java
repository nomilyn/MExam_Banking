package midterm_banking;

public abstract class Account {
    private int accountNumber;
    Customer customer;
    double balance;
    String type;

    public Account() {
    }

    public Account(int accountNumber, Customer customer, double balance, String type) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.type = type;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 
    //Methods
    public abstract double withdraw(double amountToWithdraw);
    public abstract void AccountDetails();
    
    public double deposit(double amountToDeposit) {
        if(amountToDeposit > 0) {
            balance += amountToDeposit;
        }
        else {
            System.out.println("You entered an invalid amount!");
        }
        return balance;
    }    
}