import java.util.Scanner;
public class ATMSimulation {
    static double balance = 1000.0; 
    public static void checkBalance() {
        System.out.printf("Your current balance is: ", balance);
    }
    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf(" Deposited successfully.\n", amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf(" Withdrawn successfully.\n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println(" ATM MENU ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); 
                continue;
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    if (sc.hasNextDouble()) {
                        deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    if (sc.hasNextDouble()) {
                        withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                }
                case 4 -> System.out.println("Thank you for using ATM!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}