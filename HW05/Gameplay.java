public class Gameplay {
    public static void main(String[] args) {
        // Create RedAstronaut objects with different parameters
        RedAstronaut redAstronaut1 = new RedAstronaut("Player1");
        RedAstronaut redAstronaut2 = new RedAstronaut("Player2", 50, "expert");
        RedAstronaut redAstronaut3 = new RedAstronaut("Player3", 30, "expert");
        RedAstronaut redAstronaut4 = new RedAstronaut("Player4", 30, "expert");
        RedAstronaut redAstronaut5 = new RedAstronaut("Player5", 25, "expert");

        // Call the emergencyMeeting method for each RedAstronaut
        redAstronaut1.freeze(redAstronaut5);
        redAstronaut2.emergencyMeeting();
        redAstronaut1.emergencyMeeting();
    }
}