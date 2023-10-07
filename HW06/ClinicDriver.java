import java.io.FileNotFoundException;
/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) throws InvalidPetException{
        Clinic clinic = new Clinic("Patients.csv");
        String dayOneReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (InvalidPetException e) { // Handle the InvalidPetException is thrown by nextDay method call
            System.out.println(e.getMessage());
        }
        // create array of substrings from updated patient info
        String[] dayOneAppointments = dayOneReport.split("\\n");
        // Loop through array String of all patients updated information sub strings
        for (String appointment : dayOneAppointments) {
            // if call to addToFile method returns false, than print error, otherwise prints to file
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!"); // print error
            }
        }
    }
}
