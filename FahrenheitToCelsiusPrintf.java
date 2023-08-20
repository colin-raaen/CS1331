import java.util.Scanner;

public class FahrenheitToCelsiusPrintf {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter day of the week: ");
        String day = input.next();
        System.out.print("Enter your preferred label (Celsius, Centigrade, C): ");
        String cText = input.next() + ":";
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
        System.out.printf("%s %-11s %.1f\n", day, cText, celsius);
        input.close();
    }
}