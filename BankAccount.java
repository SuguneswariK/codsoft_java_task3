import java.util.Scanner;
class BankAccount1 {
    double balance;
    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }
    public void menu() {
        System.out.println("Select the service from the ATM menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit amount");
        System.out.println("3. Withdraw amount");
        System.out.println("4. Exit");
    }
    public double getBalance() {
        System.out.println("Current balance: " + balance);
        return balance;
    }
    public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Successfully deposited. And the new available balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double withdrawalAmount) {
        if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
            balance -= withdrawalAmount;
            System.out.println("Successfully withdrawn. And the new available balance is: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance amount");
        }
    }
    public void option(int service) {
        Scanner sc = new Scanner(System.in);
        switch (service) {
            case 1:
                getBalance();
                break;
            case 2:
                System.out.println("Enter the amount you wish to deposit: ");
                double depositAmount = sc.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.println("Enter the amount you wish to withdraw: ");
                double withdrawalAmount = sc.nextDouble();
                withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for visiting!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid service.");
        }
    }
}
public class BankAccount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial balance");
        double initialBalance = sc.nextDouble();
        BankAccount1 ATM = new BankAccount1(initialBalance);
        while (true) {
            ATM.menu();
            System.out.print("Enter your choice (1-4): ");
            int service = sc.nextInt();
            ATM.option(service);
        }
    }
}
