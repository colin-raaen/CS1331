public class RedAstronaut extends Player implements Impostor {
    //VARIABLES
    private String skill;
    // Default values
    public static final int DEFAULT_susLevel = 15;
    public static final String DEFAULT_SKILL = "experienced";

    // Constructor method for RedAstronaut
    public RedAstronaut (String name, int susLevel, String skill) {
        super(name, susLevel); // invoke the constructor of the superclass, Player, with "super" keyword
        // TO DO
        this(skill);
    }

    // Constructor chaining to another constructor in the same class
    public RedAstronaut (String name) {
        super(name); // Call the constructor of the Player class with "super" keyword
        // Set default values for susLevel and skill
        this(DEFAULT_susLevel, DEFAULT_SKILL);
    }
    @Override
    public void emergencyMeeting(){

    }

    // Implement the freeze method from the Impostor interface
    @Override
    public void freeze(){

    }

    // Implement the abstract method from the Impostor interface
    @Override
    public void sabotage(){

    }
}
