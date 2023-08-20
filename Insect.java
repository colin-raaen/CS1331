public class Insect {
    //instance variables
    private double weight;
    private int x;
    private int y;
    
    //static constant/variables
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final double DIST_WEIGHT_LOSS_FACTOR = .0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than 1 million insect species",
        "Insects are cold-blooded",
        "Spiders are not considered insects"
    };

    //CONSTRUCTORS
    public Insect(double initWeight){
        this(initWeight, DEFAULT_X, DEFAULT_Y);
    }

    public Insect(double weight, int x, int y){
        this.weight = weight;
        this.x = x;
        this.y = y;
        population++;
    }

    // METHODS
    public double getWeight() {
        return weight;
    }

    public static int getPopulation() {
        return population;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        if (isLegalX(newX)){
            x = newX;
        }
    }

    public void setY(int newY) {
        if (isLegalY(newY)){
            y = newY;
        }
    }

    public static boolean isLegalX(int newX){
        return (newX >= 0 ? true : false);
    }

    public static boolean isLegalY(int newY){
        return (newY >= 0 ? true : false);
    }

    // Method to override default toString 
    public String toString() {
        return "weight: " + weight + ", x: " + x + ", y: " + y;
    }

    public void eat(double amount){
        System.out.println("Nibble nibble");
        weight = weight + amount;
    }

    public void move(int newX, int newY){
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0){
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else{
            System.out.println("Staying put");
        }
    }

    //Helper method to calculate distance moved of an insect
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    //Method to produce random fact
    public static String produceRandomFact(){
        int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }
}
