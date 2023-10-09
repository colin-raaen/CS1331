import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile; // private variable File with patient information
    private int day; // define variable int that is day

    // Constructor for Clinic, with a patient record from a file
    public Clinic(File file){
        this.patientFile = file; // Assign file that contains patient info to patientFile
        this.day = 1; // Day initialized to 1
    }

    // Constructor that chains to constructor above, creating a new Clinc with a pitent record from a file name
    // fileName is the name of patient file as a String
    public Clinic(String fileName){
        // chain to first constructor while creating a new file using name of string stored to pass into the constructor
        this(new File(fileName));
    }

    /**
     * method which establishes appointemnts for the next day of patients.
     * Formates delimited data for each patient as:
     * name,species,stat,day,timeIn,timeOut,initialHealth,initialPainLevel
     *
     * @param f a file containing appointments for the next day
     * @return a String of delimited and information for each appointment
     */
    public String nextDay(File f) throws FileNotFoundException, InvalidPetException{
        day++; // increment day after scanning file and updating patients information

        // Define inputScanner Scanner with file input, that parses the file at every line break
        Scanner fileScan = new Scanner(f);
        Scanner userInput = new Scanner(System.in); // define userInput Scanner object to collect user input
        String updatedPatientInfo = ""; // String to store updated patient information that will be returned

        // While there is another line that exists in the file being scanned
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine(); // Declare String to store next line string value in array of appointemnt names
            String[] petLine = line.split(","); // Parse the line breaking at the commas
            String petName = petLine[0]; // Declare String and store first sub string value from array of Strings on Patient
            String petType = petLine[1]; // Declare String and store next sub string value from array of Strings on Patient
            String droolOrMiceCaught = petLine[2]; // Declare String and store drool rate/mice caught from array of Strings
            String appointmentTime = petLine[3]; // Declare String and store time of appointment as a string

            // if pet type isn't valid entry
            if (!petType.equals("Cat") && !petType.equals("Dog")) {
                throw new InvalidPetException(); // throw new exception, calling custom InvalidPetException
            }

            // Additional varibales to capture patient information from user input and check if successful
            double petHealth = 0; // declare int to store user input
            int painLevel = 0; // declare int to store user input for pain level
            boolean healthSuccess = false; // intialize boolean variable for exception controlled loop
            boolean painSuccess = false; // intialize boolean variable for exception controlled loop

            // Excpetion controlled loop to prompt user for an int for pet's health
            while (!healthSuccess){ // continue to reprompt the user until an int
                // Print statement with details to and prompt user for health of pet
                System.out.println("Consultation for " + petName + " the " + petType + " at " + appointmentTime + ".\n"
                        + "What is the health of " + petName + "?");
                if (userInput.hasNextDouble()){
                    petHealth = userInput.nextDouble(); // store user input in vairalbe
                    healthSuccess = true; // Exit the loop if the input is an integer
                }
                else{
                    userInput.nextLine(); // Clear invalid input
                    System.out.println("Please enter a number");
                }
            }

            // Excpetion controlled loop to prompt user for an int for pet's health
            while (!painSuccess){
                // Print statement with details to and prompt user for health of pet
                System.out.println("On a scale of 1 to 10, how much pain is " + petName + " in right now?");
                if (userInput.hasNextInt()){
                    painLevel = userInput.nextInt(); // store user input in variable
                    painSuccess = true; // Exit the loop if the input is an integer
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
            // Declare string to store exit time, call addTime method to calculate the exit time, utilizing treat time method call
            String exitTime = addTime(appointmentTime, petCreated.treat());

            // define string to add to String of patient info and concat the string
            updatedPatientInfo = updatedPatientInfo.concat(String.format("%s,%s,%s,Day %d,%s,%s,%s,%s\n",
                    petName, petType, droolOrMiceCaught, day, appointmentTime, exitTime, petHealth, painLevel));
        }
        fileScan.close(); // Close Scanner object and subsequently the file
        userInput.close(); // Close Scanner object for user input
        return updatedPatientInfo; // return string with updated patients information from scanned file
    }

    /**
     * method which establishes appointemnts for the next day of patients.
     * Formates delimited data for each patient as:
     * name,species,stat,day,timeIn,timeOut,initialHealth,initialPainLevel
     *
     * @param fileName as a string, of a file containing appointments for the next day
     * @return a String of delimited and information for each appointment
     */
    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException{
        // chains the nextDay method, creating a new file with String input and returning resulting string if successful
        return (nextDay(new File(fileName)));
    }

    /**
     * Writes information from a String of information on appointment to patientFile
     * If the paitent already exists, appends only appt information to end of patient
     *
     * @param patientInfo a string representing a single appointment of one patient
     * @return a boolean for whether the appointment info was successfully written to the file
     */
    public boolean addToFile(String patientInfo){
        // Variables to handle files declared as null outside the try block
        PrintWriter filePrint = null; // initialize a PrintWriter object
        Scanner fileScan = null; // Create a Scanner object to scan patient File to collect existing patients
        String outputString = ""; // Iniatilize String that will store output line to print

        try {
            // Set values of variables that handle files inside the try block
            // Only setting filescan first, since can't read and write at the same time
            fileScan = new Scanner(patientFile); // set fileScan to scan file of existing patients

            boolean newPatient = true; // Initialize boolean to True that will capture whether new Patient or not
            // Get the current patients name from patientInfo String
            int firstDelimiter = patientInfo.indexOf(","); // returns the position in the string of first instance of comma
            // parses patient names using substring method and where delimeter was captured
            String appointmentPatient = patientInfo.substring(0, firstDelimiter);

            while (fileScan.hasNextLine()) { // While file of existing patients has another line
                String line = fileScan.nextLine(); // Store next line of existing patients into new String

                // Check if name within the Patients file starts with the name of patient to print
                if (line.startsWith(appointmentPatient)) {
                    newPatient = false; // if names match, then update boolean value that this is existing patient
                    String[] tokens = patientInfo.split(","); // Parse line breaking into subStrings at the commas
                    // Update line String with additional appointment information using sub Strings
                    line += "," + tokens[3] + "," + tokens[4] + "," + tokens[5] + "," + tokens[6] + "," + tokens[7];
                }
                // add the existing patient line String to the output String to be printed
                // line will contain additional appointemnt info if patient was in patientInfo parameter input
                // otherwise line will be added to output string with no additions
                outputString += (line + "\n");
            }
            // If the patient name was not an existing patients, patient is new, print a new line to the file at the bottom
            if (newPatient == true){
                // Assign entire patientInfo String to the end of the output String
                // will appear at the end since line addes \n at the end
                outputString += patientInfo;
            }
            // Need to close fileScan object since can't read and write at the same time
            fileScan.close();
            // assign filePrint new PrintWriter with patientFile as output file,
            filePrint = new PrintWriter(patientFile);
            // Print the outputString information to output file,
            // this will contain all existing patients, any additions, as well as patientInfo as new patient if new
            filePrint.print(outputString);
            return true; // return true, successfully printed file
        }catch(Exception e){
            return false; // If exception error occures, return false, didn't successfully write to file
        }
        finally{
            // Executes even if code returns
            if (fileScan != null) { // If fileScan isn't null i.e. File exists
                filePrint.close(); // Close Scanner object and subsequently the file
            }
            if (filePrint != null) { // If filePrint isn't null i.e. File exists
                filePrint.close(); // Close Scanner object and subsequently the file
            }
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