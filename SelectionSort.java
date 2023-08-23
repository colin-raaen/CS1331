import java.util.Scanner; // Import Scanner Method
public class SelectionSort {
    public static void main (String[] args) {

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

        // Declare array and call Method to Sort Values
        int[] sortedArray = sortArray(arrayToSort);

        // iterate through sorted array and print values
        System.out.println("Sorted array values: ");
        for (int x = 0; x < sortedArray.length; x++) {
            System.out.println(sortedArray[x]);
        }
    }

    // Method to sort array using Selection sort
    private static int[] sortArray(int[] input){
        int minIndex; // declare int to store minimum value in array

        // loop through array of values
        for (int x = 0; x < (input.length - 1); x++){
            minIndex = x; // current lowest value of array to compare against
            // loop through remaining unsorted elements
            for (int y = x + 1; y < input.length; y++){ // start at x + 1 since it is value next to x in array
                if ((input[y]) < input[minIndex]){ // If int[y] is less than current lowest value, update minIndex
                    minIndex = y; //update minIndex to reflect new min value
                }
            }
            int oldValue = input[x]; //Store old value
            int newValue = input[minIndex]; // Store new value
            input[minIndex] = oldValue; // Swap Values
            input[x] = newValue; // Swap Values

        }
        return input;
    }
}