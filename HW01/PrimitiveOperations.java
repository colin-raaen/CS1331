// HW01
public class PrimitiveOperations {
    public static void main (String[] args){
        int number = 50; // Initialize variables
        float decimal = 4.5f;
        System.out.println(number); // Print variables
        System.out.println(decimal);
        float multiplied = number * decimal; // Multiply variables and print
        System.out.println(multiplied);
        float number_float = (float)number; // Cast variables and print
        int decimal_int = (int)decimal;
        System.out.println(number_float);
        System.out.println(decimal_int);
        char letter = 'A'; // Define char
        System.out.println(letter);
        int lowerCase = letter + 32; // Convert to lowercase
        char letterLower = (char)lowerCase;
        System.out.println(letterLower);
    }
}