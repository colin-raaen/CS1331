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

    // nextDay method which cans input Appointment csv and outputs string with appointments to be output
    public String nextDay(File f) throws FileNotFoundException, InvalidPetException{
        day++; // increment day after scanning file and updating patients information
        // Define inputScanner Scanner with file input, that parses the file at every line break
        Scanner fileScan = new Scanner(f);
        Scanner userInput = new Scanner(System.in); // define userInput Scanner object to collect user input
        boolean success = false; // intialize boolean variable for exception controlled loop

        String petName; // String to store pet's name
        String petType; // String to store pet type
        String appointmentTime; // String to store appointment start time
        String exitTime = ""; // String to store end of appointment time
        double petHealth = 0; // declare int to store user input
        int painLevel = 0; // declare int to store user input for pain level
        String droolOrMiceCaught; // declare variable to store drool rate if dog, assign a sentinel value
        String updatedPatientInfo = ""; // String to store updated patient information that will be returned
        String line = null; // declare string to store line of file to split

        // While there is another line that exists in the file being scanned
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine(); // Store first string value in array of names
            String[] petLine = line.split(","); // Parse the line breaking at the commas
            petName = petLine[0]; // Store first string value in array of names
            petType = petLine[1]; // Store next string value in array of pet types
            droolOrMiceCaught = petLine[3]; // store dog double drool rate
            appointmentTime = petLine[4]; // Store time of appointment as a string

            // if pet type isn't valid entry
            if (!petType.equals("Cat") && !petType.equals("Dog")) {
                throw new InvalidPetException(); // throw new exception, calling custom InvalidPetException
            }

            // Excpetion controlled loop to prompt user for an int for pet's health
            while (!success){ // continue to reprompt the user until an int
                // Print statement with details to and prompt user for health of pet
                System.out.println("Consultation for " + petName + " the " + petType + " at " + appointmentTime + ".\n"
                        + "What is the health of " + petName + "?");
                if (userInput.hasNextDouble()){
                    petHealth = userInput.nextDouble(); // store user input in vairalbe
                    success = true; // Exit the loop if the input is an integer
                }
                else{
                    userInput.nextLine(); // Clear invalid input
                    System.out.println("Please enter a number");
                }
            }

            success = false; // Reset value of boolena for next user input check

            // Excpetion controlled loop to prompt user for an int for pet's health
            while (!success){
                // Print statement with details to and prompt user for health of pet
                System.out.println("On a scale of 1 to 10, how much pain is " + petName + " in right now?");
                if (userInput.hasNextInt()){
                    painLevel = userInput.nextInt(); // store user input in variable
                    success = true; // Exit the loop if the input is an integer
                }
                else{
                    userInput.nextLine(); // Consume the invalid input
                    System.out.println("Please enter a number"); // print invalid input
                }
            }

            Pet petCreated; // Initalize Pet object or instance creation
            // Code block to create instance of Dog
            if (petType.equals("Dog")){ // if petType is a Dog
                // create dog object with values scanned from file
                petCreated = new Dog(petName, petHealth, painLevel, Double.parseDouble((droolOrMiceCaught)));
            }
            // else if code block to create instance of Cat
            else if (petType.equals("Cat")){ // else if pet type is a Cat
                // create cat object with values scanned from file
                petCreated = new Cat(petName, petHealth, painLevel, Integer.parseInt((droolOrMiceCaught)));
            }
            else{
                throw new InvalidPetException(); // Throw invalid pet exception
            }

            painLevel = petCreated.getPainLevel(); // Use getter method to get pain level after initalizing instance of Pet
            petHealth = petCreated.getHealth();// Use getter method to get health after initalizing instance of Pet
            petCreated.speak(); // Call speak method for current pet
            // call addTime method to calculate the exit time, utilizing treat time method call
            exitTime = addTime(appointmentTime, petCreated.treat());

            // define string to add to String of patient info and concat the string
            updatedPatientInfo = updatedPatientInfo.concat(String.format("%s,%s,%s,Day %d,%s,%s,%s,%s\n",
                    petName, petType, droolOrMiceCaught, day, appointmentTime, exitTime, petHealth, painLevel));
        }
        fileScan.close(); // Close Scanner object and subsequently the file
        userInput.close(); // Close Scanner object for user input
        return updatedPatientInfo; // return string with updated patients information from scanned file
    }

    // Method
    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException{
        // chains the nextDay method, creating a new file with String input and returning resulting string if successful
        return (nextDay(new File(fileName)));
    }

    // method to write the strings on updated patient information to file
    public boolean addToFile(String patientInfo){
        PrintWriter filePrint = null; // initialize a PrintWriter object
        Scanner fileScan = null; // Create a Scanner object to scan patient File to collect existing patients
        String outputString = ""; // Iniatilize String that will store output line to print

        // ASSESS
        File fileOut = new File(patientFile.getPath());

        try {
            fileScan = new Scanner(patientFile); // define patientString with patientInfo String

            boolean newPatient = true; // Initialize boolean to True that will capture whether new Patient or not
            int firstDelimiter = patientInfo.indexOf(",");
            String patientNameToCheck = patientInfo.subString(0, firstDelimiter); // Get the patient name from patientInfo line

            // ASSESS
            filePrint = new PrintWriter(fileOut);

            while (patientString.hasNextLine()) { // While string line exists
                String line = fileScan.nextLine(); // Store next line of patientInfo input parameter into new String

                // Check if name within the Patients file matches the name of patient to print
                if (line.StartsWith(patientNameToCheck)){
                    newPatient = false; // if names match then


                }


                // Loop through array of existing Patients
                for (int i = 0; i < patients.length; i++){
                    String existingPatient = ""; // initialize existing patient String to blank
                    // ensure string with existing patient info isn't null
                    if (patients[i] != null){
                        String[] stringToParse = patients[i].split(","); // Store next existing patient string
                        existingPatient = stringToParse[0]; // Store patients name from input String
                    }

                    // Test
                    System.out.println("Name to Check: "+patientNameToCheck);
                    System.out.println("Existing Patient: "+existingPatient);

                    if (patientNameToCheck.equals(existingPatient)){
                        // parse out only patient info to be added to line


                        String existingPatientNewString = patients[i] + "," + tokens[3]+ "," + tokens[4] + "," +
                                tokens[5] + "," + tokens[6] + "," + tokens[7];
                        filePrint.println(existingPatientNewString); // Append the line to the file
                        printSuccess = true;
                    }
                }
                // If the patient name is not found
                if (printSuccess == false){
                    // append the line to the file.
                    filePrint.println(line);
                    printSuccess = true;
                }

            }
        }catch(Exception e){
            return false;
        }
        finally{
            if (filePrint != null) { // If filePrint isn't null i.e. File exists
                filePrint.close(); // Close Scanner object and subsequently the file
            }
            return printSuccess;
        }


    }

    // method to calculate additional time
    private String addTime(String timeIn, int treatmentTime){
        int timeInInt = Integer.parseInt(timeIn); // cast String of timeIn to Integer
        int hoursTimeIn = timeInInt / 100; // Extract hours
        int minsTimeIn = timeInInt % 100; // Extract minutes

        int hoursTreatmentTime = treatmentTime / 60; // Extract hours
        int minsTreatmentTime  = treatmentTime % 60; // Extract minutes

        // Perform addition
        hoursTimeIn += hoursTreatmentTime; // add hours values
        minsTimeIn += minsTreatmentTime; // add minutes values

        // cast back final int back to string
        return String.format("%02d%02d", hoursTimeIn, minsTimeIn);
    }
}