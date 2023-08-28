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

        // Code to generate a large list of integers
        Integer[] numbers = new Integer[1000000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }
        // Start to tracking run time of algorithm
        long start = System.nanoTime();
        // Declare int to store number found and call LinearSearch Method to Search large list of numbers
        int foundNumberIndex = linearSearch(numberToFind, numbers);
        // End to tracking run time of algorithm
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start)); // print run time
        if (foundNumberIndex != -1){
            System.out.println("Found number: " + numbers[foundNumberIndex]);
        }
        else {
            System.out.println("Number not found");
        }
    }

    // Linear Search Method
    public static int insertionSort(Comparable target, Comparable[] list) {
        int index = 0;
        while (index < list.length) {
            if (list[index].compareTo(target) == 0)
                return index;
            else
                index++;
        }
        return -1;
    }
}