public class Gameplay {
    public static void main(String[] args) {
        // Create RedAstronaut objects with different parameters
        RedAstronaut redAstronaut1 = new RedAstronaut("Player1");
        RedAstronaut redAstronaut2 = new RedAstronaut("Player2", 50, "expert");
        RedAstronaut redAstronaut3 = new RedAstronaut("Player3", 30, "expert");
        RedAstronaut redAstronaut4 = new RedAstronaut("Player4", 30, "expert");
        RedAstronaut redAstronaut5 = new RedAstronaut("Player5", 25, "expert");
        BlueAstronaut blueAstronaut1 = new BlueAstronaut("Player6", 25, 6, 25);

        // Call the emergencyMeeting method for each RedAstronaut
        blueAstronaut1.completeTask();
        blueAstronaut1.completeTask();
        blueAstronaut1.completeTask();
        blueAstronaut1.completeTask();
        blueAstronaut1.completeTask();
        redAstronaut1.sabotage(blueAstronaut1);
        redAstronaut1.freeze(blueAstronaut1);


        redAstronaut2.emergencyMeeting();
        redAstronaut1.emergencyMeeting();
        boolean equalsCheck1 = redAstronaut1.equals(redAstronaut5);
        System.out.println(equalsCheck1);


    }
}