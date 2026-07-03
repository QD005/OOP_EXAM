public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= 0) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn UGX " + amount + " from Savings Account");
        } else {
            System.out.println("WITHDRAWAL DENIED: Insufficient funds in Savings Account.");
            System.out.println("Requested: UGX " + amount + ", Available: UGX " + getBalance());
        }
    }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
        System.out.println("Interest added: UGX " + String.format("%,.2f", interest) + " at " + interestRate + "%");
    }
}