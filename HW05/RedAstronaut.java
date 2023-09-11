import java.util.Arrays;
import java.util.Comparator;

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

    // Constructor chaining to add another constructor in the same class, more specific constructor
    // Parameters inputs for name, susLevel and Skill level
    public RedAstronaut (String name, int susLevel, String skill) {
        super(name, susLevel); // Call the constructor of the Player class with "super" keyword
        this.skill = skill; // set skill with default value
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

        /** Utilize Arrays.sort method to iterate through players and sort by susLevel.

         */

        // Sort the array in descending order based on susLevel using compareTo Method from Players.java
        Arrays.sort(players);


        // variables to store which players to compare and freeze
        int mostSus = 0;
        int secondMostSus = 1;
        int susLevelComparison = 0;

        // if Player that called the emergency meeting has highest susLevel then update comparisons accordingly
        if (this == players[mostSus]){
            // update next highest sus players in the array
            mostSus = 1;
            secondMostSus = 2;
            // Call Compare method for first and second Players in the sorted array
            susLevelComparison = players[mostSus].compareTo(players[secondMostSus]);
        }
        else{
            // Call Compare method for first and second Players in the sorted array
            susLevelComparison = players[mostSus].compareTo(players[secondMostSus]);
        }

        // if players[1] sus level is higher than players[2], players[1] is sole highest susLevel, freeze player
        if (susLevelComparison == 1){
            // call setter method for player to freeze
            players[mostSus].setFrozen(true);
        }
        // Exception handling else if check to make sure players[2] isn't higher
        else if (susLevelComparison == -1){
            System.out.println("players[1] susLevel is higher than players[0]");
        }
        // Exception handling else if check if top two SusLevels are equal, if so, no player will be frozen
        else if (susLevelComparison == 0){
            System.out.println("players[1] susLevel is equal to players[0], do not freeze player");
            return;
        }

        for(int i=0; i<players.length; i++){
            System.out.println(players[i]);
        }

        // Call method to check if game is over
        gameOver();

        return; // break
    }

    // Implement the freeze method from the Impostor interface
    @Override
    public void freeze(Player p){
        // an Impostor cannot freeze another Imposter, OR if the calling player is already frozen then exit
        // OR if player passed in is already frozen then exit
        if (p instanceof Impostor || this.isFrozen() == true || p.isFrozen() == true) { return; }

        // Check if susLevel of RedAstronaut is lower than SusLevel of player P then freeze player
        if (this.getSusLevel() < p.getSusLevel()){
            p.setFrozen(true);
        }
        // else if freeze fails, double the RedAstronauts susLevel
        else if (this.getSusLevel() > p.getSusLevel()){
            this.setSusLevel(this.getSusLevel() * 2);
        }

        //Test
        Player[] players = getPlayers();
        for(int i=0; i<players.length; i++){
            System.out.println(players[i]);
        }

        // Call method to check if game is over
        gameOver();

        return; // exit method
    }

    // Implement the abstract method from the Impostor interface
    @Override
    public void sabotage(Player p){
        // an Impostor cannot sabotage another Imposter, check if player P is an impostor, exit if true
        // OR if the calling player is already frozen then exit OR if player passed in is already frozen then exit
        if (p instanceof Impostor || this.isFrozen() == true || p.isFrozen() == true) { return; }

        // Variable to store current Player P susLevel
        int currentSusLevel = p.getSusLevel();

        // If Imposters susLevel is under 20, increase CrewMates SusLevel by 50%
        if (this.getSusLevel() < 20){
            double newSusLevel = (currentSusLevel + (currentSusLevel * .5));
            // cast newly calculated double to int
            int newSusLevelInt = (int) newSusLevel;
            // Set using new int
            p.setSusLevel(newSusLevelInt);
        }
        // else increase by 25%
        else{
            double newSusLevel = (currentSusLevel + (currentSusLevel * .25));
            // cast newly calculated double to int
            int newSusLevelInt = (int) newSusLevel;
            // Set using new int
            p.setSusLevel(newSusLevelInt);
        }

        //Test
        Player[] players = getPlayers();
        for(int i=0; i<players.length; i++){
            System.out.println(players[i]);
        }

        return; // exit method
    }

    // Implement method to check if Reds are equal
    @Override
    public boolean equals(Object o){
        if (o instanceof RedAstronaut) {
            RedAstronaut redCheck = (RedAstronaut) o;
            return this.getName().equals(redCheck.getName()) && this.isFrozen() == redCheck.isFrozen()
                    && this.getSusLevel() == redCheck.getSusLevel() && this.skill.equals(redCheck.skill);
        }
        return false; // else return false
    }

    // Implement toString Override for RedAstronaut
    @Override
    public String toString(){
        // Use getter method to see if current player is frozen
        boolean frozenBoolean = this.isFrozen();
        // Use a ternary operation to determine the frozenString
        String frozenString = frozenBoolean ? "frozen" : "not frozen";

        return "My name is " + this.getName() + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + ". I am an " + this.skill + " player!";
    }
}
