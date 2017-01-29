package linked_list;

import java.util.Stack;

/**
 * Created by srinivas on 1/28/17.
 *
 * In this class we are checking if the data present is palindrome or not,
 * There are two ways to solve this:
 *
 * 1. Without Stack - time complexity : O(N*N) - space complexity - O(1)
 * 2. With Stack - time complexity : O(N) - space complexity - O(N/2)
 */
public class PalindromeLinkedList {

    private static LinkedList list = new LinkedList();

    public static boolean isPalindromeWithStack(Node head) {
        Node slow = head;
        Node fast = head;

        Stack<Integer> stack = new Stack<>();

        // if the fast pointer is either null or if fast pointer next is null we dd not enter
        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // if there are odd number of elements we would have slow pointing at middle element
        // hence we need to move it one node further so that we can test it against stack data
        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            int popData = stack.pop().intValue();
            if(popData == slow.data) {
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(Node head) {
        Node first = head;
        Node last = head;
        int count = 1;
        int length = list.getLength();
        int mid = length/2;
        int curLast = length;
        int isLast = 1;
        boolean isPalindrome = true;

        while(count <= mid && isPalindrome == true) {
            while(isLast < curLast){
                last = last.next;
                isLast++;
            }
            if(first.data != last.data) {
                isPalindrome = false;
            } else {
                count++;
                curLast--;
                isLast = 1;
                last = head;
                first = first.next;
            }
        }

        if(isPalindrome) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        list.insertAtTail(0);
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(1);
        list.insertAtTail(0);

        Node head = list.getHead();

        boolean result1 = isPalindrome(head);
        boolean result = isPalindromeWithStack(head);


        if(result ) {
            System.out.println("Palindrome (with stack)");
        } else {
            System.out.println("Not Palindrome (with stack)");
        }

        if (result1) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
