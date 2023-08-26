import java.util.Scanner; // Import Scanner Method
public class MergeSort {
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

    // Method to sort array using Merge sort
    public static void mergeSort(int[] list, int start, int end) {
        // If start equals end then array is either only 1 integer or end recursive calls
        if (start == end) {
            return;
        // There are two elements in the array, swap positions of integers if needed
        } else if (start == end-1) {
            if (list[start] <= list[end]) { // if start is less than or equal to end than return function w/o swap
                return;
            } else { // swap integers
                int temp = list[start]; // store start value in temporary variable
                list[start] = list[end]; // swap
                list[end] = temp; //swap
            }
        }

        // if base case of 1 or 2 elements in the array isn't met, calculate mid point
        int mid = (end-start)/2;
        // Recursive method call for left half of array
        mergeSort(list, start, start + mid);
        // Recursive method call for right half of array
        mergeSort(list, start + mid + 1, end);
        // Call merge method to merge array lists
        merge(list, start, start + mid, end);
    }

    private static void merge(int[] list, int leftHalfStart, int rightHalfStart, int end) {
        int leftHalfSize = rightHalfStart - leftHalfStart + 1;
        int rightHalfSize = end - rightHalfStart;

        int[] leftHalf = new int[leftHalfSize];
        int[] rightHalf = new int[rightHalfSize];

        // Loop through and assign left half values to leftHalf array
        for (int i=0; i<leftHalfSize; ++i)
            leftHalf[i] = list[leftHalfStart + i];
        // Loop through and assign right half values to rightHalf array
        for (int j=0; j<rightHalfSize; ++j)
            rightHalf[j] = list[rightHalfStart + 1+ j];

        int i = 0;
        int j = 0;

        int k = leftHalfStart;
        // Do while loop to merge rightHalf with leftHalf
        while (i < leftHalfSize && j < rightHalfSize) {
            // if leftHalf value is less than or equal to rightHalf value, then store leftHalf value first
            if (leftHalf[i] <= rightHalf[j]) {
                list[k] = leftHalf[i];
                i++; // increment i
            } else {
                // else rightHalf value is less than or equal to leftHalf value, then store rightHalf value first
                list[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalfSize) {
            list[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalfSize) {
            list[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}