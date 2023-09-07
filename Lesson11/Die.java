import java.util.Random;

public class Die {
    public static final int SIDES = 6; //declare variable that represents number of sides of a die
    private int faceValue; // int variable to represents total of face value of roll
    private Random rand; //used for generating random number, imported from util package

    // Die Constructor
    public Die(){
        faceValue = 1; // set initial value to one to avoid logical error
        rand = new Random();
    }

    // Roll method
    public int roll(){
        faceValue = rand.nextInt(SIDES) + 1;
        return faceValue;
    }

    //Getter method
    public int getFaceValue(){
        return faceValue;
    }

    // toString override Method
    public String toString(){
        return "Die with the face value: " + faceValue;
    }

    // Main
}
