package linked_list;

/**
 * Created by srinivas on 1/27/17.
 *
 * Basic Node class
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
