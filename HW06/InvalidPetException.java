public class InvalidPetException extends Exception{
    public InvalidPetException(){
        super("Your pet is invalid!"); // Pass error message to the Exception class
    }

    public InvalidPetException(String s){
        super(s); // Pass the custom error message to the Exception class
    }
}