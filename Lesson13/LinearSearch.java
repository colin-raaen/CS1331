import java.util.Scanner; // Import Scanner Method
import java.util.Random; // Import Random
public class LinearSearch {
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
    public static int linearSearch(Comparable target, Comparable[] list) {
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