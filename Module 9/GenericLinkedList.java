public class GenericLinkedList<E> {

    private class Node<E> { //inner class
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; //the only instance variable of the list, which is an instance of the private inner class Node<E>

    public GenericLinkedList() {

        head = null;  //the list starts off empty
    }

    public boolean isEmpty() {
        return (head == null); //the list is empty if head is null
    }

    public void addToFront(E newData) {
        head = new Node<E>(newData, head);
    }

    public void addToRear(E newData) {
        Node<E> node = new Node <E> (newData, null);
        Node<E> current = head;
        if (isEmpty())  //point head to new node if list is empty
            head = node;
        else {
            while (current.next != null) { //the last node is the one with next = null
                current = current.next;
            }
            current.next = node;
        }
    }

    public String toString() {

        Node<E> current = head; //traversal starts at the front
        String result = ""; //result starts empty

        while (current != null) {  //keep going until there's no more nodes to point to
            result = result + current.data.toString() + "\n";
            current = current.next; //move over to next node
        }
        return result;
    }

    public boolean contains(E target) {
        if (isEmpty()) {  //empty lists can't contain the target
            return false;
        }

        boolean found = false;
        Node<E> current = head; //traversal starts at the front

        while ((current != null) && (!found)) {
            if (target.equals(current.data)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    public E removeFromFront(){
        if (isEmpty()) {  //empty lists can't remove item
            return null;
        }
        E removedData = head.data; //define generic variable E that represents data to remove
        //reassign head to the next node of the linkedlist
        head = head.next;
        // return node to remove
        return removedData;
    }

    public E removeFromRear(){
        E removedData; // define generic to return removed item
        if (isEmpty()) {  //empty lists can't remove item
            removedData = null; // no data to remove
        }
        else if(head.next == null){ // if else linkedlist has one node
            removedData = head.data; // store one item that will be removed
            head = null; //point head to null, to remove single item for garbage collection
        }
        else{ // else linked list has more than one node
            Node<E> current = head; //traversal starts at the front
            // Traverse the linkedList until SECOND TO LAST node
            while ((current.next.next != null)) {
                current = current.next; // set current to second to last node
            }
            removedData = current.next.data; //define new E object, stores data from last node of linkedList to remove
            current.next = null; // Set current to next null to actually remove the node, will be garbage collected
        }
        return removedData; // return node to remove
    }

    public static void main(String[] args) {
        GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
        favBabySongs.addToFront("Humpty Dumpty");
        favBabySongs.addToRear("Swing Low Sweet Chariot");
        favBabySongs.addToFront("Itsy Bitsy Spider");
        favBabySongs.addToRear("Twinkle, Twinkle Little Star");
        favBabySongs.addToFront("Wheels on the Bus");
        System.out.println(favBabySongs.toString());
        System.out.println(favBabySongs.contains("Humpty Dumpty"));
        System.out.println(favBabySongs.contains("Baby Shark"));
        favBabySongs.removeFromFront();
        System.out.println(favBabySongs.toString());
        favBabySongs.removeFromRear();
        System.out.println(favBabySongs.toString());
    }
}