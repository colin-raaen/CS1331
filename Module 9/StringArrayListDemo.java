import java.util.ArrayList;

public class StringArrayListDemo{
    public static void main (String[] args){
        // define array list with element type String
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Humpty Dumpty"); // Add String to ArrayList
        playlist.add("Swing Low Sweet Chariot"); // Add String to ArrayList
        playlist.add("Itsy Bitsy Spider"); // Add String to ArrayList
        playlist.add("Twinkle Twinkle, Little Star"); // Add String to ArrayList
        playlist.add("Wheels on the Bus"); // Add String to ArrayList
        System.out.println(playlist.toString()); // Gets the contents of the list as a whole and print

        playlist.remove("Humpty Dumpty"); // remove String to ArrayList
        System.out.println(playlist.toString()); // Print list to terminal
        System.out.println(playlist.contains("Humpty Dumpty")); // Print line if contains humpty dumpty
        System.out.println(playlist.contains("Itsy Bitsy Spider")); // Print line if contains itsy bitsy
        playlist.add("Humpty Dumpty"); // Add String to ArrayList
        System.out.println(playlist.toString()); // Print list to terminal
    }
}