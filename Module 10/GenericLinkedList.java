public class GenericLinkedList<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head;
    public GenericLinkedList() {
        head = null;
    }
    public void kindLatin() {
        Node<E> current = head;
        while (current  != null) {
            System.out.println(current.data.toString() + "pls");
            current = current.next;
        }
    }

    public void addToFront(E newData) {
        head = new Node<E>(newData, head);
    }

    public static void main(String[] args) {
        GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
        favBabySongs.addToFront("pisa");
        favBabySongs.addToFront("milan");
        favBabySongs.addToFront("venice");
        favBabySongs.addToFront("rome");

        favBabySongs.kindLatin();
    }
}