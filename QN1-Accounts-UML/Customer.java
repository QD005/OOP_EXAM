import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Account> accounts;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Account> getAccounts() { return accounts; }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added to customer " + name);
    }

    public double totalWorth() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public void displayAllStatements() {
        System.out.println("\n=== Statements for " + name + " ===");
        for (Account acc : accounts) {
            System.out.println(acc.generateStatement());
        }
        System.out.println("TOTAL WORTH: UGX " + String.format("%,.2f", totalWorth()));
    }
}