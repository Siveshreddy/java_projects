import java.util.Scanner;  // This import is REQUIRED for user input

public class ATM_Interface {
    
    // Global variables to store user data
    // Static means these belong to the class and persist while the program runs
    private static float balance = 5000.00f; 
    private static final int PIN = 1234;     
    
    public static void main(String[] args) {
        // Initialize the scanner for reading input
        Scanner sc = new Scanner(System.in);
        boolean sessionActive = true;

        System.out.println("====================================");
        System.out.println("       WELCOME TO JAVA BANK ATM      ");
        System.out.println("====================================");

        // --- Step 1: Authentication Loop ---
        int attempts = 0;
        boolean authenticated = false;
        
        while (attempts < 3 && !authenticated) {
            System.out.print("Enter your 4-digit PIN: ");
            
            // Check if user actually entered a number
            if (sc.hasNextInt()) {
                int enteredPin = sc.nextInt();
                if (enteredPin == PIN) {
                    authenticated = true;
                    System.out.println("\nAccess Granted. Welcome!");
                } else {
                    attempts++;
                    System.out.println("Incorrect PIN. Attempts remaining: " + (3 - attempts));
                }
            } else {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.next(); // Clear the invalid input from scanner buffer
            }
        }

        // --- Step 2: Main Menu (Only runs if PIN is correct) ---
        if (authenticated) {
            while (sessionActive) {
                // Print the menu options
                System.out.println("\n----------- MAIN MENU -----------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                
                if (sc.hasNextInt()) {
                    int choice = sc.nextInt();
                    
                    switch (choice) {
                        case 1:
                            checkBalance();
                            break;
                        case 2:
                            depositMoney(sc);
                            break;
                        case 3:
                            withdrawMoney(sc);
                            break;
                        case 4:
                            System.out.println("\nThank you for using our ATM. Goodbye!");
                            sessionActive = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please select 1-4.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next(); // Clear invalid input
                }
            }
        } else {
            System.out.println("Too many failed attempts. Account Locked.");
        }
        
        sc.close();
    }

    // --- Helper Methods ---

    private static void checkBalance() {
        System.out.printf("\n[INFO] Current Balance: $%.2f%n", balance);
    }

    private static void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit: $");
        if (sc.hasNextFloat()) {
            float amount = sc.nextFloat();
            if (amount > 0) {
                balance += amount;
                System.out.printf("\n[SUCCESS] $%.2f deposited successfully.%n", amount);
                checkBalance();
            } else {
                System.out.println("[ERROR] Amount must be positive.");
            }
        } else {
            System.out.println("[ERROR] Invalid amount entered.");
            sc.next();
        }
    }

    private static void withdrawMoney(Scanner sc) {
        System.out.print("Enter amount to withdraw: $");
        if (sc.hasNextFloat()) {
            float amount = sc.nextFloat();
            if (amount > balance) {
                System.out.println("[ERROR] Insufficient funds.");
            } else if (amount <= 0) {
                System.out.println("[ERROR] Amount must be positive.");
            } else {
                balance -= amount;
                System.out.printf("\n[SUCCESS] Please collect your cash: $%.2f%n", amount);
                checkBalance();
            }
        } else {
            System.out.println("[ERROR] Invalid amount entered.");
            sc.next();
        }
    }
}