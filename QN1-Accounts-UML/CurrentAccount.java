public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn UGX " + amount + " from Current Account");
        } else {
            System.out.println("WITHDRAWAL DENIED: Exceeds overdraft limit of UGX " + overdraftLimit);
            System.out.println("Requested: UGX " + amount + ", Available (with overdraft): UGX " + (getBalance() + overdraftLimit));
        }
    }
}