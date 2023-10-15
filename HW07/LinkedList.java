import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T> {
    private Node<T> head; // Generic instance variable of type Node which represents head of LinkedLIst
    private Node<T> tail; // Generic instance variable of type Node which represents tail of LinkedLIst
    private int size; // Int variable that repreents the size of the LinkedList

    public LinkedList(){ // No args constructor that creates instance of a linkedlist
        this.head = null; // set head to null
        this.tail = null; // set tail to null
        this.size = 0; // set size to 0
    }

    public Node<T> getHead(){ // Getter method for data
        return head;
    }

    public Node<T> getTail(){ // Getter method for data
        return tail;
    }

    /**
     * Adds the passed in data to the specified index.
     * @param data  the data to add to the List
     * @param index the index to add at
     */
    public void addAtIndex(T data, int index){
        if (index < 0 || index > size){ // if index int is out of bounds of lenght of linkedlist
            throw new IllegalArgumentException("Your index is out of the list bounds"); // throw error message
        }
        if (data == null){ // If data variable is null
            throw new IllegalArgumentException("You cannot add null data to the list"); // throw error message
        }

        Node<T> newNode = new Node<T>(data); // Call node constructor to create new node instance to be inserted

        if (index == 0){ // if index is 0 to insert as first node in the list
            if (head != null){ // if head isn't null, than at least one node already exists
                newNode.setNext(head); // set newNodes next value to current first node, where head points to
            }
            head = newNode; // reset head to point at newNode
            // if statement to check if size of linkedList is zero to set tail
            if (size == 0){ // if size is zero
                tail = newNode; // set tail to newNode
            }
        }
        else if (index > 0 && index == size){ // if index is tail of the list, that has at least one node
            Node<T> current = head; // new node to track current node as it traverses
            // travese the linked list, stopping at last node of the linked list
            while (current.getNext() != null) { // the last node is the Node with next = null
                current = current.getNext();
            }
            // set current last node's next value to the newNode value
            current.setNext(newNode);
            tail = newNode; // set tail to newNode
        }
        else{ // index is not being inserted as head or tail, in middle of index
            Node<T> current = head; // new node to track current node as it traverses
            int indexPosition = 0; // integer to store current position of linkedlist when traversing
            //traverse the linkedlist to the index where to be inserted
            while (indexPosition != index - 1) { // the last node is the Node with next = null
                current = current.getNext();
                indexPosition++;
            }
            newNode.setNext(current.getNext()); // set newNode next value to current's next value
            current.setNext(newNode); // set old next value to point at newNode to finish insertion
        }
        size++; // increment size of LinkedList
        return; // exit method so other if-else statements don't evaluate to true
    }

    /**
     * Retrieves the data of the node that's specified.
     * @param index the index of the node whose data we are retrieving
     */
    public T getAtIndex(int index){
        if (index < 0 || index >= size){ // if index int is out of bounds of lenght of linkedlist
            throw new IllegalArgumentException("Your index is out of the list bounds"); // throw error message
        }

        Node<T> current = head; // new node to track current node as it traverses
        int indexPosition = 0; // integer to store current position of linkedlist when traversing

        //traverse the linkedlist to the index where to be inserted
        while (indexPosition != index) { // the last node is the Node with next = null
            current = current.getNext();
            indexPosition++;
        }
        return current.getData(); // return data from current index position
    }

    /**
     * Removes the data at the specified index and returns the data that was removed.
     * @param index removes the Node at this index
     */
    public T removeAtIndex(int index){
        if (index < 0 || index >= size){ // if index int is out of bounds of lenght of linkedlist
            throw new IllegalArgumentException("Your index is out of bounds"); // throw error message
        }
        if (isEmpty()) {  //empty lists can't remove item
            return null; // no data to remove
        }

        T removedData; // define generic to return removed item

        // if linkedlist has only one node
        if (index == 0 && head.getNext() == null){
            removedData = head.getData(); // store one item that will be removed
            head = null; //point head to null, to remove single item for garbage collection
            tail = null; //point tail to null

            size--; // decrement size of linkedList
            return removedData; // exit method
        }
        // else, if deleting the head of the linkedlist, and more than one node
        else if (index == 0 && head.getNext() != null){
            removedData = head.getData(); // store one item that will be removed
            head = head.getNext(); //point head to Node one past index position
        }

        // else, Node is not the head and linked list has more than one node
        Node<T> current = head; //traversal starts at the front
        int indexPosition = 0; // integer to store current position of linkedlist when traversing

        // Traverse the linkedList until either two nodes before node to delete or SECOND TO LAST node if tail
        while ((indexPosition < index - 1 || current.getNext().getNext() != null)) { // set current to second to last node
            current = current.getNext();
            indexPosition++; // increment counter
        }

        removedData = current.getNext().getData(); // stores data from last node of linkedList to remove

        if (current.getNext().getNext() == null){ // current node to be deleted is the tail of the linkedList
            current.setNext(null); // Set current to next null to actually remove the node, will be garbage collected
            tail = current; // Set tail to second to last node which is now last node after removal
        }
        else { // node to be deleted is not the tail
            removedData = current.getNext().getData(); //define new E object, stores data from last node of linkedList to remove
            current.setNext(current.getNext().getNext()); // Set current next point to the node past the node to delete
        }

        size--; // decrement size of linkedList
        return removedData; // return node to remove
    }

    /**
     * Removes the Node with the data passed in if a Node containing the data exists.
     * @param data the data to remove from the List
     */
    public T remove(T data){
        if (data == null) { // If data variable is null
            throw new IllegalArgumentException("You cannot remove null data from the list"); // throw error message
        }
        if (isEmpty()) {  //empty lists can't contain the target
            return null;
        }

        T removedData = null; // define generic to return removed item

        boolean dataFound = false; // boolean to assess if data has been found in LinkedList
        Node<T> current = head; // Node to traverse, traversal starts at the front

        while ((current != null) && (!dataFound)) { // traverse linkedList until the end or the data is found
            if (data.equals(current.getData())) { // data equals current node
                removedData = current.getData();
                // if node to remove is the tail node
                dataFound = true; // set boolean to true, found
            } else { // move to the next node
                current = current.getNext();
            }
        }
        // after traversal, if data was not found
        if (removedData == null){
            throw new NoSuchElementException("The data is not present in the list."); // throw error message
        }
        size--; // decrement size of linkedList
        return removedData; // return method with removedData if found, else null
    }

    /**
     * Clears the LinkedList - garbage collection is your friend here.
     * THIS SOLUTION SHOULD CAN BE O(1)
     */
    public void clear(){
        if (head == null){
            return; // there is no list to clear
        }
        else{
            head = null; // point head to null, to remove the entire linkedList for garbage collection
            size = 0; // set size of linkedlist to 0
            return;
        }
    }

    /**
     * Checks whether the LinkedList is empty or not.
     * @return boolean value indicating whether it's empty or not
     */
    public boolean isEmpty(){
        if (head == null){ // if head isn't null, than at least one node already exists
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the List
     * @return integer size of the list
     */
    public int size(){
        return size;
    }
}