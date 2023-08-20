public class Frog {
    //INSTANCE VARIABLES
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";
    //default values
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUE_SPEED = 5;

    //CONSTRUCTORS
    public Frog(String initName, int initAge, double initTongueSpeed){
        this.name = initName;
        this.age = initAge;
        this.tongueSpeed = initTongueSpeed;
        this.isFroglet = true;
    }

    public Frog(String initName, double ageInYears, double initTongueSpeed){
        this(initName, (int)ageInYears, initTongueSpeed);
    }

    public Frog(String initName){
        this(initName, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }
    
    //METHODS
    // Method to override default toString
    public String toString() {
        if (isFroglet == true){
            return String.format("My name is %s and I’m a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        else {
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        
    }

    // Grow method
    public void grow(int monthsAged) {
        // increase age and tongue speed for each additional month to add
        for (int x = 0; x < monthsAged; x++){
            // if frog is less than 12 months old, increase age and tongue speed
            if (age < 12){
                age++;
                tongueSpeed++;
            }
            // if frog is equal or greater than 30 months old, increase age and decrease tongue speed, Ensure tongue speed doesn't go below 5
            else if (age > 29 && tongueSpeed > 5){
                age++;
                tongueSpeed--;
            }
            // if frog is equal or greater than 12 months old, less than 30 months, or tongue speed 5 or less, only increase age
            else {
                age++;
            } 
        }
        // evaluate if frog is a froglet
        if (age >= 7){
            isFroglet = false;
        }
        else {
            isFroglet = true;
        }
    }

    public void grow(){
        grow(1); // call grow method with input of 1
        return;
    }

    // Method to eat
    public void eat(Fly meal){
        // Check if fly is dead
        if (meal.isDead() == true){
            return;
        }

        // if tongue speed is greater than speed of the fly, than fly is caught
        if (tongueSpeed > meal.getSpeed()){
            if ((meal.getMass() * .5) >= age ){
                grow();
                meal.setMass(0);
            }
            else {
                meal.setMass(0);
            }
        }
        // Fly is not caught
        else {
            meal.setMass(meal.getMass() + 1);
        }
    }

    // Method to get Species
    public static String getSpecies() {
        return species;
    }

    // Method to set Species
    public static void setSpecies(String newSpecies) {
            species = newSpecies;
    }
}