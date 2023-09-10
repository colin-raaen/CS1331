public class BlueAstronaut extends Player implements Crewmate {
    // Instance variable for Crewmate
    private int numTasks;
    private int taskSpeed;
    // Default values for instance variables
    public static final int DEFAULT_susLevel = 15;
    public static final int DEFAULT_numTasks = 6;
    public static final int DEFAULT_taskSpeed = 10;

    // Constructor method for RedAstronaut, less specific constructor that only takes name as input
    public BlueAstronaut (String name) {
        // call more specific constructor, use default susLevel and default skill if just a name is used as input
        this(name, DEFAULT_susLevel, DEFAULT_numTasks, DEFAULT_taskSpeed);
    }

    // Constructor chaining to add another constructor in the same class, more specific constructor
    // Parameters inputs for name, susLevel and Skill level
    public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel); // Call the constructor of the Player class with "super" keyword
        this.numTasks = numTasks; // set number of tasks with default value
        this.taskSpeed = taskSpeed; // set taskSpeed with default value
    }

    // Implement the emergencyMeeting abstract method from the Player class
    @Override
    public void emergencyMeeting(){
        // if player calling emergency meeting is frozen then exit
        if (this.isFrozen() == true){
            return;
        }
        // Get players array using getter method and store in a new array called 'players'
        Player[] players = getPlayers();

        return;
    }

    // Implement the completeTask abstract method from the Crewmate class
    @Override
    public void completeTask(){
        // a Crewmate cannot be frozen, if yes then exit
        if (this.isFrozen() == true) { return; }

        // If taskSpeed is greater than 20, subtract 2 from numTasks.
        if (this.taskSpeed > 20){
            this.numTasks = this.numTasks - 2;
        }
        else { // Otherwise, subtract 1 from numTasks.
            this.numTasks = this.numTasks - 1;
        }

        // If numTasks falls below 0, set it to 0
        if (this.numTasks <= 0){
            // if negative value then set to 0
            this.numTasks = 0;
            // print out that palyer has completed all tasks
            System.out.println("I have completed all my tasks");

            // Reduce SusLevel by 50%
            int currentSusLevel = this.getSusLevel();
            double newSusLevel = currentSusLevel / 2;
            // cast newly calculated double to int
            int newSusLevelInt = (int) newSusLevel;
            this.setSusLevel(newSusLevelInt);
        }
        System.out.println(this);
        return; // exit method
    }

    // Implement method to check if Blues are equal
    @Override
    public boolean equals(Object o){
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueCheck = (BlueAstronaut) o;
            return this.getName().equals(blueCheck.getName()) && this.isFrozen() == blueCheck.isFrozen()
                    && this.getSusLevel() == blueCheck.getSusLevel() && this.numTasks == blueCheck.numTasks
                    && this.taskSpeed == blueCheck.taskSpeed;
        }
        return false; // else return false
    }

    // Implement toString Override for BlueAstronaut
    @Override
    public String toString(){
        // Use getter method to see if current player is frozen
        boolean frozenBoolean = this.isFrozen();
        // Use a ternary operation to determine the frozenString
        String frozenString = frozenBoolean ? "frozen" : "not frozen";

        return "My name is " + this.getName() + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + ". I have " + this.numTasks + " left over.";
    }
}