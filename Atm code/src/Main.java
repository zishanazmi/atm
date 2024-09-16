import java.util.Scanner;

public class Main {
    private static double balance = 1000.00;
    private static final String PIN = "1234";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //promt the user for the PIN
        if (authenticate(scanner)){
            while (!exit){
                System.out.println("\n--- Welcome to the ATM ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.println("Please choose an option: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositBalance(scanner);
                        break;
                    case 3:
                        withdrawMoney(scanner);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid Option. Please try again");
                }

            }
        }else {
            System.out.println("Invalid PIN. Access denied.");
        }
        scanner.close();
    }

    //Method to authenticate the user by checking the pin
    public static boolean authenticate(Scanner scanner){
        System.out.print("Please enter your PIN: ");
        String inputPin = scanner.next();

        if (inputPin.equals(PIN)){
            System.out.println("Authentication successful.");
            return true;
        }else {
            return false;
        }
    }

    //check the balance.
    public static void checkBalance(){
        System.out.printf("Your current balance is : $%.2f%n", balance);
    }

    //Deposit money
    public static void depositBalance(Scanner scanner){
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0){
            balance += amount;
            System.out.printf("$%.2f has been deposited to your account. %n", amount);
        }else{
            System.out.println("Invalid ammount. please try again.");
        }
    }

    //Withdraw money
    public static void withdrawMoney(Scanner scanner){
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.printf("$%.2f has been withdrawn from your account. %n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }else {
            System.out.println("Invalid amount. please try again.");
        }
    }
}