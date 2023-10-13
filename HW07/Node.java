public class Node<T> {
    private T data; // Generic instance vairable that holds data of node
    private Node<T> next; // Generic instance variable of type Node holds pointer information to next Node in LinkedList

    Node(T data, Node<T> next) { // More specific constructor that takes in data and pointer to next Node
        this.data = data;
        this.next = next;
    }

    Node(T data) { // less specific constructor that takes in data and pointer to next Node
        this(data, null); // chain to first constructor, with Next set to null
    }

    public T getData(){ // Getter method for data
        return data;
    }

    public Node<T> getNext(){ // Getter method for Next instance variable
        return next;
    }

    public void setData(T newData){ // Getter method for data
        data = newData; // set current data variable
    }

    public void setNext(Node<T> setNode){ // Getter method for Next instance variable
        next = setNode; // set current next variable
    }
}