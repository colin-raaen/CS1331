public class Gameplay {
    public static void main(String[] args) {
        // Create RedAstronaut objects with different parameters
        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        // Call methods
        Liam.sabotage(Bob);
        System.out.println();
        Liam.freeze(susPerson);
        System.out.println();
        Liam.freeze(Albert);
        System.out.println();
        Albert.emergencyMeeting();
        System.out.println();
        susPerson.emergencyMeeting();
        System.out.println();
        Bob.emergencyMeeting();
        System.out.println();
        Heath.completeTask();
        System.out.println();
        Heath.completeTask();
        System.out.println();
        Heath.completeTask();
        System.out.println();
        Liam.freeze(Angel);
        System.out.println();
        Liam.sabotage(Bob);
        System.out.println();
        Liam.sabotage(Bob);
        System.out.println();
        Liam.freeze(Bob);
        System.out.println();
        Liam.sabotage(Heath);
        System.out.println();
        Liam.sabotage(Heath);
        System.out.println();
        Liam.sabotage(Heath);
        System.out.println();
        Liam.sabotage(Heath);
        System.out.println();
        Liam.sabotage(Heath);
        System.out.println();
        Liam.freeze(Heath);


    }
}