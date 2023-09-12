import java.util.Arrays;

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

        // Sort the array in descending order based on susLevel using compareTo Method defined from Players.java
        Arrays.sort(players);

        // variables to store which players to compare and freeze
        int mostSus = players.length - 1; // last array value (highest susLevel)
        int secondMostSus = players.length - 2; // second to last array value (second highest susLevel)
        int susLevelComparisonResult = 0;

        // while loop to check if highest susLevel is the current Player or if highest suslevel is Frozen
        // either either evaluates to true, move to the next highest in the array of Players until not this or frozen
        while (players[mostSus].isFrozen() || players[secondMostSus].isFrozen()){
            if (players[mostSus].isFrozen()){
                mostSus--;
                secondMostSus--;
            }
            if (players[secondMostSus].isFrozen()){
                secondMostSus--;; // increment SecondMostSus
            }
        }

        // Call Compare method for first and second Players in the sorted array
        susLevelComparisonResult = players[secondMostSus].compareTo(players[mostSus]);

        // if players[1] sus level is higher than players[2], players[1] is sole highest susLevel, freeze player
        if (susLevelComparisonResult == -1){
            // call setter method for player to freeze
            players[mostSus].setFrozen(true);
        }
        // Exception handling else if check to make sure players[2] isn't higher
        else if (susLevelComparisonResult == 1){
            System.out.println("players[1] susLevel is higher than players[0]");
        }
        // Exception handling else if check if top two SusLevels are equal, if so, no player will be frozen
        else if (susLevelComparisonResult == 0){
            System.out.println("players[1] susLevel is equal to players[0], do not freeze player");
            return;
        }

        for(int i=0; i<players.length; i++){
            System.out.println(players[i]);
        }

        // Call method to check if game is over
        gameOver();

        return;
    }

    // Implement the completeTask abstract method from the Crewmate class
    @Override
    public void completeTask(){
        // a Crewmate cannot be frozen, if yes then exit
        if (this.isFrozen()) { return; }
        // If Player has already completed all their tasks, print message and exit
        else if(this.numTasks <= 0) {
            // Exit
            return;
        }

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

        // If susLevel is equal or less than 15, print in lower case
        if (this.getSusLevel() <= 15){
            return super.toString() + ". I have " + this.numTasks + " left over.";
        }
        // else, susLevel is greater than 15, print in all caps
        else{
            return "MY NAME IS " + this.getName().toUpperCase() + ", AND I HAVE A SUSLEVEL OF "
                    + this.getSusLevel() + ". I AM CURRENTLY " + frozenString.toUpperCase()
                    + ". I HAVE " + this.numTasks + " LEFT OVER.";
        }
    }
}