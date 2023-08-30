import java.util.Scanner; // Import Scanner Method
import java.util.Random; // Import Random
public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Define scanner variable

        // Prompt user for number to find
        System.out.print("What number do you want to find: ");
        int numberToFind = input.nextInt();

        // Code to generate a large list of integers
        Integer[] numbers = new Integer[1000000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        // Declare array to store number found and call insertionSort Method
        Comparable[] sortedArray = mergeSort(numbers, 0, numbers.length - 1);
        // Check if sortedArray is empty
        if (sortedArray.length == 0) {
            System.out.println("The sorted array is empty.");
            // You can choose to exit the program here if needed
            System.exit(0); // Exit with a status code of 0 (success)
        }

        // Start to tracking run time of algorithm
        long start = System.nanoTime();
        // Declare int to store number found and call LinearSearch Method to Search large list of numbers
        int foundNumberIndex = binarySearch(numberToFind, sortedArray);
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

    // Method to sort array using Merge sort
    public static Comparable[] mergeSort(Comparable[] list, int start, int end) {
        int i = 0; // counter variable to know when to print sorted values
        // If start equals end then array is either only 1 integer or end recursive calls
        if (start == end) {
            Comparable[] result = new Comparable[1];
            result[0] = list[start];
            return result; // exit method and return array of 1
            // There are two elements in the array, swap positions of integers if needed
        } else if (start == end - 1) {
            if (list[start].compareTo(list[end]) <= 0){ // if start is less than or equal to end than return function w/o swap
                Comparable[] result = new Comparable[2];
                result[0] = list[start];
                result[1] = list[end];
                return result; // return a two-element array
            } else { // swap integers
                Comparable[] result = new Comparable[2];
                result[0] = list[end];
                result[1] = list[start];
                return result;
            }
        }

        // if base case of 1 or 2 elements in the array isn't met, calculate mid point
        int mid = (end-start) / 2;
        Comparable[] leftHalf = mergeSort(list, start, start + mid);
        Comparable[] rightHalf = mergeSort(list, start + mid + 1, end);
        return merge(leftHalf, rightHalf);
    }

    // method helper to merge sublists
    private static Comparable[] merge(Comparable[] left, Comparable[] right) {
        Comparable[] result = new Comparable[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

    // binary Search Method
    public static int binarySearch(Comparable target, Comparable[] list) {
        // declare variables to mark beginning, middle and end points of list, mid will be assinged later
        int start = 0, end = list.length - 1, mid = 0;

        // while array or sub-array left to search has at least one item to check
        while (start <= end) {
            // calculate mid point of array or sub-array
            mid = (start + end) / 2;
            // if mid value is the target, value is found, return mid value and exit
            if (list[mid].compareTo(target) == 0)
                return mid;
            // else if target is less than mid value, explore left sub-array
            else if (target.compareTo(list[mid]) < 0)
                // move end point to one position to the left of mid (left-half), continue evaluating new sub-array
                end = mid - 1;
            // else if target is more than mid value, explore right sub-array
            else
                // move start point to one position to the right of mid (right-half), continue evaluating new sub-array
                start = mid + 1;
        }
        return -1; // value isn't found in intial array passed in
    }
}