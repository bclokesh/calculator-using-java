import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Java Console Calculator ===");

        while (keepRunning) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1–5): ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // clear invalid token
                continue;
            }

            if (choice == 5) {
                keepRunning = false;
                System.out.println("Calculator closed. Goodbye!");
                break;
            }

            System.out.print("Enter first number: ");
            double num1;
            try {
                num1 = scanner.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid number. Start over.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter second number: ");
            double num2;
            try {
                num2 = scanner.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid number. Start over.");
                scanner.nextLine();
                continue;
            }

            double result;
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1–5.");
            }
        }

        scanner.close();
    }
}
