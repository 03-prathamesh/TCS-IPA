import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;

    // parameterised constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class BankUtils {

    public static Transaction TransferFunds(BankAccount fromAccount, BankAccount toAccount, double Amount,
            String transactionCode) throws InsufficientBalanceException {
        Transaction t; // created the transaction object

        String t_code = transactionCode;
        double amount = Amount;
        String timestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("Your have Insufficient Balance To Transfer the funds");
        } else {
            double finalBalance = fromAccount.getBalance() - amount;
            fromAccount.setBalance(finalBalance);
            double increasedBalance = toAccount.getBalance() + amount;
            toAccount.setBalance(increasedBalance);
        }
        t = new Transaction(t_code, amount, timestamp);

        return t;
    }

}

class Transaction {

    String transactionCode;
    double amount;
    String timeStamp;

    // parameterised constructor
    public Transaction(String transactionCode, double amount, String timeStamp) {
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    // getters
    public String getTransactionCode() {
        return transactionCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}

// exception class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankProblem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // create 2 objects of BankAccount class
        BankAccount acc[] = new BankAccount[2];
        for (int i = 0; i < acc.length; i++) {
            String acc_no = sc.nextLine();
            String holderName = sc.nextLine();
            double balance = sc.nextDouble();
            sc.nextLine();

            acc[i] = new BankAccount(acc_no, holderName, balance);
        }

        // BankUtils bs=new BankUtils();
        double amount = sc.nextDouble();
            String TransactionCode = sc.nextLine();
            sc.nextLine();
            // lets print object 1
        
            System.out.println("Before transaction");
            System.out.println("Account 1: " + acc[0].getHolderName() + "-" + acc[0].getAccountNumber() + "-"
                    + acc[0].getBalance());
            System.out.println("Account 2: " + acc[1].getHolderName() + "-" + acc[1].getAccountNumber() + "-"
                    + acc[1].getBalance());
        try {

            
            Transaction ans=BankUtils.TransferFunds(acc[0], acc[1], amount, TransactionCode);
            // lets print object 1
            System.out.println("Before transaction");
            System.out.println("Account 1: " + acc[0].getHolderName() + "-" + acc[0].getAccountNumber() + "-"
                    + acc[0].getBalance());
            System.out.println("Account 2: " + acc[1].getHolderName() + "-" + acc[1].getAccountNumber() + "-"
                    + acc[1].getBalance());


                    //transaction details
                    System.out.println("Transaction Code:"+ans.getTransactionCode());
                    System.out.println("Amount transfered"+ans.getAmount());
                    System.out.println("timeStamp: "+ans.getTimeStamp());
         
        }
         catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
