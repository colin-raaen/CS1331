public class Fly{
    //VARIABLES
    private double mass;
    private double speed;
    // Default values
    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    //CONSTRUCTORS
    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass){
        this(mass, DEFAULT_SPEED);
    }

    public Fly(){
        this(DEFAULT_MASS);
    }

    //METHODS
    // Method to override default toString
    public String toString() {
        if (mass == 0){
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        }
        else{
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    // Method to get Mass
    public double getMass() {
        return mass;
    }

    // Method to set Mass
    public void setMass(double newMass) {
            mass = newMass;
    }

    // Method to get Speed
    public double getSpeed() {
        return speed;
    }

    // Method to set Speed
    public void setSpeed(double newSpeed) {
            speed = newSpeed;
    }

    // Method for grow
    public void grow(int addedMass) {
        // do while loop to increase speed and mass according to formula
        for (int x = 0; x < addedMass; x++){
            if(mass < 20){
                mass++;
                speed++;
            }
            else if (mass >= 20){
                mass++;
                speed -= 0.5;
            }
        }
    }

    //Method for isDead
    public boolean isDead() {
        if (mass == 0){
            return true;
        }
        else {
            return false;
        }
    }    
}