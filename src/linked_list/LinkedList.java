package linked_list;

/**
 * Created by srinivas on 1/27/17.
 *
 * Implementation of the basic method are done here in the LinkedList Class
 *
 * Operations implemented are:
 * 1. insertAtTop
 * 2. insertAtTail
 * 3. deleteNode
 * 4. getHead
 * 5. printData
 * 6. getLength
 * 7. toString() - prints data
 */
public class LinkedList {

    private Node head;

    // Insert at the top of the list
    public void insertAtTop(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    // Insert at at the tail of the list
    public Node insertAtTail(int data) {
        Node newNode = new Node(data);
        Node temp = this.head;

        if(temp == null){
            this.head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }

    // Delete an element a node
    public Node deleteNode(int data) {
        Node temp = this.head;

        // if head == null
        if(temp == null) {
            return null;
        }

        // If node to delete is first element
        if(temp.data == data && temp.next != null) {
            head = head.next;
            return head;
        }
        // If the list has only one element
        else if (temp.data == data && temp.next == null) {
            head = null;
            return head;
        }

        while(temp.next != null) {
            // If the node to delete is last element
            if(temp.next.data == data && temp.next.next == null) {
                temp.next = null;
            }
            // If node to delete is somewhere in the middle of the list
            else if (temp.next.data == data && temp.next.next != null) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    // Get head node
    public Node getHead(){
        return this.head != null ? this.head : null;
    }

    // Print the data in the list
    public void printData() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // get the length of the list
    public int getLength() {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    // Print the elements of a Node ()
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Node current =  this.head;
        while(current != null) {
            result.append("List: { Data: " + current.getData() + " ");
            current = current.next;
        }

        result.append("}");
        return result.toString();
    }
}
