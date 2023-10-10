public class Car{
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake(){ // Getter method to get make variable
        return make;
    }
    public String getModel(){ // Getter method to get model variable
        return model;
    }
    public int getYear(){ // Getter method to get year variable
        return year;
    }

    public void setMake(String make){ // Setter method to set content variable
        this.make = make;
    }

}