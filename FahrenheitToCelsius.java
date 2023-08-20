import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);  // Define scanner variable
        System.out.print("Enter a Fahrenheit value: "); // Prompt user for Fahrenheit value
        int fahrenheit = input.nextInt();
        input.nextLine(); // Cleans up new line at end of user input nothing to read so it waits for data
        System.out.print("Enter day of the week, month and year: "); // Prompt user for day of the week
        String day = input.nextLine();
        double celsius = (5.0/9) * (fahrenheit - 32); // Convert to Celsius
        System.out.println(day + " Fahrenheit: " + fahrenheit); // Print values
        System.out.println(day + " Celsius: " + celsius);
        input.close();
    }
}