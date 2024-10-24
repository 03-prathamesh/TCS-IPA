// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            // Throw custom exception if balance is not enough
            throw new InsufficientBalanceException("Insufficient balance! You can't withdraw " + amount);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
    }
}

// Main Class to test the exception handling
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", "John", 5000.0);

        try {
            // Attempting to withdraw more money than available in the balance
            account.withdraw(6000.0);
        } catch (InsufficientBalanceException e) {
            // Handling the exception
            System.out.println(e.getMessage());
        }

        // Attempting a valid withdrawal
        try {
            account.withdraw(2000.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
