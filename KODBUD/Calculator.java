import java.util.Scanner;
public class Calculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continueChoice;
        do {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            double result = 0;
            boolean validOperation = true;
            switch (choice) {
                case 1 -> result = num1 + num2;
                case 2 -> result = num1 - num2;
                case 3 -> result = num1 * num2;
                case 4 -> {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                        validOperation = false;
                    }
                }
                default -> {
                    System.out.println("Invalid choice! Please select between 1 and 4.");
                    validOperation = false;
                }
            }
            if (validOperation) {
                System.out.println("Result: " + result);
            }
            System.out.print("Do you want to continue? (y/n): ");
            continueChoice = sc.next().charAt(0);
        } while (continueChoice == 'y' || continueChoice == 'Y');
        System.out.println("Calculator exited. Thank you!");
        sc.close();
    }
}