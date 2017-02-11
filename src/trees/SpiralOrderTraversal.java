package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by srinivas on 2/10/17.
 * <p>
 * using 2 stacks
 * using deque 
 */
public class SpiralOrderTraversal {
    private static void spiralOrderWithTwoStacks(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode current = root;
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                current = stack1.pop();
                if (current.leftChild != null) {
                    stack2.push(current.leftChild);
                }
                if (current.rightChild != null) {
                    stack2.push(current.rightChild);
                }
                System.out.print(current.data + " ");
            }

            while (!stack2.isEmpty()) {
                current = stack2.pop();
                if (current.rightChild != null) {
                    stack1.push(current.rightChild);
                }
                if (current.leftChild != null) {
                    stack1.push(current.leftChild);
                }

                System.out.print(current.data + " ");
            }
        }
    }

    private static void spiralOrderUsingDeque(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        boolean check = true;

        TreeNode current = root;
        dq.addFirst(null);
        dq.addFirst(root);
        while (!dq.isEmpty()) {
            if (check == true) {
                current = dq.pollFirst();
                if (current != null) {
                    System.out.print(current.data + " ");
                    if (current.leftChild != null) {
                        dq.addLast(current.leftChild);
                    }
                    if (current.rightChild != null) {
                        dq.addLast(current.rightChild);
                    }
                }
            } else {
                current = dq.pollLast();
                if(current != null) {
                    System.out.print(current.data + " ");
                    if (current.rightChild != null) {
                        dq.addFirst(current.rightChild);
                    }
                    if (current.leftChild != null) {
                        dq.addFirst(current.leftChild);
                    }
                }

            }


            if (current == null && !dq.isEmpty()) {
                if (check) {
                    check = false;
                    dq.addFirst(null);
                } else {
                    check = true;
                    dq.addLast(null);
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BSTDemo bst = new BSTDemo();
        TreeNode root = bst.insert(null, 25);
        bst.insert(root, 20);
        bst.insert(root, 35);
        bst.insert(root, 18);
        bst.insert(root, 22);
        bst.insert(root, 30);
        bst.insert(root, 40);
        bst.insert(root, 12);
        bst.insert(root, 28);
        bst.insert(root, 42);

        spiralOrderWithTwoStacks(root);
        System.out.println();
        spiralOrderUsingDeque(root);
    }


}
