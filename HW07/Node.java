public class Node<E> {
    E data; // Generic instance vairable that holds data of node
    Node<E> next; // Generic instance variable of type Node holds pointer information to next Node in LinkedList

    Node(E data, Node<E> next) { // More specific constructor that takes in data and pointer to next Node
        this.data = data;
        this.next = next;
    }

    Node(E data) { // less specific constructor that takes in data and pointer to next Node
        this(data, null); // chain to first constructor, with Next set to null
    }

    public E getData(){ // Getter method for data
        return data;
    }

    public Node<E> getNext(){ // Getter method for Next instance variable
        return next;
    }
}