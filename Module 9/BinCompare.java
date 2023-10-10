public class BinCompare<T extends Comparable<T>>{
    private T content1; // Declare instance variable
    private T content2; // Declare second instance variable

    public BinCompare (T content1, T content2){ // Constructor method for Bin
        this.content1 = content1;
        this.content2 = content2;
    }

    public T greaterValue(){
        // ternary condiational operation, if content1 is greater than content2, return content 1, else return content 2
        return(content1.compareTo(content2)) >= 0 ? content1 : content2;
    }

    public static void main (String[] args){
        BinCompare<String> test = new BinCompare<>("I'm a basic String.", "Short and stout"); // Create new Bin object
        System.out.println(test.greaterValue());

    }
}