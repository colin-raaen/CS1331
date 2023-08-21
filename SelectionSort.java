import java.util.Scanner; // Import Scanner Method
public class SelectionSort {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);  // Define scanner variable
        int[] arrayToSort = new int[5]; // array to store selection from method
        int int_count = 1; // Declare variable
        for (int x = 0; x < 5; x++) {
            System.out.println("Enter number " + int_count + " value: "); // Prompt user for integers
            // Check if the input is an integer
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                input.next(); // Consume the invalid input
            }
            // Store input to array
            arrayToSort[x] = input.nextInt();;
            int_count++; //increment int_count
        }
        // iterate through array and print values
        for (int x = 0; x < 5; x++){
            System.out.println("List of array values to sort: ");
            System.out.println(arrayToSort[x]);
        }

        int[] sortedArray = new int[5]; // array to store selection from method
        // Call Method to Sort Values
        sortedArray = sortArray(arrayToSort);

    }

    // Method to sort array using Selection sort
    private static int[] sortArray(int[]){
        int minIndex; // declare int to store minimum value in array
        int comparisonCount; // declare int to store number of comparisons that have happened
        // loop through array of values
        for (int x = 0; x < 5; x++){

            for (int y=0; y < comparisonCount; y++)

        }
    }
}