import java.util.ArrayList;

public class IntArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>(); // Define array list of Integer types
        scores.add(90); //autoboxing
        scores.add(95);
        scores.add(110);
        scores.add(99);
        scores.add(105);
        System.out.println(scores.toString()); // Print array list to terminal

        int sum = 0; // Define variable
        for (Integer score : scores){
            sum += score; // Autounboxing
        }
        System.out.println("Total points: " + sum); // Print sum
    }
}