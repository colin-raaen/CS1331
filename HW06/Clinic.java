import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile; // private variable File with patient information
    private int day; // define variable int that is day

    Scanner fileScan = null; // initialize a Scanner object
    PrintWriter filePrint = null; // initialize a PrintWriter object

    // Constructor
    public Clinic(File file){
        this.patientFile = file; // Assign file that contains patient info to patientFile
        this.day = 1; // Day initialized to 1
    }

    // Constructor
    public Clinic(String fileName){
        // chain to first constructor while creating a new file using name of string to pass into the constructor
        this(new File(fileName));
    }

    // Method
    public String nextDay(File f) throws FileNotFoundException{
        return null;
    }

    // Method
    public String nextDay(String fileName) throws FileNotFoundException{
        return null;
    }
}