public class Repeater{
    public static void main(String args[]){
        System.out.println(factorial(4));
    }

    public static int factorial(int n){
        if (n ==0){ // base case
            return 1;
        }
        else{ // else make a recursive call of n-1
            return n * factorial(n-1);
        }

    }

    public static void repeatString(String toRepeat, int numberToPrint){
        if (numberToPrint <= 0){
            return;
        }
        System.out.println(toRepeat); //print string
        repeatString(toRepeat, numberToPrint - 1);
    }
}