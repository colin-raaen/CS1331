public class Bin2Diff<X,Y>{
    private X content1; // Declare instance variable
    private Y content2; // Declare second instance variable

    public Bin2Diff (X content1, Y content2){ // Constructor method for Bin
        this.content1 = content1;
        this.content2 = content2;
    }

    public X getContent1(){ // Getter method to get content variable
        return content1;
    }
    public void setContent1(X content1){ // Setter method to set content variable
        this.content1 = content1;
    }
    public Y getContent2(){ // Getter method to get content variable
        return content2;
    }
    public void setContent2(Y content2){ // Setter method to set content variable
        this.content2 = content2;
    }

    public static void main (String[] args){
        // A two-type compartment bin
        Bin2Diff<String,Car> test = new Bin2Diff<>("My Dream Car.", new Car("Yuhina", "Spark", 2037)); // Create new Bin object

    }
}