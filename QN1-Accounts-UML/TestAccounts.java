public class TestAccounts {
    public static void main(String[] args) {
        System.out.println("*****");
        System.out.println("   COMMUNITY BANK - ACCOUNT MANAGEMENT SYSTEM");
        System.out.println("*****\n");

        // Create customer
        Customer customer = new Customer("C001", "John Mukasa");
        System.out.println("Customer created: " + customer.getName() + " (ID: " + customer.getCustomerId() + ")\n");

        // Create accounts
        SavingsAccount savings = new SavingsAccount("SA-2026-001", 500000.00, 5.0);
        CurrentAccount current = new CurrentAccount("CA-2026-001", 200000.00, 100000.00);

        // Add accounts to customer
        customer.addAccount(savings);
        customer.addAccount(current);

        // Display initial statements
        customer.displayAllStatements();

        // Test withdrawals
        System.out.println("\n--- TESTING WITHDRAWALS ---");

        System.out.println("\n1. Savings Account - Withdraw UGX 100,000 (should succeed):");
        savings.withdraw(100000);

        System.out.println("\n2. Savings Account - Withdraw UGX 500,000 (should FAIL - below zero):");
        savings.withdraw(500000);

        System.out.println("\n3. Current Account - Withdraw UGX 250,000 (should succeed - within overdraft):");
        current.withdraw(250000);

        System.out.println("\n4. Current Account - Withdraw UGX 100,000 (should FAIL - exceeds overdraft):");
        current.withdraw(100000);

        // Test interest
        System.out.println("\n--- TESTING INTEREST ---");
        savings.addInterest();

        // Final statements
        System.out.println("\n--- FINAL ACCOUNT STATEMENTS ---");
        customer.displayAllStatements();

        // Test polymorphism
        System.out.println("\n--- POLYMORPHISM TEST ---");
        Account acc1 = new SavingsAccount("SA-TEST", 100000, 3.5);
        Account acc2 = new CurrentAccount("CA-TEST", 50000, 20000);

        System.out.println("\nSavingsAccount as Account type:");
        System.out.println(acc1.generateStatement());
        acc1.withdraw(50000);

        System.out.println("\nCurrentAccount as Account type:");
        System.out.println(acc2.generateStatement());
        acc2.withdraw(60000);

        System.out.println("\n*****end of TestAccounts.java*****");
      
    }
}