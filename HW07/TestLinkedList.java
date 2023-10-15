public class TestLinkedList {
    public static void main(String args[]){
        // Strings to Add
        String firstAdd = "My First Line Item";
        String secondAdd = "My second line";
        String thirdAdd = "My third test";
        String fourthAdd = "My fourth add";
        String fifthAdd = "My Fifth add";
        String sixthAdd = "My sixth add";
        String seventhAdd = "My seventh add";
        String eighthAdd = "My eigth add";
        String ninthAdd = "My ninth add";
        String tenthAdd = "My tenth add";

        // Create instance of LinkedList
        List<String> myList = new LinkedList<>();

        // Test isEmpty method
        System.out.println("Is the list empty: " + myList.isEmpty());
        System.out.println();

        // Test removing at index with an empty list


        // Test removing with contains with an empty list


        // Test adding Node and checking if list isEmpty and size methods
        myList.addAtIndex(firstAdd, 0);
        System.out.println("Is list empty: " + myList.isEmpty());
        System.out.println("Current size of the list: " + myList.size());
        System.out.println(myList.getAtIndex(0));
        System.out.println();

        // Test removing at index with one Node
        System.out.println("Item to remove at Index 0 at head with one Node: " + myList.removeAtIndex(0));
        System.out.println("Current size of list after removal: " + myList.size());
        System.out.println("Is list empty: " + myList.isEmpty());
        System.out.println();

        // Readd one Node for testing
        myList.addAtIndex(firstAdd, 0);
        System.out.println("Is list empty: " + myList.isEmpty());
        System.out.println("Current size of list: " + myList.size());
        System.out.println(myList.getAtIndex(0));
        System.out.println();

        // Test removing with contains with one Node
        System.out.println("Item to remove '" + firstAdd + "' using contains method: " + myList.remove(firstAdd));
        System.out.println("Current size of list after removal: " + myList.size());
        System.out.println("Is the list empty: " + myList.isEmpty());
        System.out.println();

        // Readd all strings for additional testing
        myList.addAtIndex(firstAdd, 0);
        myList.addAtIndex(secondAdd, 1);
        myList.addAtIndex(thirdAdd, 2);
        myList.addAtIndex(fourthAdd, 3);
        myList.addAtIndex(fifthAdd, 3);
        myList.addAtIndex(sixthAdd, 2);
        myList.addAtIndex(seventhAdd, 6);
        myList.addAtIndex(eighthAdd, 7);
        myList.addAtIndex(ninthAdd, 8);
        myList.addAtIndex(tenthAdd, 9);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println(myList.getAtIndex(7));
        System.out.println(myList.getAtIndex(8));
        System.out.println(myList.getAtIndex(9));
        System.out.println("Current size of the list: " + myList.size());
        System.out.println();


        System.out.println("Item to remove at index 1 between head and tail: " + myList.removeAtIndex(1));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println(myList.getAtIndex(7));
        System.out.println(myList.getAtIndex(8));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        // Test removal of index between head and tail
        System.out.println("Item to remove at index 4 between head and tail: " + myList.removeAtIndex(4));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println(myList.getAtIndex(7));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove at index 7 at tail: " + myList.removeAtIndex(7));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println(myList.getAtIndex(6));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove at index 0 at the head with more than one Node: " + myList.removeAtIndex(0));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println(myList.getAtIndex(5));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove '" + seventhAdd + "' using contains at tail: " + myList.remove(seventhAdd));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.getAtIndex(4));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove '" + thirdAdd + "' using contains between head and tail: " + myList.remove(thirdAdd));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove '" + sixthAdd + "' using contains between head and tail: " + myList.remove(sixthAdd));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        System.out.println("Item to remove '" + secondAdd + "' using contains at head: " + myList.remove(secondAdd));
        System.out.println("Remaining items in list:");
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println("Size of the list after removal: " + myList.size());
        System.out.println();

        myList.clear();
        System.out.println("Is the list empty: " + myList.isEmpty());
        System.out.println("Current size of the list: " + myList.size());
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
        System.out.println("Current size of list: " + myList.size());
        System.out.println();

        myList.clear();
        System.out.println("Is the list empty: " + myList.isEmpty());
        System.out.println("Current size of list: " + myList.size());
        System.out.println();
    }
}