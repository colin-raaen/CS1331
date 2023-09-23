import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class FileTest {
    public static void main(String[] args){
        String inputFileName = args[0]; // take the filename from the command line and store in a String variable
        String word = args[1]; // store the word to search for from the command line in String variable "word"

        // create a new file object and store the matching name file into the new object
        // Using file path, starting with location
        File fileIn = new File(inputFileName);
        File fileOut = new File(word+"In"+inputFileName); // Create a new file object to write the file into

        Scanner fileScan = null; // initialize a Scanner object
        PrintWriter filePrint = null; // initialize a PrintWriter object

        try{
            fileScan = new Scanner(fileIn); // constructs fileScan with fileIn
            filePrint = new PrintWriter(fileOut); // constructs filePrint with fileOut
            int lineCount = 0; // initialize int counter variable for number of lines in file
            System.out.printf("Lines in %s containing %s:\n", args[0], args[1]);
            while (fileScan.hasNextLine()){ // While there is another line that exists in the file being scanned
                String line = fileScan.nextLine(); // Store line into String variable
                if (line.contains(word)){ // If line of words contains the stored word from the command line
                    filePrint.println(lineCount + ": " + line); // print line number and line to new output file
                }
                lineCount++; // increment lineCount variable
            }
        }
        catch (FileNotFoundException e){ // Exception handler if a file doesn't exist
            System.out.println(e.getMessage()); // Print error message
        }
        finally {
            if (fileScan != null) { // If fileScan isn't null i.e. File exists
                fileScan.close(); // Close Scanner object and subsequently the file
            }
            if (filePrint != null) { // If filePrint isn't null i.e. File exists
                filePrint.close(); // Close Scanner object and subsequently the file
            }
        }
    }
}
