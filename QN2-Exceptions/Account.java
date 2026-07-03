public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // Method declares and throws the checked exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds: balance is " + balance + " but withdrawal requested is " + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}