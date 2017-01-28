package linked_list;

import java.util.HashSet;

/**
 * Created by srinivas on 1/28/17.
 *
 * This class would have the method to remove duplicates in two ways
 *
 * 1. Using hash set - Time Complexity O(N), Space Complexity O(N)
 * 2. Without using hash set - Time Complexity O(N*N), Space Complexity O(1)
 */
public class RemoveDuplicates {

    // This method uses Hash Set and removes duplicate
    public static void deleteDuplicatesWithHashSet(Node head) {
        if(head == null) {
            return;
        }

        // Creating hash set (hash set is a data structure which would not have duplicates)
        HashSet<Integer> set = new HashSet<>();
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            // we check if the set contains elements that are being added to the set
            // if the set already has the data, then the prev would point the temp's next node
            if(set.contains(temp.data)){
                prev.next = temp.next;
            } else {
                set.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
    }

    // This method would remove duplicates without using a buffer (Hash set)
    // This uses less memory O(1), but would be slow as the time complexity is O(N*N)
    public static void deleteDuplicatesWithoutHashSet(Node head) {
        if(head == null) {
            return;
        }

        Node slow = head;
        while(slow != null) {
            Node fast = slow;
            while(fast.next != null) {
                if(slow.data == fast.next.data) {
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        LinkedList list = new LinkedList();

        list.insertAtTail(11);
        list.insertAtTail(13);
        list.insertAtTail(14);
        list.insertAtTail(11);
        list.insertAtTail(12);
        list.insertAtTail(15);
        list.insertAtTail(11);
        list.insertAtTail(16);
        list.insertAtTail(13);

        System.out.println("Removing Duplicates using Hash Set");
        System.out.println("Before removing duplicates:");
        list.printData();

        // get the head node
        head = list.getHead();

        System.out.println("After removing duplicates:");
        deleteDuplicatesWithHashSet(head);
        list.printData();

        list.deleteNode(11);
        list.deleteNode(13);
        list.deleteNode(14);
        list.deleteNode(12);
        list.deleteNode(16);

        System.out.println("Removing Duplicates without using Hash Set (No Buffer)");
        System.out.println("Before removing duplicates:");

        list.insertAtTail(11);
        list.insertAtTail(13);
        list.insertAtTail(14);
        list.insertAtTail(11);
        list.insertAtTail(12);
        list.insertAtTail(15);
        list.insertAtTail(11);
        list.insertAtTail(16);
        list.insertAtTail(13);

        list.printData();

        // get the head node
        head = list.getHead();

        System.out.println("After removing duplicates:");
        deleteDuplicatesWithoutHashSet(head);
        list.printData();

    }
}
