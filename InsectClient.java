public class InsectClient{
    public static void main (String[] args) {
        Insect bug1 = new Insect(10, 100, 90);
        System.out.println(bug1.getX());


        Insect bug2 = new Insect(9.5, -300, 400);
        System.out.println(bug2); // print details of bug 2 using toString override
        bug1.move(1, 10); 
        bug2.move(-300, 400);

        System.out.println(Insect.produceRandomFact());
        System.out.println(Insect.getPopulation());
    }
}

