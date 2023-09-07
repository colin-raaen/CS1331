public class RedAstronaut extends Player implements Impostor {
    // Instance variable for Skill
    private String skill;
    // Default values for instance variables
    public static final int DEFAULT_susLevel = 15;
    public static final String DEFAULT_SKILL = "experienced";

    // Constructor method for RedAstronaut, less specific constructor that only takes name as input
    public RedAstronaut (String name) {
        // call more specific constructor, use default susLevel and default skill if just a name is used as input
        this(name, DEFAULT_susLevel, DEFAULT_SKILL);
    }

    // Constructor chaining to add another constructor in the same class, more specific constructue
    public RedAstronaut (String name, int susLevel, String skill) {
        super(name, susLevel); // Call the constructor of the Player class with "super" keyword
        this.skill = skill; // set skill with default value
        // Set default values for susLevel and skill

    }
    @Override
    public void emergencyMeeting(){
        return;
    }

    // Implement the freeze method from the Impostor interface
    @Override
    public void freeze(Player p){
        return;
    }

    // Implement the abstract method from the Impostor interface
    @Override
    public void sabotage(Player p){
        return;
    }
}
