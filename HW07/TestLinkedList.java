public class TestLinkedList {
    public static void main(String args[]){
        String firstAdd = "My List";
        String secondAdd = "My second line";
        String thirdAdd = "My third test";
        String fourthAdd = "My fourth add";

        List<String> myList = new LinkedList<>();
        System.out.println(myList.isEmpty());
        myList.addAtIndex(firstAdd, 0);
        System.out.println(myList.isEmpty());
        System.out.println(myList.toString()); // Print list to terminal
        System.out.println(myList.size());
        System.out.println(myList.getAtIndex(0));
        System.out.println();

        myList.removeAtIndex(0);
        System.out.println(myList.size());
        System.out.println(myList.isEmpty());
        System.out.println();

        myList.addAtIndex(firstAdd, 0);
        myList.addAtIndex(secondAdd, 1);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.size());
        System.out.println();

        myList.addAtIndex(thirdAdd, 1);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.size());
        System.out.println();

        myList.addAtIndex(fourthAdd, 0);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.getAtIndex(3));
        System.out.println(myList.size());
        System.out.println();

        myList.removeAtIndex(1);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.getAtIndex(2));
        System.out.println(myList.size());
        System.out.println();

        myList.remove(secondAdd);
        System.out.println(myList.getAtIndex(0));
        System.out.println(myList.getAtIndex(1));
        System.out.println(myList.size());
        System.out.println();

        myList.clear();
        System.out.println(myList.isEmpty());

    }
}