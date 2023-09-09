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
        // Get players array using getter method and store in a new array called 'players'
        Player[] players = getPlayers();

        /** Utilize Arrays.sort method to iterate through players and sort by susLevel.
            custom Comparator<Player> object is created using an anonymous inner class.
            This custom comparator specifies how two Player objects should be compared for sorting purposes
            new Comparator<Player>() is used as an argument to the Arrays.sort method.
            This tells Arrays.sort how to compare and sort the elements in the players array.
         */
        Arrays.sort(players, new Comparator<Player>() {
            @Override
            // compare method where compare logic is defined explicityly comparing player 1 to player 2
            public int compare(Player player1, Player player2) {
                // use getter method to get SusLevel of each player and compare
                return Integer.compare(player2.getSusLevel(), player1.getSusLevel());
            }
        });

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
        // if player passed in is an impostor or if frozen, if yes to either than exit
        if (p.skill == null || p.isFrozen == true){
            return;
        }

        // Check if susLevel of RedAstronaut is lower than SusLevel of player P

        // else if freeze fails, double the RedAstronauts susLevel

        // Call method to check if game is over
        gameOver();

        return; // exit
    }

    // Implement the abstract method from the Impostor interface
    @Override
    public void sabotage(Player p){
        return;
    }

    // Implement method to check if Reds are equal
    @Override
    public boolean equals(Object o){
        return;
    }

    // Implement toString Override for RedAstronaut
    @Override
    public String toString(){
        return;
    }
}
