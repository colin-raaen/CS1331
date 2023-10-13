import java.util.NoSuchElementException;
public class LinkedList<T extends List<T>> {
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

    // Could be more abstract method to implement in order to implement List<T> interface

    public void addAtIndex(T data, int index){
        if (index < 0 || index >= size){ // if index int is out of bounds of lenght of linkedlist
            throw new IllegalArgumentException("Your index is out of the list bounds"); // throw error message
        }
        if (data == null){ // If data variable is null
            throw new IllegalArgumentException("You cannot add null data to the list"); // throw error message
        }

        Node<T> newNode = new Node<T>(data); // Call node constructor to create new node instance

        if (index == 0){ // if index is first node in the list
            newNode.setNext(head.getNext()); // set newNodes next value to first node, where head points to
            head.setNext(newNode); // reset head to point at newNode
        }
        else if (index == size - 1){ // if index is tail of the list
            // travese the linked list, stopping at last node of the linked list

            // set current last node's next value to the newNode value
        }
        else{ // index is not being inserted as head or tail, in middle of index
            //traverse the linkedlist to the index where to be inserted

                // set newNode next value

                // set old next value to point at newNode to finish insertion

        }
    };
}