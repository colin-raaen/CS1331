public class Cat extends Pet {
    private int miceCaught; // Instance variable for miceCaught
    private static final int DEFAULT_miceCaught = 0; // Default miceCaught value


    // less specific Cat constructor
    public Cat(String name, double health, int painLevel){
        this(name, health, painLevel, DEFAULT_miceCaught); // call more specific constructor with default miceCaught
    }

    // More specific Cat constructor
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel); // call parent constructor for name, health, and painlevel
        this.miceCaught = miceCaught; // set miceCaught variable
    }

    // Getter method for mice caught
    public int getMiceCaught(){
        return miceCaught;
    }

    // treat method definition
    public int treat(){
        return 0;
    }

    // Speak method definition
    public void speak(){
        return;
    }

    // equals method to compare if object instances are the same
    public boolean equals(Object o){
        return false;
    }
}