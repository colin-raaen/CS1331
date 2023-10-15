public class TestLinkedList {
    public static void main(String args[]){
        String firstAdd = "My First Line Item";
        String secondAdd = "My second line";
        String thirdAdd = "My third test";
        String fourthAdd = "My fourth add";
        String fifthAdd = "My Fifth add";
        String sixthAdd = "My sixth add";
        String seventhAdd = "My seventh add";


        List<String> myList = new LinkedList<>();

        System.out.println(myList.isEmpty());
        System.out.println();

        myList.addAtIndex(firstAdd, 0);
        System.out.println(myList.isEmpty());
        System.out.println(myList.size());
        System.out.println(myList.getAtIndex(0));
        System.out.println();

        System.out.println(myList.removeAtIndex(0));
        System.out.println(myList.size());
        System.out.println(myList.isEmpty());
        System.out.println();

        myList.addAtIndex(firstAdd, 0);
        myList.addAtIndex(secondAdd, 1);
        myList.addAtIndex(thirdAdd, 2);
        myList.addAtIndex(fourthAdd, 3);
        myList.addAtIndex(fifthAdd, 3);
        myList.addAtIndex(sixthAdd, 2);
        myList.addAtIndex(seventhAdd, 0);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println(myList.size());
        System.out.println();


        System.out.println("Item to remove : " + myList.removeAtIndex(1));
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Item to remove : " + myList.removeAtIndex(5));
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Item to remove : " + myList.removeAtIndex(0));
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.size());
        System.out.println();

        System.out.println("Item to remove: " + myList.remove(seventhAdd));
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.size());
        System.out.println();

        myList.clear();
        System.out.println(myList.isEmpty());
        System.out.println(myList.size());
        System.out.println();

        myList.addAtIndex(firstAdd, 0);
        myList.addAtIndex(secondAdd, 1);
        myList.addAtIndex(thirdAdd, 2);
        myList.addAtIndex(fourthAdd, 3);
        myList.addAtIndex(fifthAdd, 3);
        myList.addAtIndex(sixthAdd, 2);
        myList.addAtIndex(seventhAdd, 0);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println(myList.size());
        System.out.println();

        myList.clear();
        System.out.println(myList.isEmpty());
        System.out.println(myList.size());
        System.out.println();
    }
}