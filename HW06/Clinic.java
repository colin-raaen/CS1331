import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile; // private variable File with patient information
    private int day; // define variable int that is day

    private static Pet[] pets = null; // define array of Pets to store values parsed from CSV file

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
    public String nextDay(File f) throws FileNotFoundException, InvalidPetException{
        Scanner fileScan = null; // Define null Scanner for file scan
        Scanner petScan = null; // define null scanner for pet scan
        Scanner userInput = null; // define null Scanner object for user input
        int index = 0; // int to count index of arrays

        try {
            fileScan = new Scanner(f); // constructs fileScan with fileIn
            userInput = new Scanner(System.in); // constructs userInput to collect user input
            String line = null; // define string to store pet information

            while (fileScan.hasNextLine()) { // While there is another line that exists in the file being scanned
                line = fileScan.nextLine(); // Scan next line into String variable
                petScan = new Scanner(line); // Create new Scanner object with String "line" as input
                petScan.useDelimiter(","); // Use delimiter to parse .csv values at comma
                String petName = petScan.next(); // Store first string value in array of names
                String petType = petScan.next(); // Store next string value in array of pet types
                double dogDroolRate; // declare variable to store drool rate if dog
                int catMiceCaught; // declare int variable to store miceCaught if cat

                if (petType.equals("Dog")){ // if petType is a Dog
                    dogDroolRate = petScan.nextDouble(); // store dog double drool rate
                }
                else if (petType.equals("Cat")){ // else if pet type is a Cat
                    catMiceCaught = petScan.nextInt(); // store cat int miceCaught
                }

                int appointmentTime = petScan.nextInt(); // Store time of appointment

                double petHealth = 0; // declare int to store user input

                // do-while loop to continuously prompt user for an int for pet's health
                do{
                    // Print statement with details to and prompt user for health of pet
                    System.out.println("Consultation for " + petName + " the " + petType + " at "
                            + appointmentTime + ".\nWhat is the health of " + petName + "?\n");

                    // if input provided by user is an int
                    if (userInput.hasNextInt()) {
                        petHealth = userInput.nextDouble(); // store user input in vairalbe
                        break; // Exit the loop if the input is an integer
                    }
                    else { // if input is not an integer
                        userInput.nextLine(); // Consume the invalid input
                    }
                } while (true); // continue to reprompt the user until an int is input


                // if pet type isn't valid entry
                if (!petType.equals("Cat") || !petType.equals("Dog")) {
                    // throw new exception, calling InvalidPetException, which is extended in method name
                    throw new InvalidPetException();
                }

                int painLevel = 0; // declare int to store user input for pain level

                // do-while loop to continuously prompt user for an int for pet's health
                do{
                    // Print statement with details to and prompt user for health of pet
                    System.out.println("On a scale of 1 to 10, how much pain is " + petName + "in right now?\n");

                    // if input provided by user is an int
                    if (userInput.hasNextInt()) {
                        painLevel = userInput.nextInt(); // store user input in vairalbe
                        break; // Exit the loop if the input is an integer
                    }
                    else { // if input is not an integer
                        userInput.nextLine(); // Consume the invalid input
                    }
                } while (true); // continue to reprompt the user until an int is input

                if (petType.equals("Dog")){ // if petType is a Dog
                    // create dog object with values scanned from file
                    Dog petCreated = new Dog(petName, petHealth, painLevel, dogDroolRate);
                }
                else if (petType.equals("Cat")){ // else if pet type is a Cat
                    // create cat object with values scanned from file
                    Cat petCreated = new Cat(petName, petHealth, painLevel, catMiceCaught);
                }


                petCreated.speak(); // Call speak method

                petCreated.treat(); // call treat method

                index++; // increment index value
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