package linked_list;

/**
 * Created by srinivas on 1/27/17.
 *
 * Basic Node class
 */
public class Node {
    int data;
    Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
