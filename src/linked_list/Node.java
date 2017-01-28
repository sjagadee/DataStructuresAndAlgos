package linked_list;

/**
 * Created by srinivas on 1/27/17.
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Data: " + this.data;
    }
}
