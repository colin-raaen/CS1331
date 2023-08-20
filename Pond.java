public class Pond{
    public static void main (String[] args) {
        // Create Frogs
        Frog frog1 = new Frog("Peepo");
        Frog frog2 = new Frog("Pepe", 10, 15);
        Frog frog3 = new Frog("Peepaw", 4.6, 5);
        Frog frog4 = new Frog("Colin");

        // Create flies
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly();

        Frog.setSpecies("1331 Frogs"); // Change species of all frogs
        System.out.println(frog1); // Print details of Peepo

        frog1.eat(fly2); // Peeop attempts to eat fly of mass 6
        System.out.println(fly2); // Print details of fly

        frog1.grow(8); // Peeop ages 8 months
        frog1.eat(fly2); // Peeop attempts to eat fly of mass 6
        System.out.println(fly2); // Print details of fly
        System.out.println(frog1); // Print details of Peepo
        System.out.println(frog4); // Print details of Peepo
        frog3.grow(4); // Peepaw ages 4 months
        System.out.println(frog3); // Print details of Peepo
        System.out.println(frog2); // Print details of Peepo
    }
}