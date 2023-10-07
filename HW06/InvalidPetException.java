// Unchecked exception that is thrown when there is an invalid pet if neither Dog or Cat
public class InvalidPetException extends RuntimeException{
    public InvalidPetException(){
        super("Your pet is invalid!"); // Pass error message to the Exception class
    }

    public InvalidPetException(String s){
        super(s); // Pass the custom error message to the Exception class
    }
}