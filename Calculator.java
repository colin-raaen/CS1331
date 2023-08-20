import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Define scanner variable
        String operator_input; // Declare  variable for user input

        String errorMessage = "Invalid input entered. Terminating..."; //store error message
        System.out.println("List of operations: add subtract multiply divide alphabetize"); // Print list of operations
        System.out.println("Enter an operation: "); // Prompt user for operation to perform
        operator_input = input.nextLine(); // store input into variable

        String operator_check = operator_input.toLowerCase(); //convert user input to lower case for conditional check

        // Switch conditional checks of user input
        switch (operator_check) {
            // Case user inputs add
            case "add":
                System.out.println("Enter two integers: "); // Prompt user for two integers
                // Check if first input is an integer
                if (input.hasNextInt()) {
                    // if input is integer than initialize int variable aand store input
                    int addInteger1 = input.nextInt();
                    // Check if second input is an integer
                    if (input.hasNextInt()) {
                        // if input is integer than initialize int variable aand store input
                        int addInteger2 = input.nextInt();
                        // add numbers together and print if both inputs are valid
                        System.out.println("Answer: " + (addInteger1 + addInteger2)); // Print calculated value
                    }
                    // if second input is not an integer or no input provided then print error message and terminate program
                    else {
                        System.out.println(errorMessage); // Print error message
                        break;
                    }
                }
                // if first input is not an integer or no input provided then print error message and terminate program
                else {
                    System.out.println(errorMessage); // Print error message
                    break;
                }
                break; // exit Switch structure

            // Case user inputs subtract
            case "subtract":
                System.out.println("Enter two integers: "); // Prompt user for two integers
                // Check if first input is an integer
                if (input.hasNextInt()) {
                    // if input is integer than initialize int variable aand store input
                    int subtractInteger1 = input.nextInt();
                    // Check if second input is an integer
                    if (input.hasNextInt()) {
                        // if input is integer than initialize int variable aand store input
                        int subtractInteger2 = input.nextInt();
                        // subtract numbers together and print if both inputs are valid
                        System.out.println("Answer: " + (subtractInteger1 - subtractInteger2)); // Print calculated value
                    }
                    else {
                        System.out.println(errorMessage); // Print error message
                        break;
                    }
                }
                else {
                    System.out.println(errorMessage); // Print error message
                    break;
                }
                break; // Break switch statement

            // Case user inputs multiply
            case "multiply":
                System.out.println("Enter two doubles: "); // Prompt user for two doubles
                // Check if first input is a double
                if (input.hasNextDouble()) {
                    // Initialize variable and store input
                    double multiplyInteger1 = input.nextDouble();
                    // Check if second input is a double
                    if (input.hasNextDouble()) {
                        double multiplyInteger2 = input.nextDouble();
                        // calculate multiplication of values
                        System.out.printf("Answer: %.2f\n",  (multiplyInteger1 * multiplyInteger2)); // Print calculated value
                    }
                    else {
                        System.out.println(errorMessage); // Print error message
                        break;
                    }
                }
                else {
                    System.out.println(errorMessage); // Print error message
                    break;
                }
                break; // break Switch statement

            // Case user inputs divide
            case "divide":
                System.out.println("Enter two doubles: "); // Prompt user for two doubles
                // Check if first input is a double
                if (input.hasNextDouble()) {
                    double divisionInteger1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double divisionInteger2 = input.nextDouble();
                        // If divisor is 0 then print error message and terminate program
                        if (divisionInteger2 != 0) {
                            System.out.printf("Answer: %.2f\n", (divisionInteger1 / divisionInteger2)); // Divide numbers and print
                        }
                    }
                    else {
                        System.out.println(errorMessage); // Print error message
                    }
                }
                else {
                    System.out.println(errorMessage); // Print error message
                }
                break; // break Switch statement

            // Case user inputs alphabetize
            case "alphabetize":
                System.out.println("Enter two words: "); // Prompt user for two integers
                // initialize array and store inputs
                String string1 = input.next();
                String string2 = input.next();

                boolean alphaCheck = false;
                // check if first input only has letters
                int len1 = string1.length();
                for (int i = 0; i < len1; i++) {
                    // checks whether the character is not a letter, if it is not a letter ,it will return false
                    if ((Character.isLetter(string1.charAt(i)) == false)) {
                        alphaCheck = false;
                        break;
                    }
                    else {
                        alphaCheck = true;
                    }
                }

                // if non-alpha found, terminate program
                if (alphaCheck == false){
                    System.out.println(errorMessage); // Print error message
                    return;
                }

                // check if second input only has letters
                int len2 = string2.length();
                for (int i = 0; i < len2; i++) {
                    // checks whether the character is not a letter, if it is not a letter ,it will return false
                    if ((Character.isLetter(string2.charAt(i)) == false)) {
                        alphaCheck = false;
                        break;
                    }
                    else {
                        alphaCheck = true;
                    }
                }

                // if non-alpha found, terminate program
                if (alphaCheck == false){
                    System.out.println(errorMessage); // Print error message
                    return;
                }
                
                // String comparisons to alphabetize
                if (string1.toLowerCase().compareTo(string2.toLowerCase()) < 0) {
                    // String1 is smaller
                    // print output
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", string1, string2);

                    break;
                }
                else if (string1.toLowerCase().compareTo(string2.toLowerCase()) > 0) {
                    // String1 is larger
                    // print output
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", string2, string1);

                    break;
                }
                else {
                    // string1 is equal to string2
                    // print output
                    System.out.println("Answer: Chicken or Egg.");

                    break;
                }

            // Default value if no match found
            default:
                System.out.println(errorMessage); // Print error message
                break;

        }

        return; // Exit the program

    }
}