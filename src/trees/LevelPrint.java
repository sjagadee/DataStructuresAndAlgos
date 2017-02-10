package trees;


import sun.misc.Queue;

/**
 * Created by srinivas on 2/10/17.
 *
 * Level print can be done using 2 queues
 * or also can be done using one queue and a delimiter
 */
public class LevelPrint {

    private static void levelPrintTwoQueues(TreeNode root) throws InterruptedException {
        Queue<TreeNode> q1 = new Queue<>();
        Queue<TreeNode> q2 = new Queue<>();

        TreeNode current = root;
        q1.enqueue(root);

        while(!q1.isEmpty() || !q2.isEmpty()) {
            while(!q1.isEmpty()) {
                current = q1.dequeue();
                System.out.print(current.data + " ");
                if(current.leftChild != null) {
                    q2.enqueue(current.leftChild);
                }
                if(current.rightChild != null) {
                    q2.enqueue(current.rightChild);
                }
            }
            System.out.println();

            while(!q2.isEmpty()) {
                current = q2.dequeue();
                System.out.print(current.data + " ");
                if(current.leftChild != null) {
                    q1.enqueue(current.leftChild);
                }
                if(current.rightChild != null) {
                    q1.enqueue(current.rightChild);
                }
            }
            System.out.println();
        }
    }

    private static void levelPrintQueueAndDelimt(TreeNode root) throws InterruptedException {
        Queue<TreeNode> q = new Queue<>();
        TreeNode current = root;
        q.enqueue(root);
        q.enqueue(null);
        while(!q.isEmpty()) {
            current = q.dequeue();
            if(current != null) {
                System.out.print(current.data + " ");
                if(current.leftChild != null) {
                    q.enqueue(current.leftChild);
                }
                if(current.rightChild != null ) {
                    q.enqueue(current.rightChild);
                }
            } else if(current == null && !q.isEmpty()) {
                q.enqueue(null);
                System.out.println();
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

        levelPrintTwoQueues(root);

        System.out.println("\n");

        levelPrintQueueAndDelimt(root);
    }
}
