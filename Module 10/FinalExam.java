import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class FinalExam{
    public static void main (String[] args){
        ArrayList<Integer> scores = new ArrayList<>(); // Define array list of Integer types
        scores.add(90); //autoboxing
        scores.add(95);
        scores.add(110);
        scores.add(99);
        scores.add(105);
        letsGetEven(scores);
    }

    public static void letsGetEven( ArrayList<Integer> nums ) {
        for (int i = nums.size()-1; i >= 0; i--) {
            if (nums.get(i) / 2 == 0) {
                nums.delete(i);
            }
        }
    }
}
