import java.util.Scanner; // Import Scanner Method
import java.util.Random; // Import Random
public class InsertionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Define scanner variable
        int int_count = 1; // Declare variable the stores current value of array for input

        // Prompt user for number of values to sort
        System.out.print("How many numbers do you want to sort: ");
        int arrayLength = input.nextInt();
        int[] arrayToSort = new int[arrayLength]; // array to store selection from method

        // Loop through and get value inputs from users
        for (int x = 0; x < arrayLength; x++) {
            System.out.println("Enter number " + int_count + " value: "); // Prompt user for integers
            // Check if the input is an integer
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                input.next(); // Consume the invalid input
            }
            // Store input to array
            arrayToSort[x] = input.nextInt();
            int_count++; //increment int_count
        }
        // iterate through array and print values
        System.out.println("List of array values to sort: ");
        for (int x = 0; x < arrayToSort.length; x++){
            System.out.println(arrayToSort[x]);
        }

        // Start to tracking run time of algorithm
        long start = System.nanoTime();
        // Declare array to store number found and call insertionSearch Method
        int[] sortedArray = insertionSort(arrayToSort);
        // End to tracking run time of algorithm
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start)); // print run time

        // iterate through sorted array and print values
        System.out.println("Sorted array values: ");
        for (int x = 0; x < sortedArray.length; x++) {
            System.out.println(sortedArray[x]);
        }
    }

    // Linear Search Method
    public static int[] insertionSort(int[] input) {
        // loop through list of values
        for (int unsortedStart = 1; unsortedStart < input.length; unsortedStart++) {
            // store value of value next to starting point
            int nextInsert = input[unsortedStart];
            int currentIndex = unsortedStart - 1; // store value of initial value or next value

            // swap values until current indexed value is no longer lowest value or end of the list
            while (currentIndex >= 0 && input[currentIndex] > nextInsert) {
                input[currentIndex + 1] = input[currentIndex]; //swap
                currentIndex--;
            }
            input[currentIndex + 1] = nextInsert; // update
        }
        return input;
    }
}