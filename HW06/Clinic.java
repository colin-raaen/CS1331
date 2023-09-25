import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile; // private variable File with patient information
    private int day; // define variable int that is day

    // Constructor for Clinic, defines variable patientFile using parameter
    public Clinic(File file){
        this.patientFile = file; // Assign file that contains patient info to patientFile
        this.day = 1; // Day initialized to 1
    }

    // Constructor that chains,
    public Clinic(String fileName){
        // chain to first constructor while creating a new file using name of string stored to pass into the constructor
        this(new File(fileName));
    }

    // Method
    public String nextDay(File f) throws FileNotFoundException{
        Scanner fileScan = null; // Define null Scanner for file scan
        Scanner petScan = null; // define null scanner for pet scan
        String[] petNames = null; // define array of Strings to store values parsed from CSV file
        String[] petTypes = null;; // define array of Strings that stores petTypes

        int[] allTimes = new int[10]; // define array to store appointment times
        int index = 0; // int to count index of arrays

        try {
            fileScan = new Scanner(f); // constructs fileScan with fileIn
            String line = null; // define string to store pet information

            while (fileScan.hasNextLine()) { // While there is another line that exists in the file being scanned
                line = fileScan.nextLine(); // Scan next line into String variable
                petScan = new Scanner(line); // Create new Scanner object with String "line" as input
                petScan.useDelimiter(","); // Use delimiter to parse .csv values at comma
                petNames[index] = petScan.next(); // Store first string value in array of names
                petTypes[index] = petScan.next(); // Store first string value in array of names
                petScan.nextDouble(); // consume double
                allTimes[index] = petScan.nextInt(); // Store time of appointment
                index++; // increment index value

                // Print statement with details to and prompt user for health of pet
                System.out.println("Consultation for " + petNames[index] + " the " + petTypes[index] + " at "
                        + allTimes[index] + ".\nWhat is the health of " + petNames[index] + "?\n");


            }
        }
        catch (FileNotFoundException e){ // Exception handler if a file doesn't exist
            System.out.println(e.getMessage()); // Print error message
        }
        finally {
            if (fileScan != null) { // If fileScan isn't null i.e. File exists
                fileScan.close(); // Close Scanner object and subsequently the file
            }
        }
        return null;


    }

    // Method
    public String nextDay(String fileName) throws FileNotFoundException{
        return null;
    }
}