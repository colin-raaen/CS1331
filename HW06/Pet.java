public abstract class Pet {
    // Instance variables for Pets Class
    private String name; // The name of the Pet as a String.
    private double health; // double representing the Pets health
    private int painLevel; // int representing Pet's pain level

    // Constructor method with more specific inputs
    public Pet(String name, double health, int painLevel) {
        this.name = name; // set pets name from input parameter
        // if health level is greath than 1.0, then set to 1.0
        if (this.health > 1.0) {
            this.health = 1.0;
        }
        // else if health level is less than 0.0, then set to 0.0
        else if (this.health < 0.0) {
            this.health = 0.0;
        }
        // else set value of health level
        else {
            this.health = health;
        }
        // if pain level is greater than 10, then set to 10
        if (this.painLevel > 10) {
            this.painLevel = 10;
        }
        // else if pain level is less than 1, set to 1
        else if (this.painLevel < 1) {
            this.painLevel = 1;
        }
        // set pain level value to parameter
        else {
            this.painLevel = painLevel;
        }
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for health
    public double getHealth() {
        return health;
    }

    // Getter method for pain level
    public int getPainLevel() {
        return painLevel;
    }

    // Abstract method that returns the time taken (in minutes) to treat the pet
    public abstract int treat();

    // speak method that prints out name of pet
    public void speak(){
        // If painLevel is greater than 5 prints the message in UPPERCASE
        if (this.painLevel > 5){
            System.out.println("HELLO! MY NAME IS " + this.name.toUpperCase());
        }

        else{ // else print lower case
            System.out.println("Hello! My name is " + this.name);
        }
    }

    // Equals method to check if two pets have the same name
    public boolean equals(Object o){
        if (o instanceof Pet) {
            Pet pet = (Pet) o;
            return this.name.equals(pet.name);
        }
        return false;
    }

    // heal method to set health value to 1.0 and pain level to 1
    protected void heal(){
        // Sets health to 1.0
        this.health = 1.0;
        // Sets painLevel to 1
        this.painLevel = 1;
    }
}