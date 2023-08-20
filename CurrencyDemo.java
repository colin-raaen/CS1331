import java.util.Scanner;
import java.text.NumberFormat;

public class CurrencyDemo {
    public static void main(String[] args) {
        int items;  // Declare int variable
        double itemCost, total; // Declare item cost and total variables
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: "); // get user input on number of itmes
        items = input.nextInt();  // store user input for number of items in variable
        System.out.print("Enter the cost per item: "); // get user input on cost per item
        itemCost = input.nextDouble();
        total = items * itemCost;
        System.out.println();
        System.out.println("Unformatted Total: " + total); // Print unformatted
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); // define formatted currency variable to call
        System.out.println("Formatted Total: " + currencyFormat.format(total)); // Print formatted currency
        input.close();
    }
}