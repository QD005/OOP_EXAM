public class Main {
    public static void main(String[] args) {
        Account acc = new Account(200.0);
        try {
            acc.withdraw(150.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}