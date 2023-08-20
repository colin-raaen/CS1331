public class ArraySearch {
    // main function
    public static void main(String args[]) {
        String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};
        // Call method to check for target word
        System.out.println(searchArray("check me", concepts));
        // Call method to check for target word print result
        System.out.println(searchArray("inheritance", concepts));
        // define int array and call method
        int[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
        System.out.println(searchArray(90, weekHighs));
    }

    // New overloaded method to search for words in an array
    public static boolean searchArray(String target, String[] array) {
        // declare String variable to store result
        boolean result = false;
        for (String element : array)
        {
            if (element.equals(target))
            {
                result = true;
                break;
            }
        }
        return result;
    }

    // New overloaded method to search for ints in an array
    public static boolean searchArray(int target, int[] array) {
        // declare String variable to store result
        boolean result = false;
        for (int element : array)
        {
            if (element == target)
            {
                result = true;
                break;
            }
        }
        return result;
    }
}